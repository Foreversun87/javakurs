package ch11_dateandtime;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Beispielprogramm zur Demonstration der neuen Klasse Instant.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class InstantExample 
{
	public static void main(final String[] args) 
	{
		// Abfahrt jetzt und Reisedauer 5 Stunden 
		final Instant departureTime = Instant.now();
	  	final Instant expectedArrivalTime = departureTime.plus(5, ChronoUnit.HOURS);
	
		// Verspätung von 7 Minuten auf zwei Arten berechnen  
	  	final Instant realArrival = expectedArrivalTime.plus(7, ChronoUnit.MINUTES);
	  	final Instant realArrival2 = expectedArrivalTime.plus(Duration.ofMinutes(7));
	
	  	System.out.println(departureTime);		    // 2014-03-22T13:54:50.818Z 	
	  	System.out.println(expectedArrivalTime);	    // 2014-03-22T18:54:50.818Z
	  	System.out.println(realArrival);			    // 2014-03-22T19:01:50.818Z
	  	System.out.println(realArrival2);			// 2014-03-22T19:01:50.818Z
	}
}