package clinicForRSQ.clinic.patient

import clinicForRSQ.clinic.patient.dto.PatientDTO
import javax.persistence.*

@Entity
class Patient (
        @Id @GeneratedValue var id: Long,
        var name: String,
        var surname: String,
        var address: String
){
    constructor(patientDTO: PatientDTO) : this (
            id = patientDTO.id,
            name = patientDTO.name,
            surname = patientDTO.surname,
            address = patientDTO.address
    )

    fun toPatientDTO() = PatientDTO(
            id = id,
            name = name,
            surname = surname,
            address = address
    )
}