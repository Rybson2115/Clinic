package clinicForRSQ.clinic.doctor

import clinicForRSQ.clinic.doctor.dto.DoctorDTO
import clinicForRSQ.clinic.visit.Visit
import clinicForRSQ.clinic.visit.VisitService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DoctorService (val repo : DoctorRepo, val visitService: VisitService){

    fun tryAddDoctor(doctorDTO: DoctorDTO): DoctorDTO {
        val doctor: Doctor = Doctor(doctorDTO)
        return repo.save(doctor).toDoctorDTO()
    }

    fun tryGetAllDoctors() = repo.findAll().toList()

    fun tryPutDoctor(doctorDTO: DoctorDTO): DoctorDTO {
        if(repo.existsById(doctorDTO.id)) {
            val oldDoctor: Doctor? = repo.findByIdOrNull(doctorDTO.id)
            val newDoctor: Doctor = Doctor(0,"","", DoctorSpecialization.DENTIST)
            if(oldDoctor != null){
                if(doctorDTO.name == "" && doctorDTO.surname == "" && doctorDTO.specialization == null ) 
                    throw Exception("No data for editing!")

                if(doctorDTO.name == "")
                    newDoctor.name = oldDoctor.name
                else{
                    newDoctor.name = doctorDTO.name
                }

                if(doctorDTO.surname == "")
                    newDoctor.surname = oldDoctor.surname
                else{
                    newDoctor.surname = doctorDTO.surname
                }

                if(doctorDTO.specialization == null) //sam nie wiem co o tym myśleć kurcze
                    newDoctor.specialization = oldDoctor.specialization
                else{
                    newDoctor.specialization = doctorDTO.specialization.toDoctorSpecialization()
                }

                newDoctor.id = doctorDTO.id
                return repo.save(newDoctor).toDoctorDTO()
            }
            else{
                throw Exception("No data for editing!")
            }
        }
        else
            throw Exception("doctor no exists!")
    }
    }
    fun tryDeleteDoctor(id: Long) {
        if(repo.existsById(id)){
            val deleteVisits: List<Visit> = visitService.tryFindPatientVisits(id)
            visitService.tryDeleteVisits(deleteVisits)
            repo.deleteById(id)
        }
        else
            throw Exception("Doctor no exists!")
    }
}