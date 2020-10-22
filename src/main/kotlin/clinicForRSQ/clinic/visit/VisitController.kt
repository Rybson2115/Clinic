package clinicForRSQ.clinic.visit

import org.springframework.web.bind.annotation.*

@RestController
class VisitController (val service : VisitService){

    @PostMapping("/visit")
    fun addVisit (@RequestBody visit : Visit)= service.tryAddVisit(visit)

    @GetMapping("/visit")
    fun getAllVisits() = service.tryGetAllVisits()

    @GetMapping("visit/find/patient/{patient}")
    fun getVisitByPatientId(@PathVariable("patient") patientId: Long) = service.tryFindPatientVisits(patientId);

    @GetMapping("visit/find/doctor/{doctor}")
    fun getVisitByDoctorId(@PathVariable("doctor") doctorId: Long) = service.tryFindDoctorVisits(doctorId);

    @PutMapping("/visit")
    fun putVisit (@RequestBody visit : Visit) = service.tryPutVisit(visit)

    @DeleteMapping("visit/delete/{id}")
    fun deleteVisitById(@PathVariable("id") id : Long) = service.tryDeleteVisit(id);
}