package ch17_refactorings.basics;

import org.joda.time.DateTime;

/**
 * Beispiel für eine Kombination von Basis-Refactorings, Schritt 9
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class TimeStampUtilsStep9 
{
	public static String createTimeStampString(final DateTime start, 
					                           final boolean isMonthly) 
	{
		final int divisor;
		final String addition;
		final int value;
		if (isMonthly) {
			divisor = 1;		
			addition = isMonthly ? "" : "Q";
			value = ((start.getMonthOfYear() - 1) / divisor + 1);
		} else {
			divisor = 3;
			addition = isMonthly ? "" : "Q";
			value = ((start.getMonthOfYear() - 1) / divisor + 1);
		}
		
		// Consolidate Duplicate Conditional Fragment => Invers
		//addition = isMonthly ? "" : "Q";
		return start.getYear() + "-" + addition + value;
	}
}

