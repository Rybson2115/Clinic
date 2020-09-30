package clinicForRSQ.clinic.Visit


import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VisitRepo: CrudRepository<Visit, Long> {

    @Query("select v from Visit v where v.patient.id = ?1")
    fun findPatientVisitById(patient: Long): List<Visit>

    @Query("select v from Visit v where v.doctor.id = ?1")
    fun findDoctortVisitById(doctor: Long): List<Visit>

}
