package clinicForRSQ.clinic.doctor

import clinicForRSQ.clinic.visit.VisitRepo
import clinicForRSQ.clinic.visit.VisitService
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DoctorServiceTest {
    @Mock
    private val doctorRepo = mock<DoctorRepo>()
    private val visitRepo = mock<VisitRepo>()
    private val visitService: VisitService = VisitService(visitRepo)
    private val doctorService: DoctorService = DoctorService(doctorRepo, visitService)

    @Test
    fun tryDeleteDoctorByBadIdExpectException() {
        //given
        val incorrectId : Long = -1
        //when & then
        val exception = assertThrows(Exception::class.java) {
           doctorService.tryDeleteDoctor(incorrectId)
        }
        assertEquals("Doctor no exists!", exception.message)
    }
}