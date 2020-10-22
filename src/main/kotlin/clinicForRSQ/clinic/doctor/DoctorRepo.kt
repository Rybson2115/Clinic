package clinicForRSQ.clinic.doctor

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorRepo : CrudRepository<Doctor, Long> {

}