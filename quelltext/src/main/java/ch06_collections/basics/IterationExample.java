package ch06_collections.basics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Beispielprogramm zur Demonstration der typsicheren Iteration �ber ein String[],
 * welches zuvor in eine Collection<Sting> gewandelt wird.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class IterationExample
{
    public static void main(final String[] args)
    {
        final String[] textArray = { "Durchlauf", "mit", "Iterator" };
        final Collection<String> infoTexts = Arrays.asList(textArray);

        final Iterator<String> it = infoTexts.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }

    private IterationExample()
    {
    }
}