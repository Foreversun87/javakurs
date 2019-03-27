package ch17_refactorings.basics;

import org.joda.time.DateTime;

/**
 * Beispiel für eine Kombination von Basis-Refactorings
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class TimeStampUtils 
{
	public static String createTimeStampString(final MyTimePeriod currentPeriod, 
					                           final MyFrequency frequency) 
	{
		final DateTime start = currentPeriod.getDateTime();

		final int divisor = frequency == MyFrequency.P1M ? 1 : 3;
		final String addition = frequency == MyFrequency.P1M ? "" : "Q";
		final int value = ((start.getMonthOfYear() - 1) / divisor + 1);

		return start.getYear() + "-" + addition + value;
	}
}
