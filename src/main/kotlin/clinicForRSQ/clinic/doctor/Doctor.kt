package clinicForRSQ.clinic.doctor

import clinicForRSQ.clinic.doctor.dto.DoctorDTO
import javax.persistence.*

@Entity
class Doctor (
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        var name: String,
        var surname: String,
        @Enumerated(EnumType.STRING) var specialization: DoctorSpecialization

){
    constructor(doctorDTO: DoctorDTO) : this (
            id = doctorDTO.id,
            name = doctorDTO.name,
            surname= doctorDTO.surname,
            specialization = doctorDTO.specialization

    )

    fun toDoctorDTO() = DoctorDTO(
            id = id,
            name = name,
            surname = surname,
            specialization = specialization
    )
}
enum class DoctorSpecialization{
    DENTIST,
    PHYSIOTHERAPIST,
    INTERNIST,
    ALLERGIST,
    CARDIOLOGIST
}
