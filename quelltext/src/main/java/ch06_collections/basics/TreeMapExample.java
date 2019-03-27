package ch06_collections.basics;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Beispielprogramm zur Demonstration der Zugriffsmethoden der Klasse TreeMap. 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014  by Michael Inden 
 */
public final class TreeMapExample
{
    public static void main(final String[] args)
    {
        final NavigableMap<String, Integer> nameToAgeMap = new TreeMap<>();
        nameToAgeMap.put("Max", 47);
        nameToAgeMap.put("Moritz", 39);
        nameToAgeMap.put("Micha", 43);
        
        System.out.println("floor   Ma: " + nameToAgeMap.floorKey("Ma"));
        System.out.println("higher  Ma: " + nameToAgeMap.higherKey("Ma"));
        System.out.println("lower   Mz: " + nameToAgeMap.lowerKey("Mz"));
        System.out.println("ceiling Mc: " + nameToAgeMap.ceilingEntry("Mc"));
    }
    
    private TreeMapExample()
    {
    }
}
