package clinicForRSQ.clinic.Doctor

import clinicForRSQ.clinic.Visit.Visit
import clinicForRSQ.clinic.Visit.VisitService
import org.springframework.stereotype.Service

@Service
class DoctorService (val repo : DoctorRepo, val visitService: VisitService){
    fun tryAddDoctor(doctor: Doctor) = repo.save(doctor)
    fun tryGetAllDoctors() = repo.findAll().toList()
    fun tryPutDoctor(doctor: Doctor) = repo.save(doctor)
    fun tryDeleteDoctor(id: Long) {

    var deleteVisits: List<Visit> = visitService.tryFindPatientVisits(id)
    visitService.tryDeleteVisits(deleteVisits)
    repo.deleteById(id)}
}