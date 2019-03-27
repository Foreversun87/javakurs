package ch22_optimierungen.memorybound;

import java.util.ArrayList;
import java.util.List;

import ch06_collections.basics.LruLinkedHashMap;
import ch22_optimierungen.examples.Gender;
import ch22_optimierungen.examples.Person;
import ch22_optimierungen.introduction.PerformanceUtils;

/**
 * Beispielprogramm zur Demonstration des Einflusses von Caching mit
 * unterschiedlichen Cache-Größen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class LruListCacheExample
{
    private final LruLinkedHashMap<String, Person> cacheMap;
    private final List<Person>                     persons;

    public LruListCacheExample(final List<Person> persons, final int cacheSize)
    {
        this.cacheMap = new LruLinkedHashMap<>(cacheSize);
        this.persons = persons;
    }

    public static void main(final String[] args)
    {
        final int PERSON_COUNT = 10_000;
        final List<Person> persons = new ArrayList<>();
        for (int i = 0; i < PERSON_COUNT; i++)
        {
            final Person newPerson = new Person("Person " + i, Gender.MALE, i);
            persons.add(newPerson);
        }

        final int[] cacheSizes = { 10, 20, 7 };
        for (int cacheSize : cacheSizes)
        {
            System.out.println("CacheSize = " + cacheSize);
            final LruListCacheExample cache = new LruListCacheExample(persons, cacheSize);

            performTests(cache, "findPersonByName", false);
            performTests(cache, "getPersonUsingCache", true);
        }
    }

    public static void performTests(final LruListCacheExample cache, final String info, final boolean useCache)
    {
        final long[] maxIterationCount = { 1000, 10_000, 100_000 };

        for (long max : maxIterationCount)
        {
            System.out.println("Element count " + max);

            PerformanceUtils.startMeasure(info);
            for (long i = 0; i < max; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    final String name = "Person " + (j * 1000);
                    if (useCache)
                        cache.getPersonUsingCache(name);
                    else
                        cache.findPersonByName(name);
                }
            }
            PerformanceUtils.stopMeasure(info);
            PerformanceUtils.printTimingResult(info);
        }
    }

    // ...

    public Person getPersonUsingCache(final String name)
    {
        Person cachedPerson = cacheMap.get(name);

        if (cachedPerson != null)
        {
        	return cachedPerson;
        }    	
         
        final Person person = findPersonByName(name);
        if (person != null)
        {
            cacheMap.put(name, person);            
        }
        return person;
    }

    private Person findPersonByName(final String name)
    {
        for (final Person current : persons)
        {
            if (current.getName().equals(name))
            {
                return current;
            }
        }
        return null;
    }
}
