package ch06_collections.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration des Löschens aus einer Collection während einer Iteration.
 * durch Aufruf der Methode remove() des Iterators.
 * Das ist korrekt und vermeidet eine java.util.ConcurrentModificationException.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class IteratorRemoveCorrectedExample
{
    private static void removeEntriesWithPrefix(final List<String> entries, final String prefix)
    {
        final Iterator<String> it = entries.iterator();
        while (it.hasNext())
        {
            final String name = it.next();
            if (name.startsWith(prefix))
            {
                it.remove(); // KORREKT: Zugriff über remove() des Iterators
            }
        }
    }

    public static void main(final String[] args)
    {
        final String[] names = { "Andreas", "Carsten", "Clemens", "Merten", "Michael", "Peter" };

        // JDK 7: Diamond Operator
        final List<String> namesList = new ArrayList<>();
        namesList.addAll(Arrays.asList(names));

        removeEntriesWithPrefix(namesList, "M");
        System.out.println(namesList);
    }
}
