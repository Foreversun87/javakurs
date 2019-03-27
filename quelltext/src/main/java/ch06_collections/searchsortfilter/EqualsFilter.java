package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Filterkriterium GLEICH basierend auf equals()
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class EqualsFilter<T> implements Filterable<T>
{
    private final T acceptedValue;
    
    public EqualsFilter(final T acceptedValue)
    {
    	this.acceptedValue = Objects.requireNonNull(acceptedValue, "acceptedValue must not be null");
    }
    
    @Override
    public boolean accept(final T value)
    {        
        return acceptedValue.equals(value);
    }
}