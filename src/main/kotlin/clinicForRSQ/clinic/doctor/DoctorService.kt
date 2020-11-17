package clinicForRSQ.clinic.doctor

import clinicForRSQ.clinic.doctor.dto.DoctorDTO
import clinicForRSQ.clinic.visit.Visit
import clinicForRSQ.clinic.visit.VisitService
import org.springframework.stereotype.Service

@Service
class DoctorService (val repo : DoctorRepo, val visitService: VisitService){

    fun tryAddDoctor(doctorDTO: DoctorDTO): DoctorDTO {
        val doctor: Doctor = Doctor(doctorDTO)
        return repo.save(doctor).toDoctorDTO()
    }

    fun tryGetAllDoctors() = repo.findAll().toList()

    fun tryPutDoctor(doctorDTO: DoctorDTO): DoctorDTO {
        val doctor: Doctor = Doctor(doctorDTO)
        return repo.save(doctor).toDoctorDTO()
    }
    fun tryDeleteDoctor(id: Long) {
        if(repo.existsById(id)){
            val deleteVisits: List<Visit> = visitService.tryFindPatientVisits(id)
            visitService.tryDeleteVisits(deleteVisits)
            repo.deleteById(id)
        }
        else
            throw Exception("Doctor no exists!")
    }
}