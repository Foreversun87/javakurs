package ch06_collections.searchsortfilter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Beispielprogramm zeigt die Definition von null-sicheren Komparatoren, die null-Werte am Anfang bzw. am Ende einsortieren.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class NullSafeComparatorExample
{
    public static void main(final String[] args)
    {
        final List<String> names = Arrays.asList("A", null, "B", "C", null, "D");

        // Null-sichere Komparatoren
        final Comparator<String> naturalOrder = Comparator.naturalOrder();
        final Comparator<String> nullsFirst = Comparator.nullsFirst(naturalOrder);
        final Comparator<String> nullsLast = Comparator.nullsLast(naturalOrder);

        names.sort(nullsFirst);
        System.out.println("nullsFirst: " + names);

        names.sort(nullsLast);
        System.out.println("nullsLast:  " + names);
    }
}