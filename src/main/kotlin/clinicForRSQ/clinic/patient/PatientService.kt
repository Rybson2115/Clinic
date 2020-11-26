package clinicForRSQ.clinic.patient

import clinicForRSQ.clinic.patient.dto.PatientDTO
import clinicForRSQ.clinic.visit.Visit
import clinicForRSQ.clinic.visit.VisitService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import javax.xml.bind.DatatypeConverter.parseLong

@Service
class PatientService(val repo : PatientRepo,
                     val visitService: VisitService){

    fun tryAddPatient(patientDTO: PatientDTO): PatientDTO {
        checkPesel(patientDTO.pesel)
        checkValues(patientDTO)
        val patient: Patient = Patient(patientDTO)
        return repo.save(patient).toPatientDTO()
    }

    fun tryGetAllPatients() = repo.findAll().toList()

    fun tryPutPatient(patientDTO: PatientDTO): PatientDTO{
        if(repo.existsById(patientDTO.id)) {
            var oldPatient: Patient? = Patient(0,"","","","")
            oldPatient = repo.findByIdOrNull(patientDTO.id)
            val newPatient: Patient = Patient(0,"","","","")
            if(oldPatient != null){
                if(patientDTO.name == "")
                newPatient.name = oldPatient.name
                else{
                    newPatient.name = patientDTO.name
                }

                if(patientDTO.surname == "")
                    newPatient.surname = oldPatient.surname
                else{
                    newPatient.surname = patientDTO.surname
                }

                if(patientDTO.address == "")
                    newPatient.address = oldPatient.address
                else{
                    newPatient.address = patientDTO.address
                }

                if(patientDTO.pesel == "")
                    newPatient.pesel = oldPatient.pesel
                else{
                    newPatient.pesel = patientDTO.pesel
                }

                newPatient.id = patientDTO.id
            return repo.save(newPatient).toPatientDTO()
            }
            else{
                throw Exception("No data for editing!")
            }
        }
        else
            throw Exception("Patient no exists!")
    }

    fun tryDeletePatient(id: Long) {
        if(repo.existsById(id)){
            val deleteVisits: List<Visit> = visitService.tryFindPatientVisits(id)
            visitService.tryDeleteVisits(deleteVisits)
            repo.deleteById(id)
        }
        else
            throw Exception("Patient no exists!")

    }
    fun checkValues(patient : PatientDTO){
        if(patient.name == "" || patient.name.length < 3)
            throw Exception("Name is empty or too short!")
        if(patient.surname == "" || patient.surname.length < 3)
            throw Exception("Surname is empty or too short!")
        if(patient.address == "" || patient.address.length < 5)
            throw Exception("Address is empty or too short!")
    }
    fun checkPesel(pesel : String){

        if(pesel.length == 11){
            try{
                val num = parseLong(pesel)
            }catch (e: NumberFormatException){
                throw Exception("Letters in pesel!")
            }
            val controlNumbers : IntArray = intArrayOf(1,3,7,9,1,3,7,9,1,3,1)
            var controlNumber : Int = 0
            for((index,value) in controlNumbers.withIndex()){
                controlNumber += Character.getNumericValue(pesel[index]) * controlNumbers[index]
            }
            /*
            val a : Int = Character.getNumericValue(pesel[0])
            val b : Int = Character.getNumericValue(pesel[1])
            val c : Int = Character.getNumericValue(pesel[2])
            val d : Int = Character.getNumericValue(pesel[3])
            val e : Int = Character.getNumericValue(pesel[4])
            val f : Int = Character.getNumericValue(pesel[5])
            val g : Int = Character.getNumericValue(pesel[6])
            val h : Int = Character.getNumericValue(pesel[7])
            val i : Int = Character.getNumericValue(pesel[8])
            val j : Int = Character.getNumericValue(pesel[9])
            val k : Int = Character.getNumericValue(pesel[10])

            //(1·a + 3·b + 7·c + 9·d + 1·e + 3·f + 7·g + 9·h + 1·i + 3·j + 1·k)%10 == 0 -> pesel correct
            val controlNumber : Int = 1*a + 3*b + 7*c + 9*d + 1*e + 3*f + 7*g + 9*h + 1*i + 3*j + 1*k */
            if(controlNumber < 9 || controlNumber%10 != 0)
                throw Exception("Incorrect pesel!")
        }
        else
        throw Exception("Incorrect lenght pesel!")
    }
}