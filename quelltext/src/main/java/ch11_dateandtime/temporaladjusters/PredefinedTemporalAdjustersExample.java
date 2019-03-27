package ch11_dateandtime.temporaladjusters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.temporal.TemporalAdjusters.*;

/**
 * Beispielprogramm zur Demonstration vordefinierter TemporalAdjuster.
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class PredefinedTemporalAdjustersExample
{
    public static void main(final String[] args)
    {
        final LocalDate date = LocalDate.of(2015, Month.FEBRUARY, 7);

        final LocalDate firstOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        final LocalDate lastofMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        final LocalDate firstOfNextMonth = date.with(firstDayOfNextMonth());
        final LocalDate firstMondayInMonth = date.with(firstInMonth(DayOfWeek.MONDAY));
        final LocalDate lastSaturdayInMonth = date.with(lastInMonth(SATURDAY));

        System.out.println("date:                " + date);
        System.out.println("lastofMonth:         " + lastofMonth);
        System.out.println("firstOfMonth:        " + firstOfMonth);
        System.out.println("firstOfNextMonth:    " + firstOfNextMonth);
        System.out.println("firstMondayInMonth:  " + firstMondayInMonth);
        System.out.println("lastSaturdayInMonth: " + lastSaturdayInMonth);
    }
}
