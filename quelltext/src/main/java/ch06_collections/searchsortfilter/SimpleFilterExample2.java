package ch06_collections.searchsortfilter;

import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration komplexerer Zahlenfilter
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class SimpleFilterExample2
{
    public static void main(final String[] args)
    {
        final List<Integer> intValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        // Ermittle alle Werte, die "NICHT im Bereich 4-11" liegen 
        final Filterable<Integer> inverseNumberFilter = new Not<>(new Between<>(4, 11));
        final List<Integer> filteredValues1 = FilterUtils.applyFilter(intValues, inverseNumberFilter);
        System.out.println("![4-11]:        " + filteredValues1);

        // Ermittle alle Werte, die "im Bereich 3-7 liegen oder gr��er als 12" sind 
        final Filterable<Integer> range2_7OrGreater12 = new Or<>(new Between<>(3, 7),
                                                              new Greater<>(12));
        final List<Integer> filteredValues2 = FilterUtils.applyFilter(intValues, range2_7OrGreater12);
        System.out.println("[3-7] oder >12: " + filteredValues2);
    }
}
   