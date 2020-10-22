package clinicForRSQ.clinic.visit


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito
import java.time.LocalDate
import java.time.LocalTime


class VisitServiceTest /*(val visitService : VisitService)*/ {

    private val visitRepo : VisitRepo = Mockito.mock(VisitRepo::class.java)
    private val visitService: VisitService = VisitService(visitRepo)
    private val currentDate : LocalDate = LocalDate.now()

    @Test
    fun checkDateTimeNowTestTrue() { //current date, correct time, expected result = true
        //given
        val goodTime: LocalTime = LocalTime.of(17,45,0,0)
        //when
        val expected = true
        val visitServiceTest : Boolean = visitService.checkDateAndTime(currentDate,goodTime)
        //then
        assertEquals(expected, visitServiceTest )
    }

    @Test
    fun checkDateTimeNowTestFalse() { //current date, incorrect time, expected result = false
        //given
        val goodTime: LocalTime = LocalTime.of(7,0,0,0)
        //when
        val expected = false
        val visitServiceTest : Boolean = visitService.checkDateAndTime(currentDate,goodTime)
        //then
        assertEquals(expected, visitServiceTest )
    }

    @Test
    fun checkDateTimeTestTrue() { //correct date, correct time, expected result = true
        //given
        val goodDate: LocalDate = LocalDate.of(currentDate.year+1,1,1)
        val goodTime: LocalTime = LocalTime.of(12,0,0,0)
        //when
        val expected = true
        val visitServiceTest : Boolean = visitService.checkDateAndTime(goodDate,goodTime)
        //then
        assertEquals(expected, visitServiceTest)
    }

    @Test
    fun checkDateTimeTestFalseTime() { //correct date, incorrect time, expected result = true
        //given
        val goodDate: LocalDate = LocalDate.of(currentDate.year+1,1,1)
        val goodTime: LocalTime = LocalTime.of(6,0,0,0)
        //when
        val expected = false
        val visitServiceTest : Boolean = visitService.checkDateAndTime(goodDate,goodTime)
        //then
        assertEquals(expected, visitServiceTest)
    }

    @Test
    fun checkDateTimeTestFalseDate() { //incorrect date, correct time, expected result = true
        //given
        val goodDate: LocalDate = LocalDate.of(currentDate.year-1,1,1)
        val goodTime: LocalTime = LocalTime.of(12,0,0,0)
        //when
        val expected = false
        val visitServiceTest : Boolean = visitService.checkDateAndTime(goodDate,goodTime)
        //then
        assertEquals(expected, visitServiceTest)
    }

    @Test
    fun checkDateTimeTestFalseDateTime() { //incorrect date, incorrect time, expected result = true
        //given
        val goodDate: LocalDate = LocalDate.of(currentDate.year-1,1,1)
        val goodTime: LocalTime = LocalTime.of(7,0,0,0)
        //when
        val expected = false
        val visitServiceTest : Boolean = visitService.checkDateAndTime(goodDate,goodTime)
        //then
        assertEquals(expected, visitServiceTest )
    }
}
