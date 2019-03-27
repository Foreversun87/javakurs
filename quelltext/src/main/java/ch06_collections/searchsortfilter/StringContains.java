package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Filterkriterium ENTHÄLT basierend auf String.contains()
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class StringContains implements Filterable<String>
{
    private final String necessarySubstring;
    
    public StringContains(final String necessarySubstring)
    {
    	this.necessarySubstring = Objects.requireNonNull(necessarySubstring, "necessarySubstring must not be null");
    }
    
    @Override
    public boolean accept(final String value)
    {      
    	if (value == null)
    		return false;

        return value.contains(necessarySubstring);
    }
}