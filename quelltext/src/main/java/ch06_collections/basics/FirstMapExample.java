package ch06_collections.basics;
import java.util.Map;
import java.util.TreeMap;

/**
 * Beispielprogramm zur Demonstration der grunds�tzlichen Funktionalit�t von Schl�ssel-Wert-Abbildungen und dem Interface Map
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstMapExample 
{
	public static void main(final String[] args) 
	{
		final Map<String, Integer> nameToNumber = new TreeMap<>();
		nameToNumber.put("Micha", 4711);
		nameToNumber.put("Tim", 0714);
		nameToNumber.put("Jens", 1234);
		nameToNumber.put("Tim", 1508);
		nameToNumber.put("Ralph", 2208);

		System.out.println(nameToNumber);

		// Verschiedene Aktionen ausf�hren
		System.out.println(nameToNumber.containsKey("Tim")); // Pr�fe Schl�ssel
		System.out.println(nameToNumber.get("Jens"));  // Zugriff per Schl�ssel
		System.out.println(nameToNumber.size());       // Anzahl der Eintr�ge
		System.out.println(nameToNumber.keySet());     // Alle Schl�ssel
		System.out.println(nameToNumber.values());     // Alle Werte
	}
}
