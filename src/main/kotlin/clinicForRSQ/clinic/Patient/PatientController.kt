package clinicForRSQ.clinic.Patient

import org.springframework.web.bind.annotation.*

@RestController
class PatientController(val repo : PatientRepo)
{
    @PostMapping("/patient")
    fun addPatient (@RequestBody patient : Patient)
    {
        repo.save(patient)
    }

    @GetMapping("/patient")
    fun getAllPatients() = repo.findAll().toList();

    /*@GetMapping("patient/{surname}")
    fun getPatientBySurname(@PathVariable("surname") surname : String) = repo.findBySurname(surname);
    No required */
    @PutMapping("/patient")
    fun putPatient (@RequestBody patient : Patient){
        repo.save(patient)
    }
    @DeleteMapping("patient/{id}")
    fun deletePatientById(@PathVariable("id") id : Long) = repo.deleteByPatientId(id);
}