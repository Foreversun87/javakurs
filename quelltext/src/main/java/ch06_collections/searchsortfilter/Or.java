package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Filterkriterium ODER
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class Or<T> implements Filterable<T>
{
    private final Filterable<T> filter1;
    private final Filterable<T> filter2;
    
    public Or(final Filterable<T> filter1, final Filterable<T> filter2)
    {
    	this.filter1 = Objects.requireNonNull(filter1, "filter1 must not be null");
        this.filter2 = Objects.requireNonNull(filter2, "filter2 must not be null");
    }

    @Override
    public boolean accept(final T object)
    {
        return (filter1.accept(object) || filter2.accept(object));
    }
}