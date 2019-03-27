package ch06_collections.optional;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Beispielprogramm zur Demonstration der Klassen OptionalInt und OptionalDouble bei der Verarbeitung primitiver Werte.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class OptionalPrimitivesExample
{
    public static void main(final String[] args)
    {
        final int[] sampleValues = { 1, 3, 5, 7, 11, 13, 17 };

        final OptionalInt max = IntStream.of(sampleValues).max();
        final OptionalInt min = IntStream.of(sampleValues).min();
        final OptionalDouble avg = IntStream.of(sampleValues).average();

        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("avg: " + avg);
    }
}