package clinicForRSQ.clinic.visit.dto

import clinicForRSQ.clinic.doctor.dto.DoctorDTO
import clinicForRSQ.clinic.patient.dto.PatientDTO
import java.time.LocalDate
import java.time.LocalTime

class VisitDTO(
        var id: Long,
        var room: Int =0,
        var patient: PatientDTO,
        var doctor: DoctorDTO,
        var date: LocalDate,
        var time: LocalTime
)

