package ch11_dateandtime;

import java.time.Month;
import java.time.ZonedDateTime;

/**
 * Beispielprogramm zur Demonstration der neuen Klasse ZonedDateTime.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ZonedDateTimeExample 
{
	public static void main(final String[] args)
	{
		// Aktuelle Zeit als ZonedDateTime-Objekt ermitteln  
		final ZonedDateTime now = ZonedDateTime.now();
		
		// Dort die Uhrzeit ändern und in neuem Objekt speichern  
		final ZonedDateTime nowButChangedTime = now.withHour(11).withMinute(44);
		
		// Neues Objekt mit verändertem Datum erzeugen  
		final ZonedDateTime dateAndTime = nowButChangedTime.withYear(2008).
		                                                    withMonth(9).
		                                                    withDayOfMonth(29);

		// Neues Objekt mit verändertem Datum erzeugen  
		final ZonedDateTime dateAndTime2 = nowButChangedTime.withYear(2008).
                                       withMonth(Month.SEPTEMBER.getValue()).
                                       withDayOfMonth(29);
		
		System.out.println("now:          " + now);
		System.out.println("-> 11:44:     " + nowButChangedTime);
		System.out.println("-> 29.9.2008: " + dateAndTime);
		System.out.println("-> 29.9.2008: " + dateAndTime2);
	}
}