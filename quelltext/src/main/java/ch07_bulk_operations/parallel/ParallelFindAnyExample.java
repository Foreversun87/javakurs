package ch07_bulk_operations.parallel;

import java.util.stream.IntStream;

/**
 * Beispielprogamm zeigt die Methode findAny() für einen paralleln Stream
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class ParallelFindAnyExample
{
    public static void main(final String[] args)
    {
        IntStream.range(0, 10_000).filter(i -> i % 2 == 0).
                                   parallel().findAny().
                                   ifPresent(System.out::println);
    }
}
