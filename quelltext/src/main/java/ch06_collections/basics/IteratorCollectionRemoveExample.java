package ch06_collections.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration des L�schens aus einer Collection w�hrend einer Iteration
 * durch Aufruf der Methode remove() der Collection.
 * Das ist problematisch und f�hrt zu einer java.util.ConcurrentModificationException.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class IteratorCollectionRemoveExample
{
    private static void removeEntriesWithPrefix(final List<String> entries, final String prefix)
    {
        final Iterator<String> it = entries.iterator();
        while (it.hasNext())
        {
            final String name = it.next();
            if (name.startsWith(prefix))
            {
                // ACHTUNG: intuitiv aber falsch !!! 
                // Zugriff �ber remove() der Collection 
                entries.remove(name);
            }
        }
    }

    public static void main(final String[] args)
    {
        final String[] names = { "Andreas", "Carsten", "Clemens", "Mike", "Merten" };

        // JDK 7: Diamond Operator
        final List<String> namesList = new ArrayList<>();
        namesList.addAll(Arrays.asList(names));

        removeEntriesWithPrefix(namesList, "M");
        System.out.println(namesList);
    }
}
