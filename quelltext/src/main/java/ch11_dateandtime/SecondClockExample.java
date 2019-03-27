package ch11_dateandtime;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Beispielprogramm zur Demonstration der neuen Klasse Clock.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class SecondClockExample 
{
	public static void main(final String[] args) throws InterruptedException
	{
	   final Clock clock1 = Clock.systemUTC();
	   final Clock clock2 = Clock.systemDefaultZone();
	   final Clock clock3 = Clock.fixed(Instant.now(), ZoneId.of("Asia/Hong_Kong"));

	   printClocks(clock1, clock2, clock3);

	   Thread.sleep(10_000);
	   System.out.println("\nAfter 10 s\n");

	   printClocks(clock1, clock2, clock3);
	}

	private static void printClocks(final Clock... clocks)
	{
	   for (final Clock clock : clocks)
	   {
	      System.out.println("LocalTime: " + LocalTime.now(clock));
	   }
	}
}