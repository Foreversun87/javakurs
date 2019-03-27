package ch04_javagrundlagen.primitives_and_wrappers;

/**
 * Beispiel zur Demonstration der Fallstricke beim Casten auf kleinere Datentypen 
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ShortTruncationExample
{
    public static void main(final String[] args)
    {
        final short truncated = (short) 1_000_000;

        System.out.println("truncated: " + truncated);
    }
}
