package ch06_collections.basics;

import java.io.IOException;
import java.util.HashMap;

/**
 * Beispielklasse: 
 * Diese Map bietet Zugriff ohne Beachtung der Klein- oder Großschreibung von 
 * Schlüsseln. Zusätzlich werden noch Blanks vorne und hinten abgeschnitten, 
 * da diese bei Eingaben aus dem GUI eine ständige Fehlerquelle sind. 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class UpperCaseNormalizedHashMap<V> extends HashMap<String, V>
{
    @Override
    public V put(final String key, final V value)
    {
        return super.put(normalizeKey(key), value);
    }

    @Override
    public V get(final Object key)
    {
        ensureCorrectTypeOfKey(key);        
        return super.get(normalizeKey((String) key));
    }

    @Override
    public boolean containsKey(final Object key)
    {
        ensureCorrectTypeOfKey(key);
        return super.containsKey(normalizeKey((String) key));
    }

    private void ensureCorrectTypeOfKey(final Object key)
    {
        if (!(key instanceof String))
            throw new IllegalArgumentException("key must be of type string");
    }
    
    // ...

    private String normalizeKey(final String key)
    {
        if (key == null)
            return null;

        return key.toUpperCase().trim();
    }
    
    
    public static void main(final String[] args) throws IOException
    {
        // Typsichere Definition mit Diamond Operator
        final UpperCaseNormalizedHashMap<String> keyToNameMap = new UpperCaseNormalizedHashMap<>();

        // Speicherung einiger Mappings Name -> Bild 
        keyToNameMap.put(" a", "Andi");
        keyToNameMap.put("BbB ", "Barbara");
        keyToNameMap.put(" cCc ", "Clemens");

        // Zugriffe
        System.out.println("'A' " + keyToNameMap.get("a"));
        System.out.println("'BBB' " + keyToNameMap.get("BBB"));
        System.out.println("'CCC?' " + keyToNameMap.containsKey("CCC"));

        // Ausgabe aller Schlüssel und Werte 
        System.out.println("Keys = " + keyToNameMap.keySet());
        System.out.println("Values = " + keyToNameMap.values());
    }
}