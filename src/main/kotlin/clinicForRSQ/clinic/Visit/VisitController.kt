package clinicForRSQ.clinic.Visit


import clinicForRSQ.clinic.Doctor.Doctor
import clinicForRSQ.clinic.Patient.Patient
import org.springframework.web.bind.annotation.*

@RestController
class VisitController (val service : VisitService){
    @PostMapping("/visit")
    fun addVisit (@RequestBody visit : Visit)= service.TryAddVisit(visit)

    @GetMapping("/visit")
    fun getAllVisits() = service.TryGetAllVistis()

    @GetMapping("visit/find/patient/{patient}")
    fun getVisitByPatientId(@PathVariable("patient") patient: Patient) = service.TryFindPatientVisits(patient);

    @GetMapping("visit/find/doctor/{doctor}")
    fun getVisitByDoctorId(@PathVariable("doctor") doctor: Doctor) = service.TryFindDoctorVisits(doctor);

    @PutMapping("/visit")
    fun putVisit (@RequestBody visit : Visit) = service.TryPutVisit(visit)

    @DeleteMapping("visit/delete/{id}")
    fun deleteVisitById(@PathVariable("id") id : Long) = service.TryDeleteVisit(id);
}