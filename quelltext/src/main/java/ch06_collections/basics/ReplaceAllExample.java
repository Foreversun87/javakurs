package ch06_collections.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Beispielprogramm zur Demonstration der neuen Methode List.replaceAll() 
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class ReplaceAllExample 
{
	public static void main(final String[] args) 
	{
		final List<String> names = createDemoNames();
		
		// Spezialbehandlung von null-Werten
		final UnaryOperator<String> mapNullToEmpty = str -> str == null ? "" : str;
		names.replaceAll(mapNullToEmpty);
		
		// Leerzeichen abschneiden
		names.replaceAll(String::trim);
		
		// Leereinträge herausFiltern
		names.removeIf(String::isEmpty);
		
		System.out.println(names);
	}
	
	private static List<String> createDemoNames() 
	{
	   final List<String> names = new ArrayList<>();
	   names.add("Max");
	   names.add("");             // Leereintrag 
	   names.add("Andy");
	   names.add("   ");          // potenziell auch ein "Leereintrag" 
	   names.add("Stefan");
	   return names;
	}
}