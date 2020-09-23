package clinicForRSQ.clinic.Doctor


import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorRepo : CrudRepository<Doctor, Long>
{
    fun deleteDoctorById(id : Long) : Doctor
}