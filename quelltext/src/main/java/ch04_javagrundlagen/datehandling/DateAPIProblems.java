package ch04_javagrundlagen.datehandling;

import java.util.Date;

/**
 * Beispielprogramm zur Demonstration von Merkwürdigkeiten ((Offset 1900) der Date-Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class DateAPIProblems
{
    public static void main(final String[] args)
    {
        // Mein Geburtstag: 7.2.1971
        final int year = 1971;
        final int month = 2;
        final int day = 7;
        
        System.out.println(new Date(year, month, day));
    }

    private DateAPIProblems()
    {
    }
}