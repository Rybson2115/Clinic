package clinicForRSQ.clinic.patient

import clinicForRSQ.clinic.patient.dto.PatientDTO
import org.springframework.web.bind.annotation.*

@RestController
class PatientController(val service: PatientService){

    @PostMapping("/patient")
    fun addPatient (@RequestBody patient : PatientDTO): PatientDTO = service.tryAddPatient(patient)

    @GetMapping("/patient")
    fun getAllPatients() = service.tryGetAllPatients()

    @PutMapping("/patient")
    fun putPatient (@RequestBody patient : PatientDTO): PatientDTO = service.tryPutPatient(patient)

    @DeleteMapping("/patient/{id}")
    fun deletePatientById(@PathVariable("id") id : Long) = service.tryDeletePatient(id)
}