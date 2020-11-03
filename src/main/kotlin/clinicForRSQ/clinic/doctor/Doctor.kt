package clinicForRSQ.clinic.doctor

import javax.persistence.*

@Entity
class Doctor (
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        var name: String,
        var surname: String,
        @Enumerated(EnumType.STRING) var specialization: DoctorSpecialization

)

enum class DoctorSpecialization{
    DENTIST,
    PHYSIOTHERAPIST,
    INTERNIST,
    ALLERGIST,
    CARDIOLOGIST
}