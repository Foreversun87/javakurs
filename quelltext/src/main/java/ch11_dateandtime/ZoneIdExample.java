package ch11_dateandtime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm zur Demonstration der Verarbeitung von ZoneIds mit dem neuen Date-/Calendar-API.
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ZoneIdExample
{
    public static void main(final String[] args)
    {
        final Stream<String> zoneIdNames = Stream.of("Asia/Chungking", "Africa/Nairobi", "America/Los_Angeles");

        zoneIdNames.forEach(zoneIdName -> {
            final ZoneId zoneId = ZoneId.of(zoneIdName);
            final LocalTime now = LocalTime.now(zoneId);

            System.out.println(zoneIdName + ": " + now);
        });

        final Set<String> allZones = ZoneId.getAvailableZoneIds();
        final Predicate<String> inEurope = name -> name.startsWith("Europe/");
        final List<String> threeFromEurope = allZones.stream().filter(inEurope).limit(3).collect(Collectors.toList());

        System.out.println("\nSome timezones in europe:");
        threeFromEurope.forEach(System.out::println);
    }
}
