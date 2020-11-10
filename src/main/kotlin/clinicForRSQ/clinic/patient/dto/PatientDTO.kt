package clinicForRSQ.clinic.patient.dto

import clinicForRSQ.clinic.patient.Patient


class PatientDTO (
        var id: Long,
        var name: String,
        var surname: String,
        var address: String
){
    fun toPatient() = Patient (
            id = id,
            name = name,
            surname = surname,
            address = address
    )
}