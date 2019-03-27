package ch06_collections.searchsortfilter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Beispielprogramm zur Demonstration des Sortierens von Arrays mit JDK 8-Spachmitteln
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ArraysSortJdk8Example
{
    public static void main(final String[] args)
    {
        final String[] manyNames = { "Andy", "Michael", "Tim", "Stefan" };

        // Comparable-basierte Sortierung 
        Arrays.sort(manyNames);
        System.out.println(Arrays.toString(manyNames));

        // Comparator-bestimmte Sortierung mit Lambda 
        final Comparator<String> byLength = 
        		                 (str1, str2) -> Integer.compare(str1.length(), str2.length());
        Arrays.sort(manyNames, byLength);
        System.out.println(Arrays.toString(manyNames));
    }
}
