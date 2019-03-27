package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Filterkriterium NICHT
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class Not<T> implements Filterable<T>
{
    private final Filterable<T> filter;

    public Not(final Filterable<T> filter)
    {
    	this.filter = Objects.requireNonNull(filter, "filter must not be null");        
    }

    @Override
    public boolean accept(final T value)
    {
        return !(filter.accept(value));
    }
}