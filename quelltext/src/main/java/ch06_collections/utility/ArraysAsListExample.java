package ch06_collections.utility;

import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration der Methode Arrays.asList()
 *
 * @author Michael Inden
 *
 * Copyright 2014 by Michael Inden
 */
public class ArraysAsListExample
{
	public static void main(final String[] args)
	{
		final String[] valuesArray = { "Value 1", "Value 2", "Value 3" };

		// �nderungen an der Liste (Inhalt, Zusammensetzung)
		final List<String> valuesAsList = Arrays.asList(valuesArray);
		valuesAsList.set(1, "Value 7"); // Inhalt �ndern
		// valuesAsList.add("Value 4"); // Unsupported"-Operation"-Exception

		System.out.println("valuesArray:  " + Arrays.toString(valuesArray));
		System.out.println("valuesAsList: " + valuesAsList);

		// �nderungen am Inhalt des Arrays
		valuesArray[0] = "Michael changed";
		valuesArray[1] = "Value 1 & 2";

		System.out.println("valuesArray:  " + Arrays.toString(valuesArray));
		System.out.println("valuesAsList: " + valuesAsList);
	}
}
