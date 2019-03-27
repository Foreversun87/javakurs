package ch04_javagrundlagen.basics;

import java.util.Date;

import ch04_javagrundlagen.Person;

/**
 * Beispielprogramm zur Demonstration von Ausgaben mit toString()
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class ToStringExample
{
    public static void main(final String[] args)
    {
        final Object obj = new Object();
        final Person tom = new Person("Tom", new Date(), "Hamburg");
        final Object[] objectArray = new Object[] { obj, tom };

        System.out.println("Object: " + obj);
        System.out.println("Person: " + tom);
        System.out.println("Object[]: " + objectArray);
    }
    
    private ToStringExample()
    {
    }
}