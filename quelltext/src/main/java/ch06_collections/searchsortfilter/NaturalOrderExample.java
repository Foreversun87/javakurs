package ch06_collections.searchsortfilter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Beispielprogramm zeigt die Definition von verschiedenen Komparatoren unter anderem zur natürlichen Ordnung und der dazu inversen Ordnung.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class NaturalOrderExample
{
    public static void main(final String[] args)
    {
        final Integer[] primes = { 1, 7, 3, 13, 11, 5, 17, 19 };

        final Comparator<Integer> naturalOrder = Comparator.naturalOrder(); // aufsteigend
        final Comparator<Integer> reverseOrder = Comparator.reverseOrder(); // absteigend
        final Comparator<Integer> naturalOrderAgain = reverseOrder.reversed(); // aufsteigend

        sortAndPrint("naturalOrder     ", primes, naturalOrder);
        sortAndPrint("reverseOrder     ", primes, reverseOrder);
        sortAndPrint("naturalOrderAgain", primes, naturalOrderAgain);

    }

    private static void sortAndPrint(final String name, final Integer[] primes, final Comparator<Integer> sortOrder)
    {
        Arrays.sort(primes, sortOrder);
        System.out.println(name + ": " + Arrays.toString(primes));
    }
}