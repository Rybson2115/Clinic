package clinicForRSQ.clinic.Visit

import clinicForRSQ.clinic.Doctor.Doctor
import clinicForRSQ.clinic.Patient.Patient
import org.springframework.stereotype.Service
import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime

@Service
class VisitService (var repo : VisitRepo){
    fun TryAddVisit(visit: Visit){
        var currentDate = LocalDate.now()
        var currentTime = LocalTime.now()
        var opentTime : LocalTime = LocalTime.of(7,59,0)
        var closeTime : LocalTime = LocalTime.of(17,46,0) //last visit may start at 17:45,  clinic works until 18
        if(visit.date > currentDate)
            if( opentTime < visit.time && visit.time < closeTime)
                repo.save(visit)
        else if(visit.date == currentDate)
            if( currentTime < visit.time && visit.time < closeTime)
                repo.save(visit)
        else
                Exception("Wrong date or time!")


    }
    fun TryGetAllVistis() = repo.findAll().toList()
    fun TryPutVisit(visit: Visit) = repo.save(visit)
    fun TryDeleteVisit(id: Long) = repo.deleteById(id)
    fun TryFindDoctorVisits(doctor: Doctor) = repo.findAll().toList()
    fun TryFindPatientVisits(patient: Patient) = repo.findAll().toList()

}
