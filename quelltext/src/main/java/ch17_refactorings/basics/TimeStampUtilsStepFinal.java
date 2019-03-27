package ch17_refactorings.basics;

import org.joda.time.DateTime;

/**
 * Beispiel für eine Kombination von Basis-Refactorings, finaler Schritt
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class TimeStampUtilsStepFinal 
{
	public static String createTimeStampString(final DateTime start, 
					                           final boolean isMonthly) 
	{
		if (isMonthly) 
		{
			return start.getYear() + "-" + start.getMonthOfYear();
		}
		return start.getYear() + "-Q" + (1 + (start.getMonthOfYear() - 1) / 3);
	}
}
