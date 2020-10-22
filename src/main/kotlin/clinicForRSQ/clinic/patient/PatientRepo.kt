package clinicForRSQ.clinic.patient

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepo : CrudRepository<Patient, Long> {

}