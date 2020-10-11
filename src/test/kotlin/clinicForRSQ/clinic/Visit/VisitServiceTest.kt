package clinicForRSQ.clinic.Visit

import ch.qos.logback.core.boolex.Matcher
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.time.LocalDate


class VisitServiceTest /*(val visitService : VisitService)*/ {

    @Test
    fun checkDateTest() {

        val currentDate : LocalDate = LocalDate.now()
        val result : Boolean = true
        val date : LocalDate = LocalDate.of(2020,10,11)
        val visitService: VisitService = Mockito.mock(VisitService::class.java)
        assertEquals(result, visitService.checkDateToDay(currentDate) )

    }
}

//visitService.checkDateToDay(currentDate)