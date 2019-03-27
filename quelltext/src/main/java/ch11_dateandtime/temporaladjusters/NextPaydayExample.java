package ch11_dateandtime.temporaladjusters;

import java.time.LocalDate;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

/**
 * Beispielprogramm zur Demonstration des selbstdefinierten NextPaydayAdjuster.
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class NextPaydayExample
{
    public static void main(final String[] args)
    {
    	final LocalDate jan = LocalDate.of(2015, JANUARY, 31);
    	final LocalDate nextPayday1 = jan.with(new NextPaydayAdjuster());

    	final LocalDate feb = LocalDate.of(2015, FEBRUARY, 7);
    	final LocalDate nextPayday2 = feb.with(new NextPaydayAdjuster());

    	System.out.println("Next Payday Jan: " + nextPayday1);
    	System.out.println("Next Payday Feb: " + nextPayday2);
    }
}

