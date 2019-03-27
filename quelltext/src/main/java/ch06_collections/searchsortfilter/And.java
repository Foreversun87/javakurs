package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Filterkriterium UND
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class And<T> implements Filterable<T>
{
    private final Filterable<T> filter1;
    private final Filterable<T> filter2;
    
    public And(final Filterable<T> filter1, final Filterable<T> filter2)
    {
        this.filter1 = Objects.requireNonNull(filter1, "filter1 must not be null");
        this.filter2 = Objects.requireNonNull(filter2, "filter2 must not be null");
    }

    @Override
    public boolean accept(final T value)
    {
        return (filter1.accept(value) && filter2.accept(value));
    }
}