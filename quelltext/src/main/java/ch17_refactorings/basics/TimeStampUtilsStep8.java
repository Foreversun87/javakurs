package ch17_refactorings.basics;

import org.joda.time.DateTime;

/**
 * Beispiel für eine Kombination von Basis-Refactorings, Schritt 8
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class TimeStampUtilsStep8 
{
	public static String createTimeStampString(final DateTime start, 
					                           final boolean isMonthly) 
	{
		final int divisor;
		final String addition;
		if (isMonthly) {
			divisor = 1;
			addition = "";
		} else {
			divisor = 3;
			addition = "Q";
		}
	
		return start.getYear() + "-" + addition + ((start.getMonthOfYear() - 1) / divisor + 1);
	}
}
