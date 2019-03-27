package ch06_collections.searchsortfilter;

/**
 * Filterkriterium Konverter-Klasse zum Zugriff auf einzelne Attribute der Klasse SimplePerson
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class SimplePersonNameFilter implements Filterable<SimplePerson>
{
    private final Filterable<String> stringFilter;
    
    public SimplePersonNameFilter(final Filterable<String> stringFilter)
    {
        this.stringFilter = stringFilter;
    }
    
    @Override
    public boolean accept(final SimplePerson person)
    {        
        return stringFilter.accept(person.getName());
    }
}