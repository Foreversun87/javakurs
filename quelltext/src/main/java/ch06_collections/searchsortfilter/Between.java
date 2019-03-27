package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Filterkriterium BEREICH
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class Between<T extends Object & Comparable<T>> implements Filterable<T>
{
    private final T lowerBound;
    private final T upperBound;
    
    public Between(final T lowerBound, final T upperBound)
    {
        this.lowerBound = Objects.requireNonNull(lowerBound, "lowerBound must not be null");
        this.upperBound = Objects.requireNonNull(upperBound, "upperBound must not be null");

        if (!(lowerBound.compareTo(upperBound) <= 0))
            throw new IllegalArgumentException("lowerBound " + lowerBound + 
                                  " must be <= upperBound " + upperBound);
    }
    
    @Override
    public boolean accept(final T value)
    {        
        return lowerBound.compareTo(value) <= 0 && 
               upperBound.compareTo(value) >= 0;
    }
}