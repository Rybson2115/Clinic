package clinicForRSQ.clinic.patient

import clinicForRSQ.clinic.patient.dto.PatientDTO
import javax.persistence.*

@Entity
class Patient (
        @Id @GeneratedValue var id: Long,
        var name: String,
        var surname: String,
        var pesel: String,
        var address: String
){
    constructor(patientDTO: PatientDTO) : this (
            id = patientDTO.id,
            name = patientDTO.name,
            surname = patientDTO.surname,
            pesel = patientDTO.pesel,
            address = patientDTO.address
    )

    fun toPatientDTO() = PatientDTO(
            id = id,
            name = name,
            surname = surname,
            pesel = pesel,
            address = address
    )
}