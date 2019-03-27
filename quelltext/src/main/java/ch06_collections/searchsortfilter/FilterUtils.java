package ch06_collections.searchsortfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Utility-Klasse zur Anwendung eines Filters auf eine Liste von Werten 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class FilterUtils
{
    public static <T> List<T> applyFilter(final List<T> values, 
                                          final Filterable<T> filter)
    {
    	Objects.requireNonNull(values, "values must not be null");
    	Objects.requireNonNull(filter, "filter must not be null");
    	
        final List<T> filteredValues = new ArrayList<>();
        for (final T current : values)
        {
            if (filter.accept(current))
                filteredValues.add(current);
        }
                
        return filteredValues;
    }
}
