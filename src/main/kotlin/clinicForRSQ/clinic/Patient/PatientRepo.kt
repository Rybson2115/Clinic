package clinicForRSQ.clinic.Patient

import clinicForRSQ.clinic.Visit.Visit
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepo : CrudRepository<Patient, Long>
{
    @Query("select v from Visit v where v.patient.id = ?1")
    fun deletePatientVisits( patient: Long) : List<Visit>
}