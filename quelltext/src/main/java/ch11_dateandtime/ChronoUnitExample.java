package ch11_dateandtime;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Beispielprogramm zur Demonstration der neuen Klasse ChronoUnit.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ChronoUnitExample 
{
	public static void main(final String[] args) 
	{
	     final Instant departureTime = Instant.now();
	     System.out.println("departure now:    " + departureTime);        
	 
	     final Instant arrivalTime = departureTime.plus(5, ChronoUnit.HOURS);
	     System.out.println("arrival now + 5h: " + arrivalTime);		     

	     // Berechnungen durchführen
	     final long inBetweenHours = ChronoUnit.HOURS.between(departureTime, 
	                                                          arrivalTime);
	     final long inBetweenMinutes = ChronoUnit.MINUTES.between(departureTime, 
	                                                              arrivalTime);
	     System.out.println("inBetweenHours:   " + inBetweenHours);       
	     System.out.println("inBetweenMinutes: " + inBetweenMinutes);      
	}
}