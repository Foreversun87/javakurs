package ch06_collections.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration von Sublisten
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class SubListTruncationExample
{
	public static void main(final String[] args) 
	{
		// Merkwïürdige Aufrufkombination
		final List<String> errors = new ArrayList<>(Arrays.asList(
		                                   "Error1", "Error2", "Error3", 
		                                   "Critical Error", "Fatal Error"));

		truncateListToMaxSize(errors, 3);

		System.out.println(errors);  // [Error1, Error2, Error3]  
	}

	// ACHTUNG: Hier Seiteneffekt: übergebene Liste wird gegebenenfalls verkleinert  
	private static void truncateListToMaxSize(final List<?> listToTruncate, 
	                                          final int maxSize)
	{
		if (listToTruncate.size() > maxSize)
		{
			final List<?> entriesAfterMaxSize = listToTruncate.subList(maxSize,
	                                                        listToTruncate.size());

			// ACHTUNG: clear() wirkt sich auch in der Originalliste aus  
			entriesAfterMaxSize.clear();
		}
	}
}