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
public class SortByValueExample 
{
	public static void main(final String[] args) 
	{
		final Map<String, Long> highscores = new TreeMap<>();
		highscores.put("Tim", 27371L);
		highscores.put("Andy", 20483L);
		highscores.put("Micha", 7271L);

		final Comparator<String> byValue = new DescendingValueComparator(highscores);
		final Map<String, Long> sortedHighscores = new TreeMap<>(byValue);
		sortedHighscores.putAll(highscores);

		System.out.println(sortedHighscores); 
	}

	// Achtung: Dieser Komparator ist nicht konsistent mit equals()
	// In diesem speziellen Fall ist das aber genau so gewünscht.
	public static class DescendingValueComparator implements Comparator<String> 
	{
		final Map<String, Long> map;

		public DescendingValueComparator(final Map<String, Long> map)
		{
			this.map = map;
		}

		public int compare(final String first, final String second) 
		{
			final int result = Long.compare(map.get(second), map.get(first));
			if (result == 0) // Der Wert 0 würde ungewünschte Ergebnisse liefern
			{
				return -1;
			}
			return result;
		}
	}
}
