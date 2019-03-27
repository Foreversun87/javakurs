package ch07_bulk_operations.advanced;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm zur Demonstration der Aufbereitung eines Histogramms
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class HistogramExample
{
    public static void main(final String[] args)
    {
       final String[] names = { "tom", "Tim", "Mike", "Kai", "mike", "kai", "Kai", "TOM" };

       System.out.println(histogram(Stream.of(names), String::toLowerCase));
    }
    
    public static <T> Map<T, Long> histogram(final Stream<T> stream,
                                             final Function<T, T> groupFunction)
    {
        return stream.collect(Collectors.groupingBy(groupFunction, Collectors.counting()));
    }
}
