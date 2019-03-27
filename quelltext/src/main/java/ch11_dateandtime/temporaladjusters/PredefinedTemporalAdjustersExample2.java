package ch11_dateandtime.temporaladjusters;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.Month.FEBRUARY;
import static java.time.temporal.TemporalAdjusters.dayOfWeekInMonth;
import static java.time.temporal.TemporalAdjusters.ofDateAdjuster;

/**
 * Beispielprogramm zur Demonstration weiterer vordefinierter TemporalAdjuster.
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class PredefinedTemporalAdjustersExample2
{
    public static void main(final String[] args)
    {
        ofDateAdjusterCalculations();
        dayOfWeekInMonthCalculations();
    }

    private static void ofDateAdjusterCalculations()
    {
        System.out.println("Adjusting with ofDateAdjuster()");
        System.out.println("-------------------------------");

        final Map<String, TemporalAdjuster> adjusters = new LinkedHashMap<>();
        adjusters.put("ONE_WEEK_LATER", ofDateAdjuster(localDate -> localDate.plusDays(7)));
        adjusters.put("FOUR_WEEKS_LATER", ofDateAdjuster(localDate -> localDate.plusDays(28)));
        adjusters.put("ONE_MONTH_LATER", ofDateAdjuster(localDate -> localDate.plusMonths(1)));

        final LocalDate base = LocalDate.of(2012, FEBRUARY, 27);
        applyAdjusters(base, adjusters);
    }

    private static void dayOfWeekInMonthCalculations()
    {
        System.out.println("\nAdjusting with dayOfWeekInMonth()");
        System.out.println("---------------------------------");

        final Map<String, TemporalAdjuster> adjusters = new LinkedHashMap<>();
        adjusters.put("THIRD_FRIDAY", dayOfWeekInMonth(3, FRIDAY));
        adjusters.put("LAST_FRIDAY", dayOfWeekInMonth(-1, FRIDAY));
        adjusters.put("LAST_FRIDAY_LAST_MONTH", dayOfWeekInMonth(0, FRIDAY));
        adjusters.put("FRIDAY_3_WEEKS_BEFORE_LAST", dayOfWeekInMonth(-4, FRIDAY));
        adjusters.put("FRIDAY_4_WEEKS_BEFORE_LAST", dayOfWeekInMonth(-5, FRIDAY));

        final LocalDate base = LocalDate.of(2015, FEBRUARY, 7);
        applyAdjusters(base, adjusters);
    }

    private static void applyAdjusters(final LocalDate base, final Map<String, TemporalAdjuster> adjusters)
    {
        System.out.println("Starting on: " + base);

        adjusters.forEach((name, adjuster) -> {
            System.out.println("adjusting to " + name + ": " + base.with(adjuster));
        });
    }
}
