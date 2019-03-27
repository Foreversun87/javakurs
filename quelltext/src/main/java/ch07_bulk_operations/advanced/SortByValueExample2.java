package ch07_bulk_operations.advanced;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Beispielprogramm zur Demonstration der Sortierung nach Wert
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden
 */
public class SortByValueExample2
{
	public static void main(final String[] args)
	{
	    final Map<String, Long> highscores = new TreeMap<>();
	    highscores.put("Tim", 27371L);
	    highscores.put("Andy", 20483L);
	    highscores.put("Micha", 7271L);
	    
	    final Map<String, Long> sortedHighscores = sortMapByValue(highscores);	    
	    System.out.println(sortedHighscores); 
	}
	
	public static <K,V extends Comparable<V>> Map<K, V> sortMapByValue(final Map<K, V> map)
	{
	    class DescendingValueComparator implements Comparator<K>
	    {
	        public int compare(final K first, final K second)
	        {
	            final int result = map.get(second).compareTo(map.get(first));
	            if (result == 0) // Der Wert 0 würde ungewünschte Ergebnisse liefern  
	            {
	                return -1;
	            }
	            return result;     
	        }
	    }
	    
	    final TreeMap<K, V> sortedMap = new TreeMap<>(new DescendingValueComparator());
	    sortedMap.putAll(map);
	    return sortedMap;
	}  
}
