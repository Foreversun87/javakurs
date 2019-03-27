package ch06_collections.basics;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * Beispielprogramm zur Demonstration der Verwaltung von Daten in HashMaps
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class HashMapLookUpExample {

	private static final Map<String, Color> nameToColor = new HashMap<>();

	public static void main(final String[] args) 
	{	
		initMapping(nameToColor);

		System.out.println(mapToColor("RED"));     // java.awt.Color[r=255,g=0,b=0]
		System.out.println(mapToColor("GREEN"));   // java.awt.Color[r=0,g=255,b=0]
		System.out.println(mapToColor("UNKNOWN")); // => Exception
	}

	private static Color mapToColor(final String colorName) 
	{
		if (nameToColor.containsKey(colorName))
		{
			return nameToColor.get(colorName);
		}
		throw new IllegalArgumentException("No color for: '" + colorName + "'");
	}

	private static void initMapping(final Map<String, Color> nameToColor) 
	{
		nameToColor.put("BLACK", Color.BLACK);
		nameToColor.put("GRAY", Color.GRAY);
		nameToColor.put("RED", Color.RED);
		nameToColor.put("GREEN", Color.GREEN);
		// ... viele mehr ...	
	}
}
