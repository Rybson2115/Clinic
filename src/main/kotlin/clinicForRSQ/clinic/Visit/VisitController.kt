package clinicForRSQ.clinic.Visit


import clinicForRSQ.clinic.Patient.Patient
import org.springframework.web.bind.annotation.*

@RestController
class VisitController (val repo : VisitRepo){
    @PostMapping("/visit")
    fun addVisit (@RequestBody visit : Visit)=repo.save(visit)

    @GetMapping("/visit")
    fun getAllVisits() = repo.findAll().toList();

    @GetMapping("visit/find?{id}")
    fun getVisitByPatientId(@PathVariable("id") id : Long) = repo.findVisitById(id);

    @PutMapping("/visit")
    fun putVisit (@RequestBody visit : Visit){
        repo.save(visit)
    }
    @DeleteMapping("visit/delete/{id}")
    fun deleteVisitById(@PathVariable("id") id : Long) = repo.deleteById(id);
}