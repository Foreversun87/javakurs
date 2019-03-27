package ch03_oodesign.generics;

import java.util.Date;

/**
 * Beispielprogramm, das die generische Pair-Klasse nutzt
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class GenericPairExample
{
    public static void main(final String[] args)
    {
        final Person wizard = new Person("Wizard", new Date(), "Kiel");
        final Person mike = new Person("Mike", new Date(), "Bremen");

        final Pair<String, Person> pair1 = new Pair<>("Dark", wizard);
        final Pair<String, Person> pair2 = new Pair<>("Iron", mike);

        System.out.println(pair1);
        System.out.println(pair2);
    }
    
    private GenericPairExample()
    {        
    }
}
