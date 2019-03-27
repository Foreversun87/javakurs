package ch04_javagrundlagen.primitives_and_wrappers;

/**
 * Beispielprogramm zur Demonstration von Merkwürdigkeiten beim Auto-Boxing
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class AutoBoxingCacheExample
{
    public static void main(final String[] args)
    {
        // Cache = Objekt aus dem Cache, New = Neues Objekt 
        final Integer i1 = 7; // Auto-Boxing => Cache 
        final Integer i2 = 4711; // Auto-Boxing => New 

        System.out.println(i1 == new Integer(7)); //  false, Cache != New 
        System.out.println(i2 == new Integer(4711)); // false, New != New 
        System.out.println(i1 == Integer.valueOf(7)); // TRUE !!!, Cache == Cache  
        System.out.println(i2 == Integer.valueOf(4711)); // false, New != New 
    }

    private AutoBoxingCacheExample()
    {
    }
}
