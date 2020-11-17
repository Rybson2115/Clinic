package clinicForRSQ.clinic.patient


import clinicForRSQ.clinic.visit.VisitRepo
import clinicForRSQ.clinic.visit.VisitService
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.time.LocalTime

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
        val badId : Long = -1
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.tryDeletePatient(badId)
        }
        assertEquals("Patient no exists!", exception.message)
    }

    @Test
    fun checkPeselTestgoodPesel(){
        //given
        val goodPesel : String = "98061503475"
        //when & then
        val expected = true
        val visitServiceTest : Boolean = patientService.checkPesel(goodPesel)
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
        assertEquals("Incorrect pesel!", exception.message)
    }

    @Test
    fun checkPeselTestTooLongPesel(){
        //given
        val longPesel : String = "11223344556677889900"
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.checkPesel(longPesel)
        }
        assertEquals("Incorrect pesel!", exception.message)
    }

    @Test
    fun checkPeselTestLettersPesel(){
        //given
        val letterPesel : String = "aaaaaaaaaaa"
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.checkPesel(letterPesel)
        }
        assertEquals("Incorrect pesel!", exception.message)
    }

    @Test
    fun checkPeselTestBadPesel(){
        //given
        val badPesel : String = "12345678999"
        //when & then
        val exception = assertThrows(Exception::class.java) {
            patientService.checkPesel(badPesel)
        }
        assertEquals("Incorrect pesel!", exception.message)
    }
    
}