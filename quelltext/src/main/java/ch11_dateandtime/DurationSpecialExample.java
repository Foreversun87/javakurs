package ch11_dateandtime;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Beispielprogramm zur Demonstration einiger Besonderheiten der neuen Klasse Duration.
 *
 * @author Michael Inden
 *
 * Copyright 2014, 2017 by Michael Inden
 */
public class DurationSpecialExample
{
    public static void main(final String[] args)
    {
        // Erzeugung
        final Instant christmas2013 = Instant.parse("2013-12-24T00:00:00Z");
        final Instant silvester2013 = Instant.parse("2013-12-31T00:00:00Z");

        // Achtung: Duration bietet nicht ofWeeks(long) oder ofMonths(long)
        final Instant silvester_OneWeek = christmas2013.plus(1, ChronoUnit.WEEKS);
        System.out.println(silvester_OneWeek);
    }
}
