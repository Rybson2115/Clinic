package clinicForRSQ.clinic.doctor

import org.springframework.web.bind.annotation.*

@RestController
class DoctorController(val service : DoctorService) {

    @PostMapping("/doctor")
    fun addDoctor (@RequestBody doctor : Doctor) = service.tryAddDoctor(doctor)

    @GetMapping("/doctor")
    fun getAllDoctors() = service.tryGetAllDoctors()

    @PutMapping("/doctor")
    fun putDoctor (@RequestBody doctor : Doctor) = service.tryPutDoctor(doctor)

    @DeleteMapping("doctor/{id}")
    fun deleteDoctorById(@PathVariable("id") id : Long) = service.tryDeleteDoctor(id)
}
