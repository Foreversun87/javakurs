package ch06_collections.searchsortfilter;

import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration einzelner Filterkriterien sowie deren Kombination
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class FilterExample
{
    public static void main(final String[] args)
    {
        final SimplePerson demo1 = new SimplePerson("Meyer1", 11);
        final SimplePerson demo2 = new SimplePerson("Meyer2", 22);
        final SimplePerson demo3 = new SimplePerson("Meyer3", 33);
        final SimplePerson demo4 = new SimplePerson("Meyer4", 44);
        final SimplePerson demo5 = new SimplePerson("Müller", 34);
        
        final List<SimplePerson> demoDataValues = Arrays.asList(demo1, demo2, demo3, demo4, demo5);

        // Filter für "Alter 20 -- 40" 
        final Filterable<SimplePerson> ageRangeFilter = new SimplePersonAgeFilter(new Between<>(20, 40));

        // Filter für "Name enthält Meyer" 
        final Filterable<SimplePerson> nameFilter = new SimplePersonNameFilter(new StringContains("Meyer"));

        // Kombination der Filter 
        final Filterable<SimplePerson> ageAndNamefilter = new And<>(nameFilter, ageRangeFilter);
        final List<SimplePerson> filteredValues = FilterUtils.applyFilter(demoDataValues, ageAndNamefilter);
        System.out.println(filteredValues);
    }
    
    private FilterExample()
    {        
    }
}
