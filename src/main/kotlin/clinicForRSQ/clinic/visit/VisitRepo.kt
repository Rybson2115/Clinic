package clinicForRSQ.clinic.visit

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface VisitRepo: CrudRepository<Visit, Long> {

    @Query("select v from Visit v where v.patient.id = ?1")
    fun findPatientVisitById(patient: Long): List<Visit>

    @Query("select v from Visit v where v.doctor.id = ?1")
    fun findDoctorVisitById(doctor: Long): List<Visit>

    @Query("select v from Visit v where v.doctor.id = ?1 and v.date = ?2")
    fun findDoctorVisitByDate(doctor: Long, date: LocalDate)
}
