package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Filterkriterium KLEINER GLEICH basierend auf Comparable
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class LowerOrEqual<T extends Object & Comparable<T>> implements Filterable<T>
{
    private final T acceptedValue;
    
    public LowerOrEqual(final T acceptedValue)
    {
    	this.acceptedValue = Objects.requireNonNull(acceptedValue, "acceptedValue must not be null");;
    }
    
    @Override
    public boolean accept(final T value)
    {        
        return acceptedValue.compareTo(value) >= 0;
    }
}