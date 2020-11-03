package clinicForRSQ.clinic.visit

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class VisitService (var repo : VisitRepo) {

    fun tryAddVisit(visit: Visit) {
        if (checkDateAndTime(visit.date, visit.time)) {
            repo.save(visit)
        }
    }

    fun tryGetAllVisits() = repo.findAll().toList()

    fun tryPutVisit(visit: Visit) = repo.save(visit)

    fun tryDeleteVisit(id: Long){
        if(repo.existsById(id))
            repo.deleteById(id)
        else
            throw Exception("Visit no exists!")
    }

    fun tryFindDoctorVisits(doctorId: Long) = repo.findDoctorVisitById(doctorId)

    fun tryFindPatientVisits(patientId: Long) = repo.findPatientVisitById(patientId)

    fun tryDeleteVisits(visits: List<Visit>) = repo.deleteAll(visits)

    fun checkDateAndTime(visitDate: LocalDate, visitTime: LocalTime): Boolean {

        val lastVisitTime: LocalTime = LocalTime.of(17, 46, 0)
        val firstVisitTime: LocalTime = LocalTime.of(7, 59, 59)
        val currentTime: LocalTime = LocalTime.now()
        val currentDate: LocalDate = LocalDate.now()

        if (visitDate.isEqual(currentDate)) {
            if (visitTime.isAfter(currentTime) && visitTime.isBefore(lastVisitTime))
                return true
            else {
                throw Exception("Wrong time!")
            }
        }
        else if (visitDate.isAfter(currentDate)) {
            if (visitTime.isAfter(firstVisitTime) && visitTime.isBefore(lastVisitTime)) {
                return true
            }
            else {
                throw Exception("Wrong time!")
        }
        }
        else
        throw Exception("Wrong date!")
    }
}
