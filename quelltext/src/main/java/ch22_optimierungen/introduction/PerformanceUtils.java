package ch22_optimierungen.introduction;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utilityklasse zur Unterst�tzung von Performancemessungen
 *
 * @author Michael Inden
 *
 * Copyright 2011, 2014, 2017 by Michael Inden
 */
public final class PerformanceUtils
{
    private static final Logger                   log       = LogManager.getLogger(PerformanceUtils.class);
    private static final Map<String, TimingEntry> timingMap = new HashMap<>();

    private static final class TimingEntry
    {
        private final long startTime;
        private long       stopTime;

        public TimingEntry(final long startTime)
        {
            this.startTime = startTime;
        }

        public void setStopTime(final long stopTime)
        {
            this.stopTime = stopTime;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(this.startTime);
        }

        @Override
        public boolean equals(final Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            final TimingEntry other = (TimingEntry) obj;
            return (startTime == other.startTime && stopTime == other.stopTime);
        }
    }

    public static void startMeasure(final String name)
    {
        timingMap.put(name, new TimingEntry(System.nanoTime()));
    }

    public static long stopMeasure(final String name)
    {
        final TimingEntry timingEntry = getTimingEntry(name);
        timingEntry.setStopTime(System.nanoTime());
        return TimeUnit.NANOSECONDS.toMillis( timingEntry.stopTime - timingEntry.startTime);
    }

    public static void printTimingResult(final String name)
    {
        final TimingEntry timingEntry = getTimingEntry(name);
        printTimingResult(name, timingEntry.startTime, timingEntry.stopTime);
    }

    public static void printTimingResult(final String info, final long begin, final long end)
    {
        System.out.println(info + " took " + TimeUnit.NANOSECONDS.toMillis(end - begin) + " ms");
    }

    public static void printTimingResultWithAverage(final String name, final long count)
    {
        final TimingEntry timingEntry = getTimingEntry(name);
        printTimingResultWithAverage(name, timingEntry.startTime, timingEntry.stopTime, count);
    }

    public static void printTimingResultWithAverage(final String info, final long begin, final long end,
                                                    final long count)
    {
        printTimingResult(info, begin, end);

        final double avg = TimeUnit.NANOSECONDS.toMillis(end - begin) / (double) count;
        System.out.println(String.format(info + " avg %f ms", avg));
    }

    private static TimingEntry getTimingEntry(final String name)
    {
        final TimingEntry timingEntry = timingMap.get(name);
        if (timingEntry == null)
            throw new IllegalArgumentException("No data for '" + name + "'");

        return timingEntry;
    }
}
