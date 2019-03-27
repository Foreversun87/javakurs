package ch06_collections.searchsortfilter;

import java.util.Comparator;

import ch06_collections.Person;

/**
 * Beispielklasse Komparator f�r Person-Objekte nach Alter 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class PersonAgeComparator implements Comparator<Person>
{
    public int compare(final Person person1, final Person person2)
    {
        if (person1.getAge() < person2.getAge())
        {
            return -1;
        }
        if (person1.getAge() > person2.getAge())
        {
            return 1;
        }

        return 0;
    }
}