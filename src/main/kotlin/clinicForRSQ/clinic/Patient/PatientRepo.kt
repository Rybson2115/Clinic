package clinicForRSQ.clinic.Patient

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepo : CrudRepository<Patient, Long>
{
    fun deletePatientById(id : Long) : Patient
}