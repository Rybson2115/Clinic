package clinicForRSQ.clinic.patient

import javax.persistence.*

@Entity
class Patient (
        @Id @GeneratedValue var id: Long,
        var name: String,
        var surname: String,
        var address: String
)