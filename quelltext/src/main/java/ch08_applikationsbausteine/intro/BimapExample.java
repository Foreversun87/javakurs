package ch08_applikationsbausteine.intro;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Beispielklasse zur Demonstration der Funktionalität einer bidirektionalen Abbildung mit BiMap
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class BimapExample 
{
	public static void main(final String[] args) 
	{
		final BiMap<String, String> countryToCity = HashBiMap.create();
		countryToCity.put("Germany", "Berlin");  
		countryToCity.put("Switzerland", "Berne");
	
		System.out.println("Switzerland: " + countryToCity.get("Switzerland"));
		System.out.println("Berlin:      " + countryToCity.inverse().get("Berlin"));
	}
}