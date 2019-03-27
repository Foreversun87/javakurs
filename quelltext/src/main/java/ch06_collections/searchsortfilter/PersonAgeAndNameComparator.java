package ch06_collections.searchsortfilter;

import java.util.Comparator;

import ch06_collections.Person;

/**
 * Beispielklasse Komparator für Person-Objekte nach Alter und Name
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class PersonAgeAndNameComparator implements Comparator<Person>
{
    public int compare(final Person person1, final Person person2)
    {                
        int ret = Integer.compare(person1.getAge(), person2.getAge());      
        if (ret == 0)
        {
            ret = person1.getName().compareTo(person2.getName());
        }

        return ret;
    }
}
