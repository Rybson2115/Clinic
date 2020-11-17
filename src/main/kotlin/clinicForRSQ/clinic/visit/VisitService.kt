package clinicForRSQ.clinic.visit

import clinicForRSQ.clinic.visit.dto.VisitDTO
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class VisitService (var repo : VisitRepo) {

    fun tryAddVisit(visitDTO: VisitDTO)  {
        if (checkDateAndTime(visitDTO.date, visitDTO.time)) {
            val visit : Visit = Visit(visitDTO)
            repo.save(visit).toVisitDTO()
        }
    }

    fun tryGetAllVisits() = repo.findAll().toList()

    fun tryPutVisit(visitDTO: VisitDTO) {
        val visit : Visit = Visit(visitDTO)
        repo.save(visit).toVisitDTO()
    }

    fun tryDeleteVisit(id: Long){
        if(repo.existsById(id))
            repo.deleteById(id)
        else
            throw Exception("Visit no exists!")
    }

    fun tryFindDoctorVisits(doctorId: Long) = repo.findDoctorVisitById(doctorId)

    fun tryFindPatientVisits(patientId: Long) = repo.findPatientVisitById(patientId)

    fun tryDeleteVisits(visits: List<Visit>) = repo.deleteAll(visits)

    fun checkDateAndTime(visitDate: LocalDate, visitTime: LocalTime, currentTime : LocalTime = LocalTime.now()): Boolean {

        val lastVisitTime: LocalTime = LocalTime.of(17, 46, 0)
        val firstVisitTime: LocalTime = LocalTime.of(7, 59, 59)
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
