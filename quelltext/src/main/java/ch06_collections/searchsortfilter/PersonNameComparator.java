package ch06_collections.searchsortfilter;

import java.util.Comparator;
import java.util.Objects;

import ch06_collections.Person;

/**
 * Beispielklasse Komparator für Person-Objekte nach Name
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class PersonNameComparator implements Comparator<Person>
{
    public int compare(final Person person1, final Person person2)
    {
        Objects.requireNonNull(person1, "person1 must not be null");
        Objects.requireNonNull(person2, "person2 must not be null");

        return (person1.getName().compareTo(person2.getName()));
    }

    public static void alternatives()
    {
        final Comparator<Person> nameComparator = (person1, person2) -> {
            return person1.getName().compareTo(person2.getName());
        };

        final Comparator<Person> nameComparator2 = Comparator.comparing(Person::getName);
    }
}