package clinicForRSQ.clinic.patient


import clinicForRSQ.clinic.patient.dto.PatientDTO
import clinicForRSQ.clinic.visit.VisitRepo
import clinicForRSQ.clinic.visit.VisitService
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class PatientServiceTest {
    @Mock
    private val patientRepo = mock<PatientRepo>()
    private val visitRepo = mock<VisitRepo>()
    private val visitService: VisitService = VisitService(visitRepo)
    private val patientService: PatientService = PatientService(patientRepo, visitService)

    @Test
    fun deletePatientByBadIdExceptException(){
        //given
        val incorrectId : Long = -1
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.tryDeletePatient(incorrectId)
        }
        assertEquals("Patient no exists!", exception.message)
    }

    @Test
    fun checkPeselTestgoodPesel(){
        //given
        val correctPesel : String = "98061503475"
        //when & then
        val expected = kotlin.Unit
        val visitServiceTest  = patientService.checkPesel(correctPesel)
        //then
        assertEquals(expected, visitServiceTest)
    }

    @Test
    fun checkPeselTestTooShortPesel(){
        //given
        val shortPesel : String = "123456"
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.checkPesel(shortPesel)
        }
        assertEquals("Incorrect lenght pesel!", exception.message)
    }

    @Test
    fun checkPeselTestTooLongPesel(){
        //given
        val longPesel : String = "11223344556677889900"
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.checkPesel(longPesel)
        }
        assertEquals("Incorrect lenght pesel!", exception.message)
    }

    @Test
    fun checkPeselTestLettersPesel(){
        //given
        val letterPesel : String = "aaaaaaaaaaa"
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.checkPesel(letterPesel)
        }
        assertEquals("Letters in pesel!", exception.message)
    }

    @Test
    fun checkPeselTestBadPesel(){
        //given
        val incorrectPesel : String = "12345678999"
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.checkPesel(incorrectPesel)
        }
        assertEquals("Incorrect pesel!", exception.message)
    }
    @Test
    fun checkPeselTestZeroPesel(){
        //given
        val zeroPesel : String = "00000000000"
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.checkPesel(zeroPesel)
        }
        assertEquals("Incorrect pesel!", exception.message)
    }
    @Test
    fun checkPeselTestIncorectPesel(){
        //given
        val incorrectPesel : String = "12345678900"
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.checkPesel(incorrectPesel)
        }
        assertEquals("Incorrect pesel!", exception.message)
    }

    @Test
    fun putPatientTestincorrectId(){
        //given
        val incorrectIdPatientDTO : PatientDTO = PatientDTO(-1,"","","","")
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.tryPutPatient(incorrectIdPatientDTO)
        }
        assertEquals("Patient no exists!", exception.message)
    }

    @Test
    fun putPatientTestEmptyPatient(){
        //given
        val emptyPatientDTO : PatientDTO = PatientDTO(2,"","","","")

        whenever(patientRepo.existsById(2)).thenReturn(true)
        //whenever(patientRepo.findByIdOrNull(2)).thenReturn(Patient(emptyPatientDTO))
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.tryPutPatient(emptyPatientDTO)
        }
        assertEquals("No data for editing!", exception.message)
    }
}