package ch07_bulk_operations.advanced;

import java.util.Map;
import java.util.TreeMap;

/**
 * Ausgangsbasis zur Demonstration der Sortierung nach Wert
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class MapTraditionalSortExample 
{
	public static void main(final String[] args) 
	{
		final Map<String, Long> highscores = new TreeMap<>();
		highscores.put("Tim", 27371L);
		highscores.put("Andy", 20483L);
		highscores.put("Micha", 7271L);

		System.out.println(highscores); // {Andy=20483, Micha=7271, Tim=27371}
	}
}
