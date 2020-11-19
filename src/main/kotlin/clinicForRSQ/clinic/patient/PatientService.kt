package clinicForRSQ.clinic.patient

import clinicForRSQ.clinic.patient.dto.PatientDTO
import clinicForRSQ.clinic.visit.Visit
import clinicForRSQ.clinic.visit.VisitService
import org.springframework.stereotype.Service
import javax.xml.bind.DatatypeConverter.parseLong

@Service
class PatientService(val repo : PatientRepo,
                     val visitService: VisitService){

    fun tryAddPatient(patientDTO: PatientDTO): PatientDTO {
        checkPesel(patientDTO.pesel)
        val patient: Patient = Patient(patientDTO)
        return repo.save(patient).toPatientDTO()
    }

    fun tryGetAllPatients() = repo.findAll().toList()

    fun tryPutPatient(patientDTO: PatientDTO): PatientDTO{
        val patient: Patient = Patient(patientDTO)
        return repo.save(patient).toPatientDTO()
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
    fun checkPesel(pesel : String){

        if(pesel.length == 11){
            try{
                val num = parseLong(pesel)
            }catch (e: NumberFormatException){
                throw Exception("Letters in pesel!")
            }

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
            val controlNumber : Int = 1*a + 3*b + 7*c + 9*d + 1*e + 3*f + 7*g + 9*h + 1*i + 3*j + 1*k
            if(controlNumber < 9 || controlNumber%10 != 0)
                throw Exception("Incorrect pesel!")
        }
        else
        throw Exception("Incorrect lenght pesel!")
    }
}