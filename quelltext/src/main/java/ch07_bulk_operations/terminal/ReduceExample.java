package ch07_bulk_operations.terminal;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Beispielprogamm zeigt die Methode reduce() zur Berechnung von Ergebnissen.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class ReduceExample
{
    public static void main(final String[] args)
    {
        final Stream<String> names = Stream.of("Mike", "Tom", "Peter", "Chris");
        final Stream<Integer> integers = Stream.of(1, 2, 3, 4, 5);

        final Optional<String> stringConcat = names.reduce((s1, s2) -> s1 + ", " + s2);
        final Optional<Integer> multiplication = integers.reduce((s1, s2) -> s1 * s2);

        System.out.println("stringConcat:   " + stringConcat);
        System.out.println("multiplication: " + multiplication);
    }
}