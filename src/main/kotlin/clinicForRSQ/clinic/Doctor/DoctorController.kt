package clinicForRSQ.clinic.Doctor

import org.springframework.web.bind.annotation.*

@RestController
class DoctorController(val service : DoctorService)
{
    @PostMapping("/doctor")
    fun addDoctor (@RequestBody doctor : Doctor) = service.TryAddDoctor(doctor)

    @GetMapping("/doctor")
    fun getAllDoctors() = service.TryGetAllDoctors()

    @PutMapping("/doctor")
    fun putDoctor (@RequestBody doctor : Doctor) = service.TryPutDoctor(doctor)

    @DeleteMapping("doctor/{id}")
    fun deleteDoctorById(@PathVariable("id") id : Long) = service.TryDeleteDoctor(id);


}
