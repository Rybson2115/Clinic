package clinicForRSQ.clinic.visit.dto

import clinicForRSQ.clinic.doctor.dto.DoctorDTO
import clinicForRSQ.clinic.patient.dto.PatientDTO
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.EnumType
import javax.persistence.Enumerated

class VisitDTO(
        var id: Long,
        var room: Int =0,
        var patient: PatientDTO,
        var doctor: DoctorDTO,
        var date: LocalDate,
        var time: LocalTime,
        @Enumerated(EnumType.STRING) var status: visitStatusDTO = visitStatusDTO.APPOINTMENT
)
enum class visitStatusDTO {
    APPOINTMENT,
    POSTPONED,
    DONE,
    CANCELED
}

