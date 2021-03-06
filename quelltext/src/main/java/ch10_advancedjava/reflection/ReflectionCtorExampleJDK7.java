package ch10_advancedjava.reflection;

import java.lang.reflect.Constructor;

/**
 * Die Klasse <code>ReflectionCtorExample</code> zeigt den Aufruf
 * eines Konstruktors.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class ReflectionCtorExampleJDK7
{
    public static void main(final String[] args)
    {
        try
        {
            final Class<?> stringClass = Class.forName("java.lang.String");

            // Aufruf des Defaultkonstruktors
            final String stringInstance1 = (String) stringClass.newInstance();

            // Suche den Konstruktor String(char[], int, int)
            final Class<?>[] parameterTypes = new Class<?>[] { char[].class, int.class, int.class };
            final Constructor<?> ctor = stringClass.getDeclaredConstructor(parameterTypes);

            // Aufruf des Konstruktors String(char[], int, int)
            final char[] input = { 'a', ' ', 'T', 'e', 's', 't' };
            final Integer offset = 2;
            final Integer count = 4;
            final String stringInstance2 = (String) ctor.newInstance(input, offset, count);

            System.out.println("String 1 = '" + stringInstance1 + "'");
            System.out.println("String 2 = '" + stringInstance2 + "'");
        }
        // Behandlung sämtlicher durch Reflection möglicher Exceptions
        catch (final ReflectiveOperationException e)
        {        
            throw new IllegalStateException("can't execute constructor by reflection", e);
        }
    }

    private ReflectionCtorExampleJDK7() {
    }
}
