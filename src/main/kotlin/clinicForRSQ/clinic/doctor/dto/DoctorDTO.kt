package clinicForRSQ.clinic.doctor.dto

import clinicForRSQ.clinic.doctor.Doctor
import clinicForRSQ.clinic.doctor.toDoctorSpecialization
import javax.persistence.EnumType
import javax.persistence.Enumerated

class DoctorDTO (
    var id: Long,
    var name: String,
    var surname: String,
    @Enumerated(EnumType.STRING) var specialization: DoctorSpecializationDTO
)
enum class DoctorSpecializationDTO{
    DENTIST,
    PHYSIOTHERAPIST,
    INTERNIST,
    ALLERGIST,
    CARDIOLOGIST
}