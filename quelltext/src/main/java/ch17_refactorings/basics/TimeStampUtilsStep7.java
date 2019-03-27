package ch17_refactorings.basics;

import org.joda.time.DateTime;

/**
 * Beispiel für eine Kombination von Basis-Refactorings, Schritt 7
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class TimeStampUtilsStep7 
{
	public static String createTimeStampString(final DateTime start, 
					                           final boolean isMonthly) 
	{
		final int divisor = isMonthly ? 1 : 3;
		final String addition = isMonthly ? "" : "Q";
		
		// Inline
		return start.getYear() + "-" + addition + ((start.getMonthOfYear() - 1) / divisor + 1);
	}
}

