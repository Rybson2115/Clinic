package clinicForRSQ.clinic.visit

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class VisitService (var repo : VisitRepo){

    fun tryAddVisit(visit: Visit){
        if(checkDateAndTime(visit.date,visit.time)) {
            repo.save(visit)
        }
    }

    fun tryGetAllVisits() = repo.findAll().toList()

    fun tryPutVisit(visit: Visit) = repo.save(visit)

    fun tryDeleteVisit(id: Long) = repo.deleteById(id)

    fun tryFindDoctorVisits(doctorId: Long) = repo.findDoctorVisitById(doctorId)

    fun tryFindPatientVisits(patientId: Long) = repo.findPatientVisitById(patientId)

    fun tryDeleteVisits(visits : List<Visit>) = repo.deleteAll(visits)

    fun checkDateAndTime(visitDate: LocalDate, visitTime: LocalTime):Boolean{
        var closeTime : LocalTime = LocalTime.of(17,46,0) //last visit may start at 17:45,  clinic works until 18
        var openTime : LocalTime = LocalTime.of(7,59,59) //first visit may start at 8:00
        var currentTime: LocalTime = LocalTime.now()
        val currentDate : LocalDate = LocalDate.now()
        if(visitDate.isEqual(currentDate)){
            if(currentTime.isAfter(visitTime) && visitTime.isBefore(closeTime))
                return true
            else{
               throw Exception("Wrong time!")
                return false
            }}
        else if(visitDate.isAfter(currentDate)){
            if(openTime.isAfter(visitTime) && visitTime.isBefore(visitTime))
                return true
            else{
                throw Exception("Wrong time!")
                return false
            }}
        else
            throw Exception("Wrong date!")
        return false
    }
}
