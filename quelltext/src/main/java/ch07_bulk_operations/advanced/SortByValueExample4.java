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
public class SortByValueExample4
{
    public static void main(final String[] args)
    {
        final Map<String, Long> highscores = new HashMap<>();
        highscores.put("Tim", 1111L);
        highscores.put("Andy", 2222L);
        highscores.put("Sven", 2222L);
        highscores.put("Otto", 2222L);
        highscores.put("Tom",  3333L);
        highscores.put("Bodo", 3333L);
        highscores.put("Mike", 3333L);
        
        final Map<String, Long> sortedHighscores = sortMapByValue(highscores);
        System.out.println(sortedHighscores); 
    }

	public static <K extends Comparable<K>, V extends Comparable<V>> 
	              Map<K, V> sortMapByValue(final Map<K, V> inputMap)
	{
	    class DescendingValueComparator implements Comparator<Entry<K, V>>
	    {
	        public int compare(final Entry<K, V> first, final Entry<K, V> second)
	        {
	            // Achtung: Größte Werte zuerst, daher hier andere Parameterreihenfolge
	            final int result = second.getValue().compareTo(first.getValue());
	            if (result == 0)
	            {
	                return first.getKey().compareTo(second.getKey());
	            }
	            return result;
	        }
	    }
	    
	    return inputMap.entrySet().stream()
	                    .sorted(new DescendingValueComparator())
	                    .collect(LinkedHashMap::new, 
	                             (map,entry) -> map.put(entry.getKey(), 
	                                                    entry.getValue()), 
	                             Map::putAll);
	}
}
