package ch11_dateandtime;

import java.time.DayOfWeek;
import java.time.Month;

/**
 * Beispielprogramm zur Demonstration der neuen Klassen Month und DayOfWeek.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class MonthAndDayOfWeekExample 
{
	public static void main(final String[] args) 
	{
		final DayOfWeek sunday = DayOfWeek.SUNDAY;
		final Month february = Month.FEBRUARY;

		final DayOfWeek friday = sunday.plus(5);
		final Month december = february.plus(10);
	
		System.out.println(friday);   // FRIDAY
		System.out.println(december); // DECEMBER
	}
}