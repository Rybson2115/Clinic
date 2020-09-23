package clinicForRSQ.clinic.Patient

import javax.persistence.*


@Entity
class Patient (
        @Id @GeneratedValue(strategy = GenerationType.AUTO) private var id: Long,
        private var name: String,
        private var surname: String,
        private var address: String
)