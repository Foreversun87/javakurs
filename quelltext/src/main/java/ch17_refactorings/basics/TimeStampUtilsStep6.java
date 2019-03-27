package ch17_refactorings.basics;

import org.joda.time.DateTime;

/**
 * Beispiel für eine Kombination von Basis-Refactorings, Schritt 6
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class TimeStampUtilsStep6 
{
	public static String createTimeStampString(final DateTime start, 
					                           final boolean isMonthly) 
	{
		final int divisor = isMonthly ? 1 : 3;
		final String addition = isMonthly ? "" : "Q";
		final int value = ((start.getMonthOfYear() - 1) / divisor + 1);
	
		return start.getYear() + "-" + addition + value;
	}
}

