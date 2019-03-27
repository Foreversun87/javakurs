package ch11_dateandtime;

import java.time.Duration;

/**
 * Beispielprogramm zur Demonstration der neuen Klasse Duration.
 *
 * @author Michael Inden
 *
 * Copyright 2014 by Michael Inden
 */
public class DurationExample
{
    public static void main(final String[] args)
    {
        // Erzeugung
        final Duration durationFromSecs = Duration.ofSeconds(15);
        final Duration durationFromMinutes = Duration.ofMinutes(30);
        final Duration durationFromHours = Duration.ofHours(45);
        final Duration durationFromDays = Duration.ofDays(60);

        System.out.println("From Secs:    " + durationFromSecs);
        System.out.println("From Minutes: " + durationFromMinutes);
        System.out.println("From Hours:   " + durationFromHours);
        System.out.println("From Days:    " + durationFromDays);
    }
}