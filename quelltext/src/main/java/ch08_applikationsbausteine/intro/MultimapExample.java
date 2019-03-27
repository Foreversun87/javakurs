package ch08_applikationsbausteine.intro;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Beispielklasse zur Demonstration der Funktionalität rund um das Interface Multimap
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class MultimapExample 
{
	public static void main(final String[] args) 
	{
		final Multimap<String, String> countryToBigCities = 
	                                                     ArrayListMultimap.create();
		countryToBigCities.put("Germany", "Berlin");  
		countryToBigCities.put("Germany", "Hamburg");
		countryToBigCities.put("Germany", "Munich");
		countryToBigCities.put("Germany", "Cologne");
		countryToBigCities.put("Switzerland", "Basel");
		countryToBigCities.put("Switzerland", "Berne");
		countryToBigCities.put("Switzerland", "Zurich");
		countryToBigCities.put("Switzerland", "Geneve");
		
		System.out.println("Switzerland: " + countryToBigCities.get("Switzerland"));
		System.out.println("Germany:     " + countryToBigCities.get("Germany"));
	}	
}