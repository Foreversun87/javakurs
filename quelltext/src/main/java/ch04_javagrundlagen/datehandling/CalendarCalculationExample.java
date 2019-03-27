package ch04_javagrundlagen.datehandling;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Beispielprogramm für Berechnungen mithilfe der Calendar-Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class CalendarCalculationExample
{
	public static void main(final String[] args)
	{
	    // Schaltjahr 2000 => Berechnung bei Verschiebung um 1 Monat wichtig 
	    final Calendar feb2000 = new GregorianCalendar(2000, Calendar.FEBRUARY, 28);
	
	    // Einen Tag in die Vergangenheit 
	    final Calendar oneDayAgo = (Calendar) feb2000.clone();
	    oneDayAgo.add(Calendar.DAY_OF_YEAR, -1);
	
	    // Eine Woche in die Zukunft 
	    final Calendar oneWeekLater = (Calendar) feb2000.clone();
	    oneWeekLater.add(Calendar.WEEK_OF_YEAR, +1);
	
	    // Ausgabe als Date-Objekt 
	    System.out.println("oneDayAgo = " + oneDayAgo.getTime());
	    System.out.println("feb2000 = " + feb2000.getTime());
	    System.out.println("oneWeekLater = " + oneWeekLater.getTime());
	
	    // Schaltjahr 2000 => oneDayAgo < now < oneWeekFromNow 
	    System.out.println(oneDayAgo.before(feb2000));
	    System.out.println(feb2000.before(oneWeekLater));
	}

    private CalendarCalculationExample()
    {
    }
}
