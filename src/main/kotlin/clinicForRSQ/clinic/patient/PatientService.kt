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
        //checkValues(patientDTO)
        val patient: Patient = Patient(patientDTO)
        return repo.save(patient).toPatientDTO()
    }

    fun tryGetAllPatients() = repo.findAll().toList()

    fun tryPutPatient(patientDTO: PatientDTO): PatientDTO{
        if(repo.existsById(patientDTO.id)) {
            val oldPatient: Patient? = repo.findByIdOrNull(patientDTO.id)
            val newPatient: Patient = Patient(0,"","","","")
            if(oldPatient != null){
                if(patientDTO.name == "" && patientDTO.surname == "" && patientDTO.address == "" && patientDTO.pesel == "")
                    throw Exception("No data for editing!")

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
//    fun checkValues(patient : PatientDTO){
//        if(patient.name == "" || patient.name.length < 3)
//            throw Exception("Name is empty or too short!")
//        if(patient.surname == "" || patient.surname.length < 3)
//            throw Exception("Surname is empty or too short!")
//        if(patient.address == "" || patient.address.length < 5)
//            throw Exception("Address is empty or too short!")
//    }
    fun checkPesel(pesel : String){

        if(pesel.length == 11){
            try{
                parseLong(pesel)
            }catch (e: NumberFormatException){
                throw Exception("Letters in pesel!")
            }
            val controlNumbers : IntArray = intArrayOf(1,3,7,9,1,3,7,9,1,3,1)
            var controlNumber : Int = 0
            for((index) in controlNumbers.withIndex()){
                controlNumber += Character.getNumericValue(pesel[index]) * controlNumbers[index]
            }
            if(controlNumber < 9 || controlNumber%10 != 0)
                throw Exception("Incorrect pesel!")
        }
        else
        throw Exception("Incorrect pesel length!")
    }
}