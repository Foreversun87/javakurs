package ch11_dateandtime;

import java.time.Clock;

/**
 * Beispielprogramm zur Demonstration der neuen Klasse Clock.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class FirstClockExample
{
    public static void main(final String[] args)
    {
        printClockAndMillis(Clock.systemUTC()); // Basis UTC
        printClockAndMillis(Clock.systemDefaultZone()); // Basis Default-Zeitzone 
    }

    private static void printClockAndMillis(final Clock clock)
    {
        final long millis = clock.millis(); // Basis UTC
        System.out.println(clock + " / ms: " + millis);
    }
}