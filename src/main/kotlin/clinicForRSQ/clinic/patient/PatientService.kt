package clinicForRSQ.clinic.patient

import clinicForRSQ.clinic.visit.Visit
import clinicForRSQ.clinic.visit.VisitService
import org.springframework.stereotype.Service

@Service
class PatientService(val repo : PatientRepo, val visitService: VisitService){

    fun tryAddPatient(patient: Patient) = repo.save(patient)

    fun tryGetAllPatients() = repo.findAll().toList()

    fun tryPutPatient(patient: Patient) = repo.save(patient)

    fun tryDeletePatient(id: Long) {
        var deleteVisits: List<Visit> = visitService.tryFindPatientVisits(id)
        visitService.tryDeleteVisits(deleteVisits)
        repo.deleteById(id)
    }
}