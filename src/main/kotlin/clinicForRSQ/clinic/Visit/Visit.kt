package clinicForRSQ.clinic.Visit

import clinicForRSQ.clinic.Patient.Patient
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
class Visit (
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        var room: Int =0,
        @ManyToOne /*(fetch = FetchType.LAZY)*/
        @JoinColumn(name = "Patient",referencedColumnName = "id") var patient : Long,
        var doctorId: Long,
        var date: LocalDate,
        var time: LocalTime


)