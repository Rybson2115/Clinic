package clinicForRSQ.clinic.Doctor

import javax.persistence.*

@Entity
class Doctor (
        @Id @GeneratedValue private var id: Long,
        private var name: String,
        private var surname: String,
        @Enumerated(EnumType.STRING) private var specialization: DoctorSpecialization

)