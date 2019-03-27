package ch06_collections.utility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration der Methoden nCopies() und frequency()
 *
 * @author Michael Inden
 *
 * Copyright 2011, 2017 by Michael Inden
 */
public final class AlgorithmsExample
{
    public static void main(final String[] args)
    {
        final List<Integer> firstNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        final List<Integer> sevens = Collections.nCopies(4, 7);

        final int count1 = Collections.frequency(firstNumbers, 7);
        final int count2 = Collections.frequency(sevens, 7);
        System.out.println("count1: " + count1);
        System.out.println("count2: " + count2);
    }

    private AlgorithmsExample()
    {
    }
}
