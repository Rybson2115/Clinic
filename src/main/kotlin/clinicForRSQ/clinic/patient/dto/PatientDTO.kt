package clinicForRSQ.clinic.patient.dto

import clinicForRSQ.clinic.patient.Patient


class PatientDTO (
        var id: Long,
        var name: String,
        var surname: String,
        var pesel: String,
        var address: String
)