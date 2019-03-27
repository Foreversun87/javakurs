package ch11_dateandtime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

/**
 * Beispielprogramm zur Demonstration der Verarbeitung von ZoneOffsets mit dem neuen Date-/Calendar-API.
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ZoneOffsetExample
{
    public static void main(final String[] args)
    {
        final Stream<String> zoneIdNames = Stream.of("Europe/Berlin", "America/Los_Angeles", "Australia/Adelaide");

        zoneIdNames.forEach(zoneIdName -> {
            final ZoneId zoneId = ZoneId.of(zoneIdName);
            final LocalDateTime ldt = LocalDateTime.now();
            final ZonedDateTime zdt = ldt.atZone(zoneId);
            final ZoneOffset offset = zdt.getOffset();

            System.out.format("offset for '%s' is %s\n", zoneId, offset);
        });
    }
}
