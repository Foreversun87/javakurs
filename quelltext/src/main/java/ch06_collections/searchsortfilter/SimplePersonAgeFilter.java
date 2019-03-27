package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Filterkriterium Konverter-Klasse zum Zugriff auf einzelne Attribute der Klasse SimplePerson
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class SimplePersonAgeFilter implements Filterable<SimplePerson>
{
    private final Filterable<Integer> intFilter;
    
    public SimplePersonAgeFilter(final Filterable<Integer> intFilter)
    {
        this.intFilter = Objects.requireNonNull(intFilter, "intFilter must not be null");
    }
    
    @Override
    public boolean accept(final SimplePerson person)
    {        
        return intFilter.accept(person.getAge());
    }
}