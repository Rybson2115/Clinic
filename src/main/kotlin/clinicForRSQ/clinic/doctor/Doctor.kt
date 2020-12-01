package clinicForRSQ.clinic.doctor

import clinicForRSQ.clinic.doctor.dto.DoctorDTO
import clinicForRSQ.clinic.doctor.dto.DoctorSpecializationDTO
import com.sun.istack.NotNull
import javax.persistence.*

@Entity
class Doctor (
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        @NotNull var name: String,
        @NotNull var surname: String,
        @Enumerated(EnumType.STRING) var specialization: DoctorSpecialization

){
    constructor(doctorDTO: DoctorDTO) : this (
            id = doctorDTO.id,
            name = doctorDTO.name,
            surname= doctorDTO.surname,
            specialization = doctorDTO.specialization.toDoctorSpecialization()

    )

    fun toDoctorDTO() = DoctorDTO(
            id = id,
            name = name,
            surname = surname,
            specialization = specialization.toDoctroSpecializationDTO()
    )
}
enum class DoctorSpecialization{
    DENTIST,
    PHYSIOTHERAPIST,
    INTERNIST,
    ALLERGIST,
    CARDIOLOGIST

}

fun DoctorSpecializationDTO.toDoctorSpecialization(): DoctorSpecialization =
        when(this){
            DoctorSpecializationDTO.DENTIST -> DoctorSpecialization.DENTIST
            DoctorSpecializationDTO.PHYSIOTHERAPIST -> DoctorSpecialization.PHYSIOTHERAPIST
            DoctorSpecializationDTO.INTERNIST -> DoctorSpecialization.INTERNIST
            DoctorSpecializationDTO.ALLERGIST -> DoctorSpecialization.ALLERGIST
            DoctorSpecializationDTO.CARDIOLOGIST -> DoctorSpecialization.CARDIOLOGIST
        }
fun DoctorSpecialization.toDoctroSpecializationDTO(): DoctorSpecializationDTO =
        when(this){
            DoctorSpecialization.DENTIST -> DoctorSpecializationDTO.DENTIST
            DoctorSpecialization.PHYSIOTHERAPIST -> DoctorSpecializationDTO.PHYSIOTHERAPIST
            DoctorSpecialization.INTERNIST -> DoctorSpecializationDTO.INTERNIST
            DoctorSpecialization.ALLERGIST -> DoctorSpecializationDTO.ALLERGIST
            DoctorSpecialization.CARDIOLOGIST -> DoctorSpecializationDTO.CARDIOLOGIST
        }

