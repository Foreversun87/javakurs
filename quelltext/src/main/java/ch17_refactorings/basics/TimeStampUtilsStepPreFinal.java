package ch17_refactorings.basics;

import org.joda.time.DateTime;

/**
 * Beispiel für eine Kombination von Basis-Refactorings, kurz vor dem finalen Schritt
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class TimeStampUtilsStepPreFinal 
{
	public static String createTimeStampString(final DateTime start, 
					                           final boolean isMonthly) 
	{
		if (isMonthly) 
		{
			return start.getYear() + "-" + ((start.getMonthOfYear() - 1) / 1 + 1);
		}
		return start.getYear() + "-Q" + ((start.getMonthOfYear() - 1) / 3 + 1);
	}
}
