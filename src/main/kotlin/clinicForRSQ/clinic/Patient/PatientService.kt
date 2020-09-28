package clinicForRSQ.clinic.Patient

import org.springframework.stereotype.Service

@Service
class PatientService(val repo : PatientRepo){

    fun TryAddPatient(patient: Patient) = repo.save(patient)
    fun TryGetAllPatients() = repo.findAll().toList()
    fun TryPutPatient(patient: Patient) = repo.save(patient)
    fun TryDeletePatient(id: Long) = repo.deleteById(id)

}