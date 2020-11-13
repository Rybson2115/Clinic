package clinicForRSQ.clinic.visit

import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.time.LocalDate
import java.time.LocalTime

@RunWith(MockitoJUnitRunner::class)
class VisitServiceTest {

    @Mock
    private val visitRepo = mock<VisitRepo>()

    private val visitService: VisitService = VisitService(visitRepo)

    private val currentDate : LocalDate = LocalDate.now()

    @Test
    fun checkDateTimeNowTestTrue() {//current date, correct time, expected result = true, test runs between 8 and 17:45
        //given
        val goodTime: LocalTime = LocalTime.of(17,45,0,0)
        val goodRealTime : LocalTime = LocalTime.of(9,0,0,0)
        //when & then
        val expected = true
        val visitServiceTest : Boolean = visitService.checkDateAndTime(currentDate,goodTime,goodRealTime)
        //then
        assertEquals(expected, visitServiceTest )
    }

    @Test
    fun checkDateTimeNowTestFalse() { //current date, incorrect time, expected result = exception - Wrong time!
        //given
        val badTime: LocalTime = LocalTime.of(7,0,0,0)
        //when & then
        val exception = assertThrows(Exception::class.java) {
            visitService.checkDateAndTime(currentDate,badTime)
        }
        assertEquals("Wrong time!", exception.message)
    }

    @Test
    fun checkDateTimeTestTrue() { //correct date, correct time, expected result = true
        //given
        val goodDate: LocalDate = LocalDate.of(currentDate.year+1,1,1)
        val goodTime: LocalTime = LocalTime.of(12,0,0,0)
        //when & then
        val expected = true
        val visitServiceTest : Boolean = visitService.checkDateAndTime(goodDate,goodTime)
        //then
        assertEquals(expected, visitServiceTest )
    }

    @Test
    fun checkDateTimeTestFalseTime() { //correct date, incorrect time, expected result = exception - Wrong time!
        //given
        val goodDate: LocalDate = LocalDate.of(currentDate.year+1,1,1)
        val badTime: LocalTime = LocalTime.of(6,0,0,0)
        //when & then
        val exception = assertThrows(Exception::class.java) {
            visitService.checkDateAndTime(goodDate,badTime)
        }
        assertEquals("Wrong time!", exception.message)
    }

    @Test
    fun checkDateTimeTestFalseDate() { //incorrect date, correct time, expected result = exception - Wrong date!
        //given
        val goodDate: LocalDate = LocalDate.of(currentDate.year-1,1,1)
        val goodTime: LocalTime = LocalTime.of(12,0,0,0)
        //when & then
        val exception = assertThrows(Exception::class.java) {
            visitService.checkDateAndTime(goodDate,goodTime)
        }
        assertEquals("Wrong date!", exception.message)
    }

    @Test
    fun checkDateTimeTestFalseDateTime() { //incorrect date, incorrect time, expected result = Wrong date!
        //given
        val goodDate: LocalDate = LocalDate.of(currentDate.year-1,1,1)
        val goodTime: LocalTime = LocalTime.of(7,0,0,0)
        //when & then
        val exception = assertThrows(Exception::class.java) {
            visitService.checkDateAndTime(goodDate,goodTime)
        }
        assertEquals("Wrong date!", exception.message)
    }

    @Test
    fun deleteVisitByIdTest(){
        //given
        val badId : Long = -1
        //when & then
        val exception = assertThrows(Exception::class.java) {
            visitService.tryDeleteVisit(badId)
        }
        assertEquals("Visit no exists!", exception.message)
    }
}
