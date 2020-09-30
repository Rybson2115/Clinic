package clinicForRSQ.clinic.Visit

import clinicForRSQ.clinic.Doctor.Doctor
import clinicForRSQ.clinic.Patient.Patient
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
class Visit (
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long,
        var room: Int =0,
        @ManyToOne @JoinColumn(name = "patientId",referencedColumnName = "id") var patient : Patient,
        @ManyToOne @JoinColumn(name = "doctorId", referencedColumnName = "id") var doctor: Doctor,
        var date: LocalDate,
        var time: LocalTime


)