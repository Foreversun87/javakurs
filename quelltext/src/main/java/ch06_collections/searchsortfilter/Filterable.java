package ch06_collections.searchsortfilter;

/**
 * Basisinterface aller Klassen zur Definition von Filterkriterien
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public interface Filterable<T>
{
    boolean accept(final T value);
}