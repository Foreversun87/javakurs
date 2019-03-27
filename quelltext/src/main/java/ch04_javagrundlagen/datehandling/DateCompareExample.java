package ch04_javagrundlagen.datehandling;

import java.util.Date;

/**
 * Beispielprogramm für Vergleiche mithilfe der Date-Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class DateCompareExample 
{
	public static void main(final String[] args) 
	{
		final long ONE_HOUR_MSEC = 60 * 60 * 1000;

		final Date now = new Date();
		final Date oneHourAgo = new Date(now.getTime() - ONE_HOUR_MSEC);

		// oneHourAgo < now 
		System.out.println(oneHourAgo.before(now));
		System.out.println(oneHourAgo.getTime() < now.getTime());
	}

	private DateCompareExample() 
	{
	}
}
