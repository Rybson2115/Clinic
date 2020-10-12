package clinicForRSQ.clinic.Visit


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito
import java.time.LocalDate
import java.time.LocalTime


class VisitServiceTest /*(val visitService : VisitService)*/ {

    @Test
    fun checkDateTimeNowTestTrue() { //current date, correct time, expected result = true

        val currentDate : LocalDate = LocalDate.now()
        val goodTime: LocalTime = LocalTime.of(17,45,0,0)

        val result : Boolean = true
        val visitRepo : VisitRepo = Mockito.mock(VisitRepo::class.java)
        var visitService: VisitService = VisitService(visitRepo)
        assertEquals(result, visitService.checkDateAndTime(currentDate,goodTime) )

    }
    @Test
    fun checkDateTimeNowTestFalse() { //current date, incorrect time, expected result = false

        val currentDate : LocalDate = LocalDate.now()
        val goodTime: LocalTime = LocalTime.of(7,0,0,0)

        val result : Boolean = false
        val visitRepo : VisitRepo = Mockito.mock(VisitRepo::class.java)
        var visitService: VisitService = VisitService(visitRepo)
        assertEquals(result, visitService.checkDateAndTime(currentDate,goodTime) )

    }
    @Test
    fun checkDateTimeTestTrue() { //correct date, correct time, expected result = true

        val currentDate : LocalDate = LocalDate.now()
        val goodDate: LocalDate = LocalDate.of(currentDate.year+1,1,1)
        val goodTime: LocalTime = LocalTime.of(12,0,0,0)

        val result : Boolean = true
        val visitRepo : VisitRepo = Mockito.mock(VisitRepo::class.java)
        var visitService: VisitService = VisitService(visitRepo)
        assertEquals(result, visitService.checkDateAndTime(goodDate,goodTime) )

    }
    @Test
    fun checkDateTimeTestFalseTime() { //correct date, incorrect time, expected result = true

        val currentDate : LocalDate = LocalDate.now()
        val goodDate: LocalDate = LocalDate.of(currentDate.year+1,1,1)
        val goodTime: LocalTime = LocalTime.of(6,0,0,0)

        val result : Boolean = false
        val visitRepo : VisitRepo = Mockito.mock(VisitRepo::class.java)
        var visitService: VisitService = VisitService(visitRepo)
        assertEquals(result, visitService.checkDateAndTime(goodDate,goodTime) )

    }
    @Test
    fun checkDateTimeTestFalseDate() { //incorrect date, correct time, expected result = true

        val currentDate : LocalDate = LocalDate.now()
        val goodDate: LocalDate = LocalDate.of(currentDate.year-1,1,1)
        val goodTime: LocalTime = LocalTime.of(12,0,0,0)

        val result : Boolean = false
        val visitRepo : VisitRepo = Mockito.mock(VisitRepo::class.java)
        var visitService: VisitService = VisitService(visitRepo)
        assertEquals(result, visitService.checkDateAndTime(goodDate,goodTime) )

    }
    @Test
    fun checkDateTimeTestFalseDateTime() { //incorrect date, incorrect time, expected result = true

        val currentDate : LocalDate = LocalDate.now()
        val goodDate: LocalDate = LocalDate.of(currentDate.year-1,1,1)
        val goodTime: LocalTime = LocalTime.of(7,0,0,0)

        val result : Boolean = false
        val visitRepo : VisitRepo = Mockito.mock(VisitRepo::class.java)
        var visitService: VisitService = VisitService(visitRepo)
        assertEquals(result, visitService.checkDateAndTime(goodDate,goodTime) )

    }


}
