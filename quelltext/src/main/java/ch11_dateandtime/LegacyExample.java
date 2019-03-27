package ch11_dateandtime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Beispielprogramm zur Demonstration der Interaktion mit dem alten Date-/Calendar-API.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class LegacyExample 
{
    public static void main(final String[] args) 
    {
        // Berechnungen basierend auf Date  
        final Date now = new Date();
        final Instant nowAsInstant = now.toInstant ();
        final Date nowFromAsInstant = Date.from(nowAsInstant);

        final ZoneId systemZone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(nowAsInstant, 
                                                                    systemZone);
        final ZoneId zoneCalifornia = ZoneId.of("America/Los_Angeles");
        final ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(nowAsInstant, 
                                                                    zoneCalifornia);
        
        // Berechnungen basierend auf Calendar  
        final GregorianCalendar nowAsCalendar = new GregorianCalendar();
        final ZonedDateTime nowAsZonedDateTime = nowAsCalendar.toZonedDateTime();
        final GregorianCalendar calendarFromZoned = 
                                GregorianCalendar.from(nowAsZonedDateTime);
        final Instant instant = nowAsZonedDateTime.toInstant();

        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("ZonedDateTime: " + zonedDateTime);
        System.out.println("Instant:       " + instant);
    }
}