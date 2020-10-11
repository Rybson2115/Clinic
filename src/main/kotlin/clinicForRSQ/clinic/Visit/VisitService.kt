package clinicForRSQ.clinic.Visit


import clinicForRSQ.clinic.Doctor.Doctor
import clinicForRSQ.clinic.Patient.Patient
import org.springframework.stereotype.Service
import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime

@Service
class VisitService (var repo : VisitRepo){
    fun tryAddVisit(visit: Visit){
        var currentDate = LocalDate.now()
        var currentTime = LocalTime.now()
        var opentTime : LocalTime = LocalTime.of(7,59,59) //first visit may start at 8:00
        var closeTime : LocalTime = LocalTime.of(17,46,0) //last visit may start at 17:45,  clinic works until 18
        if(checkDateToDay(visit.date))
            if( opentTime < visit.time && visit.time < closeTime)
                repo.save(visit)
        else if(visit.date == currentDate)
            if( currentTime < visit.time && visit.time < closeTime)
                repo.save(visit)
        else
                Exception("Wrong date or time!")


    }
    fun tryGetAllVistis() = repo.findAll().toList()
    fun tryPutVisit(visit: Visit) = repo.save(visit)
    fun tryDeleteVisit(id: Long) = repo.deleteById(id)
    fun tryFindDoctorVisits(doctorId: Long) = repo.findDoctortVisitById(doctorId)
    fun tryFindPatientVisits(patientId: Long) = repo.findPatientVisitById(patientId)
    fun tryDeleteVisits(visits : List<Visit>) = repo.deleteAll(visits)
    fun checkDate(date:LocalDate): Boolean{
        val currentDate : LocalDate = LocalDate.now()
        if(date > currentDate)
            return true
        return false
    }
    fun checkDateToDay(date: LocalDate):Boolean{
        val currentDate : LocalDate = LocalDate.now()
        /*if(date == currentDate){
            return true}
            return true*/
        return true
    }
    fun checkTime(time: LocalTime): Boolean{
        var opentTime : LocalTime = LocalTime.of(7,59,59) //first visit may start at 8:00
        var closeTime : LocalTime = LocalTime.of(17,46,0) //last visit may start at 17:45,  clinic works until 18
        if( opentTime < time && time < closeTime)
            return true
        return false
    }
    fun checkTimeToDay(time: LocalTime): Boolean{
        var closeTime : LocalTime = LocalTime.of(17,46,0) //last visit may start at 17:45,  clinic works until 18
        var currentTime = LocalTime.now()
        if(currentTime < time && time < closeTime)
            return true
        return false
    }

}
