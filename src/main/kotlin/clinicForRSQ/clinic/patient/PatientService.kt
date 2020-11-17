package clinicForRSQ.clinic.patient

import clinicForRSQ.clinic.patient.dto.PatientDTO
import clinicForRSQ.clinic.visit.Visit
import clinicForRSQ.clinic.visit.VisitService
import org.springframework.stereotype.Service

@Service
class PatientService(val repo : PatientRepo, val visitService: VisitService){

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
    fun checkPesel(pesel : String): Boolean{
        if(pesel.length == 11){
            val a : Int = pesel[0].toInt()
            val b : Int = pesel[1].toInt()
            val c : Int = pesel[2].toInt()
            val d : Int = pesel[3].toInt()
            val e : Int = pesel[4].toInt()
            val f : Int = pesel[5].toInt()
            val g : Int = pesel[6].toInt()
            val h : Int = pesel[7].toInt()
            val i : Int = pesel[8].toInt()
            val j : Int = pesel[9].toInt()
            val k : Int = pesel[10].toInt()

            //(1·a + 3·b + 7·c + 9·d + 1·e + 3·f + 7·g + 9·h + 1·i + 3·j + 1·k)%10 == 0 -> pesel correct
            val controlNumber : Int = 1*a + 3*b + 7*c + 9*d + 1*e + 3*f + 7*g + 9*h + 1*i + 3*j + 1*k;
            if(controlNumber > 1 && controlNumber%10 == 0)
                    return true
        }
        throw Exception("Incorrect pesel!")
    }
}