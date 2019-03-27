package ch07_bulk_operations.advanced;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Beispielprogramm zur Demonstration der Sortierung nach Wert
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden
 */
public class SortByValueExample3
{
    public static void main(final String[] args)
    {
        final Map<String, Long> highscores = new HashMap<>();
	    highscores.put("Tim", 27371L);
	    highscores.put("Andy", 20483L);
	    highscores.put("Micha", 7271L);
        
        final Map<String, Long> sortedHighscores = sortMapByValue(highscores);
        System.out.println(sortedHighscores);  
    }

	public static <K,V extends Comparable<V>> 
	              Map<K, V> sortMapByValue(final Map<K, V> inputMap)
	{        
	    final Comparator<Entry<K, V>> byValue = Map.Entry.comparingByValue();
	    //final Comparator<Entry<K, V>> byValue = Comparator.comparing(Entry::getValue);
		return inputMap.entrySet().stream()
	                              .sorted(byValue.reversed())
	                              .collect(LinkedHashMap::new, 
	                                       (map,entry) -> map.put(entry.getKey(), 
	                                                              entry.getValue()), 
	                                       Map::putAll);
	}
}
