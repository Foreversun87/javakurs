package ch06_collections.basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Beispielprogramm zur Demonstration der Ausgabe der Elemente eines HashSets.
 * Scheinbar wird eine Ordnung hergestellt, tatsächlich ist dies eher zufällig.
 * In diesem Beispiel wird diese Tatsache offensichtlich.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class HashSetStorageExample2
{
    public static void main(String[] args)
    {
        final Integer[] ints = new Integer[] { 3, 2, 1 };
        final Set<Integer> numberSet = new HashSet<>(Arrays.asList(ints));
        System.out.println("Initial: " + numberSet); // 1, 2, 3 

        final Integer[] moreInts = new Integer[] { 33, 11, 22 };
        numberSet.addAll(Arrays.asList(moreInts));
        System.out.println("Add: " + numberSet); // 1, 33, 2, 3, 22, 11 
    }

    private HashSetStorageExample2()
    {
    }
}
