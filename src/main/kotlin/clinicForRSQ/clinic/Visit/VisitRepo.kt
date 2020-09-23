package clinicForRSQ.clinic.Visit


import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VisitRepo: CrudRepository<Visit, Long> {
    fun findVisitById(id : Long) : Visit
    fun deleteVisitById(id: Long) : Visit
}
