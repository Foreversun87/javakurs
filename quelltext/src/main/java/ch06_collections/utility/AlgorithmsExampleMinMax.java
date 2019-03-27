package ch06_collections.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ch06_collections.Person;

/**
 * Beispielprogramm zur Demonstration der Methoden min() und max()
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class AlgorithmsExampleMinMax
{
    public static void main(final String[] args)
    {
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Anton", "Tirol", 11));
        persons.add(new Person("Micha", "Zürich", 43));
        persons.add(new Person("Stefan", "Kiel", 43));
        
        // Bestimmung min() / max() mit Comparable 
        final Person min = Collections.min(persons);
        final Person max = Collections.max(persons);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        // Bestimmung max() mit eigenem Komparator 
        // Besonderheit: Diamond Operator nicht fï¿½r annonyme innere Klassen erlaubt
        final Comparator<Person> cityComparator = Comparator.comparing(Person::getCity);        		            
        final Person maxCity = Collections.max(persons, cityComparator);
        System.out.println("Max city: " + maxCity);
    }

    private AlgorithmsExampleMinMax()
    {
    }
}