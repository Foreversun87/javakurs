package ch06_collections.basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Beispielprogramm zur Demonstration der Ausgabe der Elemente eines HashSets.
 * Scheinbar wird eine Ordnung hergestellt, tatsächlich ist dies eher zufällig.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class HashSetStorageExample
{
    public static void main(String[] args)
    {
        final Integer[] ints = new Integer[] { 3, 2, 1 };
        // JDK 7: Diamond Operator
        final Set<Integer> numberSet = new HashSet<>(Arrays.asList(ints));

        System.out.println("Initial: " + numberSet); // 1, 2, 3
    }

    private HashSetStorageExample()
    {
    }
}
