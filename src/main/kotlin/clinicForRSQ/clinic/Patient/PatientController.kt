package clinicForRSQ.clinic.Patient

import org.springframework.web.bind.annotation.*

@RestController
class PatientController(val service: PatientService)
{
    @PostMapping("/patient")
    fun addPatient (@RequestBody patient : Patient) = service.TryAddPatient(patient)


    @GetMapping("/patient")
    fun getAllPatients() = service.TryGetAllPatients()

    /*@GetMapping("patient/{surname}")
    fun getPatientBySurname(@PathVariable("surname") surname : String) = repo.findBySurname(surname);
    No required */
    @PutMapping("/patient")
    fun putPatient (@RequestBody patient : Patient){
        service.TryPutPatient(patient)
    }
    @DeleteMapping("/patient/{id}")
    fun deletePatientById(@PathVariable("id") id : Long) = service.TryDeletePatient(id)
}