package clinicForRSQ.clinic.Doctor

import clinicForRSQ.clinic.Patient.Patient

class DoctorService (val repo : DoctorRepo){
    fun TryAddDoctor(doctor: Doctor) = repo.save(doctor)
    fun TryGetAllDoctors() = repo.findAll().toList()
    fun TryPutDoctor(doctor: Doctor) = repo.save(doctor)
    fun TryDeleteDoctor(id: Long) = repo.deleteById(id)

}