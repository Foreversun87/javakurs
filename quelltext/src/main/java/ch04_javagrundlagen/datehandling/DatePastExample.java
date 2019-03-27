package ch04_javagrundlagen.datehandling;

import java.util.Date;

/**
 * Beispielprogramm zur Demonstration von Besonderheiten (Offset 1970) der Date-Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class DatePastExample
{
    public static void main(final String[] args)
    {
        System.out.println(new Date(-10_000_000)); // Wed Dec 31 22:13:20 CET 1969
    }

    private DatePastExample()
    {
    }
}