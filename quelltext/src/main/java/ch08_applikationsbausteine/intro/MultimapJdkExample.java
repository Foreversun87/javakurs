package ch08_applikationsbausteine.intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Beispielklasse zur Demonstration der Funktionalität einer primitiven selbstrealisisteren Multimap
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class MultimapJdkExample
{
    public static void main(final String[] args)
    {        
        final Map<String, List<String>> countryToBigCities = new HashMap<>();
        putSpecial(countryToBigCities, "Germany", "Berlin");
        putSpecial(countryToBigCities, "Germany", "Hamburg");
        putSpecial(countryToBigCities, "Germany", "Munich");
        putSpecial(countryToBigCities, "Germany", "Cologne");
        putSpecial(countryToBigCities, "Switzerland", "Berne");
        putSpecial(countryToBigCities, "Switzerland", "Zurich");
        putSpecial(countryToBigCities, "Switzerland", "Geneve");

        System.out.println("Switzerland: " + countryToBigCities.get("Switzerland"));
        System.out.println("Germany:     " + countryToBigCities.get("Germany"));
    }

	private static void putSpecial(final Map<String, List<String>> map, 
	                               final String key, final String value)
	{
	    /* 
	    if (!map.containsKey(key))
	    {
	        map.put(key, new ArrayList<>());
	    }
	    */
	    map.putIfAbsent(key, new ArrayList<>());
	
	    final List<String> cities = map.get(key);
	    cities.add(value);
	}
}