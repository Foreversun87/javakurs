package ch11_dateandtime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 *  Beispielprogramm zur Demonstration der Interaktion mit dem alten Date-/Calendar-API.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class DateToLocalDateExample
{
    public static void main(String[] args)
    {
        // Konvertierungen von ZonedDateTime -> Date  
        final ZonedDateTime nowZdt = ZonedDateTime.now();
        final Date nowAsDate1 = Date.from(nowZdt.toInstant());
        System.out.println("From ZonedDateTime:      " + nowAsDate1);

        // Konvertierungen von LocalDateTime -> Date 
        final LocalDateTime startLdt = LocalDateTime.parse("2015-05-09T16:27:38");

        // Variante 2 mit Umwandlung erst in ZonedDateTime per atZone()  
        final ZonedDateTime zdt = startLdt.atZone(ZoneId.systemDefault());
        final Date nowAsDate2 = Date.from(zdt.toInstant());
        System.out.println("From LocalDateTime V2:   " + nowAsDate2);

        // Variante 3 mit ZoneOffset  
        final Date nowAsDate3 = Date.from(startLdt.toInstant(zdt.getOffset()));
        System.out.println("From LocalDateTime V3:   " + nowAsDate3);

        // Konvertierungen von Date -> LocalDateTime usw.  
        final Instant instant = Instant.ofEpochMilli(nowAsDate3.getTime());
        final LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("LocalDateTime from Date: " + ldt);

        // Umwandlung in LocalDate bzw. LocalTime  
        final LocalDate ld = ldt.toLocalDate();
        System.out.println("LocalDate:               " + ld);
        final LocalTime lt = ldt.toLocalTime();
        System.out.println("LocalTime:               " + lt);
    }
}
