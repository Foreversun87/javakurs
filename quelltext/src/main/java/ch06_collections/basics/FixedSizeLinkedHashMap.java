package ch06_collections.basics;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Realisierung einer größenbeschränkten HashMap mithilfe der Callback-Methode removeEldestEntry(),
 * die das älteste Element basierend auf der Einfügereihenfolge bestimmt.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V>
{
    private final int maxEntryCount;

    public FixedSizeLinkedHashMap(final int maxEntryCount)
    {
        this.maxEntryCount = maxEntryCount;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> customer)
    {
        return size() > maxEntryCount;
    }
}
