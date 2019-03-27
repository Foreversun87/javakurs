package ch06_collections.basics;
import java.util.Map;
import java.util.TreeMap;

/**
 * Beispielprogramm zur Demonstration der grundsätzlichen Funktionalität von Schlüssel-Wert-Abbildungen und dem Interface Map
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

		// Verschiedene Aktionen ausführen
		System.out.println(nameToNumber.containsKey("Tim")); // Prüfe Schlüssel
		System.out.println(nameToNumber.get("Jens"));  // Zugriff per Schlüssel
		System.out.println(nameToNumber.size());       // Anzahl der Einträge
		System.out.println(nameToNumber.keySet());     // Alle Schlüssel
		System.out.println(nameToNumber.values());     // Alle Werte
	}
}
