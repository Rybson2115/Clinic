package clinicForRSQ.clinic.Patient

import clinicForRSQ.clinic.Visit.Visit
import javax.persistence.*


@Entity
class Patient (
        @Id @GeneratedValue /*@OneToMany(mappedBy = "Patient")*/ var id: Long,
        var name: String,
        var surname: String,
        var address: String


)