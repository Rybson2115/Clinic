package clinicForRSQ.clinic.Patient

import org.springframework.stereotype.Service

@Service
class PatientService(val repo : PatientRepo){

    fun TryAddPatient(patient: Patient) = repo.save(patient)


}