package clinicForRSQ.clinic.Visit

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
class Visit (
        @Id @GeneratedValue(strategy = GenerationType.AUTO) private var id: Long,
        private var room: Int =0,
        private var patientId: Long,
        private var doctorId: Long,
        private var date: LocalDate,
        private var time: LocalTime


)