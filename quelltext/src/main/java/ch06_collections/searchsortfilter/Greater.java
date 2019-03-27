package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Filterkriterium GR�SSER basierend auf Comparable
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class Greater<T extends Object & Comparable<T>> implements Filterable<T>
{
    private final T lowerBound;
    
    public Greater(final T lowerBound)
    {
    	this.lowerBound = Objects.requireNonNull(lowerBound, "lowerBound must not be null");
    }
    
    @Override
    public boolean accept(final T value)
    {        
        return lowerBound.compareTo(value) < 0;
    }
}