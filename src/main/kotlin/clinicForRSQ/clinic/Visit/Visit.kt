package clinicForRSQ.clinic.Visit

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
class Visit (
        @Id @GeneratedValue private var id: Long,
        private var room: Int =0,
        /*@ManyToOne @JoinColumn */private var patientId: Long, /*It work? Reference? */
        /*@ManyToOne @JoinColumn */private var doctorId: Long,
        private var date: LocalDate,
        private var time: LocalTime

)