package clinicForRSQ.clinic.patient

import clinicForRSQ.clinic.patient.dto.PatientDTO
import clinicForRSQ.clinic.visit.Visit
import clinicForRSQ.clinic.visit.VisitService
import org.springframework.stereotype.Service

@Service
class PatientService(val repo : PatientRepo, val visitService: VisitService){

    fun tryAddPatient(patientDTO: PatientDTO): PatientDTO {
        val patient: Patient = Patient(patientDTO)
        return repo.save(patient).toPatientDTO()
    }

    fun tryGetAllPatients() = repo.findAll().toList()

    fun tryPutPatient(patientDTO: PatientDTO): PatientDTO{
        val patient: Patient = Patient(patientDTO)
        return repo.save(patient).toPatientDTO()
    }

    fun tryDeletePatient(id: Long) {
        var deleteVisits: List<Visit> = visitService.tryFindPatientVisits(id)
        visitService.tryDeleteVisits(deleteVisits)
        repo.deleteById(id)
    }
}