package ch11_dateandtime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm zur Demonstration von Problemen bei Berechnungen mithilfe der Klasse Date.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class OldApiDurationCalculationExample
{
    public static void main(final String[] args) throws ParseException
    {
        // Unterschied 1 Stunde, 10 Minute und 20 Sekunden
        final String startTimeAsString = "10:10:10";
        final String endTimeAsString = "11:20:30";

        // Umwandlung in Date-Objekte
        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        final Date startTimee = dateFormat.parse(startTimeAsString);
        final Date endTime = dateFormat.parse(endTimeAsString);

        // Berechne Differenz basierend auf Millitsekunden
        final long durationInMs = endTime.getTime() - startTimee.getTime();
        System.out.println("duration in seconds = " + TimeUnit.MILLISECONDS.toSeconds(durationInMs));

        final String duration1 = dateFormat.format(new Date(durationInMs));
        System.out.println("duration 1 = " + duration1);

        // Berechnung muss Zeitzone gesetzt bekommen
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        final String duration2 = dateFormat.format(new Date(durationInMs));
        System.out.println("duration2 = " + duration2);
    }
}