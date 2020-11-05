package clinicForRSQ.clinic.doctor

import clinicForRSQ.clinic.doctor.dto.DoctorDTO
import org.springframework.web.bind.annotation.*

@RestController
class DoctorController(val service : DoctorService) {

    @PostMapping("/doctor")
    fun addDoctor (@RequestBody doctor : DoctorDTO): DoctorDTO = service.tryAddDoctor(doctor)

    @GetMapping("/doctor")
    fun getAllDoctors() = service.tryGetAllDoctors()

    @PutMapping("/doctor")
    fun putDoctor (@RequestBody doctor : DoctorDTO): DoctorDTO = service.tryPutDoctor(doctor)

    @DeleteMapping("doctor/{id}")
    fun deleteDoctorById(@PathVariable("id") id : Long) = service.tryDeleteDoctor(id)
}
