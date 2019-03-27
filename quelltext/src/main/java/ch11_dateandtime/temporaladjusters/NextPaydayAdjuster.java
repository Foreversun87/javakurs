package ch11_dateandtime.temporaladjusters;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.DayOfWeek.*;
import static java.time.Month.DECEMBER;

/**
 * Beispielprogramm zur Demonstration eines selbstdefinierten komplexeren TemporalAdjuster.
 *
 * @author Michael Inden
 *
 * Copyright 2014 by Michael Inden
 */
public class NextPaydayAdjuster implements TemporalAdjuster
{
    @Override
    public Temporal adjustInto(final Temporal temporal)
    {
        LocalDate date = LocalDate.from(temporal);

        boolean isDecember = date.getMonth().equals(DECEMBER);
        int paymentDay = isDecember ? 15 : 25;

        if (date.getDayOfMonth() > paymentDay)
        {
            date = date.plusMonths(1);

            // Abfragen nochmals nötig, da eventuell um einen Monat verschoben
            isDecember = date.getMonth().equals(DECEMBER);
            paymentDay = isDecember ? 15 : 25;
        }

        date = date.withDayOfMonth(paymentDay);

		if (date.getDayOfWeek() == SATURDAY ||
	        date.getDayOfWeek() == SUNDAY)
		{
	    	if (isDecember)
        	{
           		date = date.with(TemporalAdjusters.nextOrSame(MONDAY));
        	}
        	else
        	{
            	date = date.with(TemporalAdjusters.previousOrSame(FRIDAY));
        	}
		}
        return temporal.with(date);
    }
}
