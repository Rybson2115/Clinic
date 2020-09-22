package clinicForRSQ.clinic.Visit


import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VisitRepo: CrudRepository<Visit, Long> {
    fun findByVisitId(id : Long) : Visit
    fun deleteByVisitId(id: Long) : Visit
}
