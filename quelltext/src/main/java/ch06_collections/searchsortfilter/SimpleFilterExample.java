package ch06_collections.searchsortfilter;

import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration eines Zahlenfilters
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class SimpleFilterExample
{
    public static void main(final String[] args)
    {
        final List<Integer> intValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // int-Zahlenfilter auf den Wert 2
        final Filterable<Integer> numberFilter = new EqualsFilter<>(2);
        final List<Integer> filteredValues = FilterUtils.applyFilter(intValues, numberFilter);
        System.out.println(filteredValues);
        
        // int-Zahlenfilter größer als der Wert 4
        final Filterable<Integer> greaterFilter = new Greater<>(4);
        final List<Integer> filteredValues2 = FilterUtils.applyFilter(intValues, greaterFilter);
        System.out.println(filteredValues2);
    }
}