package clinicForRSQ.clinic.Doctor

import org.springframework.web.bind.annotation.*

@RestController
class DoctorController(private val repo : DoctorRepo)
{
    @PostMapping("/doctor")
    fun addDoctor (@RequestBody doctor : Doctor)
    {
        repo.save(doctor)
    }

    @GetMapping("/doctor")
    fun getAllDoctors() = repo.findAll().toList();

    /* @GetMapping("doctor/{surname}")
    fun getDoctorBySurname(@PathVariable("surname") surname : String) = repo.findBySurname(surname);
    Not required
    */
    @PutMapping("/doctor")
    fun putDoctor (@RequestBody doctor : Doctor){
        repo.save(doctor)
    }
    @DeleteMapping("doctor/{id}")
    fun deleteDoctorById(@PathVariable("id") id : Long) = repo.deleteDoctorById(id);


}
