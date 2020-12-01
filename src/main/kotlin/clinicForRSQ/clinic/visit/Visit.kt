package clinicForRSQ.clinic.visit

import clinicForRSQ.clinic.doctor.Doctor
import clinicForRSQ.clinic.patient.Patient
import clinicForRSQ.clinic.visit.dto.VisitDTO
import clinicForRSQ.clinic.visit.dto.visitStatusDTO
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
class Visit(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long,
        var room: Int =0,
        @ManyToOne @JoinColumn(name = "patientId",referencedColumnName = "id") var patient: Patient,
        @ManyToOne @JoinColumn(name = "doctorId", referencedColumnName = "id") var doctor: Doctor,
        var date: LocalDate,
        var time: LocalTime,
        @Enumerated(EnumType.STRING) var status: visitStatus = visitStatus.APPOINTMENT
){
    constructor(visitDTO: VisitDTO) : this (
            id = visitDTO.id,
            room = visitDTO.room,
            patient = Patient(visitDTO.patient),
            doctor = Doctor(visitDTO.doctor),
            date = visitDTO.date,
            time = visitDTO.time,
            status = visitDTO.status.toVisitStatus()
    )

    fun toVisitDTO() = VisitDTO(
            id = id,
            room = room,
            patient = patient.toPatientDTO(),
            doctor = doctor.toDoctorDTO(),
            date = date,
            time = time,
            status = status.toVisitStatusDTO()
    )

}

enum class visitStatus {
    APPOINTMENT,
    POSTPONED,
    DONE,
    CANCELED
}
fun visitStatusDTO.toVisitStatus(): visitStatus =
        when(this){
            visitStatusDTO.APPOINTMENT -> visitStatus.APPOINTMENT
            visitStatusDTO.POSTPONED -> visitStatus.POSTPONED
            visitStatusDTO.DONE -> visitStatus.DONE
            visitStatusDTO.CANCELED -> visitStatus.CANCELED
        }
fun visitStatus.toVisitStatusDTO(): visitStatusDTO =
        when(this){
            visitStatus.APPOINTMENT -> visitStatusDTO.APPOINTMENT
            visitStatus.POSTPONED -> visitStatusDTO.POSTPONED
            visitStatus.DONE -> visitStatusDTO.DONE
            visitStatus.CANCELED -> visitStatusDTO.CANCELED
        }