package ch03_oodesign;

import java.util.Arrays;

/**
 * Beispielklasse zur Demonstration der Auswirkungen der Referenzsemantik von Java
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class ReferenceSemanticsExample
{
    private static void changeSomething(String[] names)
    {
        // Änderungen auch im Original-Array
        names[0] = "Michael";
        names[1] = "changed this entry";

        // Keine Auswirkung auf das Original-Array
        names = new String[] { "Nearly Empty" };
    }

    public static void main(final String[] args)
    {
        final String[] names = { "Test1", "Test2", "!!!" };

        changeSomething(names);

        System.out.println(Arrays.toString(names));
    }
    
    private ReferenceSemanticsExample()
    {        
    }
}