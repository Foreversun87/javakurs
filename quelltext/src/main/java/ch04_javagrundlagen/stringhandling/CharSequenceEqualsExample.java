package ch04_javagrundlagen.stringhandling;

/**
 * Beispielprogramm zur Demonstration von Merkwürdigkeiten beim Vergleich von CharSequence-Objekten
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class CharSequenceEqualsExample
{
    public static void main(final String[] args)
    {
        final CharSequence cs1 = new StringBuilder("same");
        final CharSequence cs2 = new StringBuilder("same");
        final CharSequence cs3 = "same";
        final CharSequence cs4 = "same";
        final CharSequence cs5 = new String("same");

        System.out.println(cs1.equals(cs2)); // false
        System.out.println(cs1.equals(cs3)); // false
        System.out.println(cs3.equals(cs4)); // true
        System.out.println(cs3.equals(cs5)); // true
    }
}
