package ch11_dateandtime.temporaladjusters;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

/**
 * Rudimentärer Unit Test für die Klasse NextPaydayAdjuster.
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class NextPayDayAdjusterTest
{
    @Test
    public void checkAdvanceToPayDay_ForNormalMonthAndDaysBefore25th()
    {
        // Given
        final LocalDate day = LocalDate.of(2015, Month.MARCH, 26);
        final LocalDate expected = LocalDate.of(2015, Month.APRIL, 24);
        // When
        final LocalDate payday = day.with(new NextPaydayAdjuster());
        // Then
        assertEquals("should move to 25th or friday before", expected, payday);
        assertEquals(DayOfWeek.FRIDAY, payday.getDayOfWeek());
    }

    @Test
    public void checkAdvanceToPayDay_SpecialHandlingForDecember()
    {
        final LocalDate day = LocalDate.of(2014, Month.DECEMBER, 10);
        final LocalDate expected = LocalDate.of(2014, Month.DECEMBER, 15);

        final LocalDate payday = day.with(new NextPaydayAdjuster());

        assertEquals("should move to monday after 15th", expected, payday);
        assertEquals(DayOfWeek.MONDAY, payday.getDayOfWeek());
    }

    @Test
    public void checkAdvanceToNextMonth_ForDaysAfter25th()
    {
        final LocalDate day = LocalDate.of(2015, Month.MARCH, 26);
        final LocalDate expected = LocalDate.of(2015, Month.APRIL, 24);

        final LocalDate payday = day.with(new NextPaydayAdjuster());

        assertEquals("should move to next month", expected, payday);
        assertEquals(DayOfWeek.FRIDAY, payday.getDayOfWeek());
    }

    @Test
    public void checkAdvanceToNextYear_ForDecemberAndDaysAfter15th()
    {
        final LocalDate day = LocalDate.of(2014, Month.DECEMBER, 16);
        final LocalDate expected = LocalDate.of(2015, Month.JANUARY, 23);

        final LocalDate payday = day.with(new NextPaydayAdjuster());

        assertEquals("should move to january", expected, payday);
        assertEquals(DayOfWeek.FRIDAY, payday.getDayOfWeek());
    }

    @Test
    public void checkHandling_Without_Weekend()
    {
        final LocalDate day = LocalDate.of(2015, Month.FEBRUARY, 7);
        final LocalDate expected = LocalDate.of(2015, Month.FEBRUARY, 25);

        final LocalDate payday = day.with(new NextPaydayAdjuster());

        assertEquals("should move to 25. february", expected, payday);
        assertEquals(DayOfWeek.WEDNESDAY, payday.getDayOfWeek());
    }

    @Test
    public void checkHandling_Without_Weekend_ForDecember()
    {
        final LocalDate day = LocalDate.of(2015, Month.DECEMBER, 7);
        final LocalDate expected = LocalDate.of(2015, Month.DECEMBER, 15);

        final LocalDate payday = day.with(new NextPaydayAdjuster());

        assertEquals("should move to 15. december", expected, payday);
        assertEquals(DayOfWeek.TUESDAY, payday.getDayOfWeek());
    }
}
