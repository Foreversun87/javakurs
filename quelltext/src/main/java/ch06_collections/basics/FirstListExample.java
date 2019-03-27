package ch06_collections.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration der grunds�tzlichen Funktionalit�t einer Liste
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstListExample 
{
	public static void main(final String[] args) 
	{
		final List<String> list = new ArrayList<>();
		list.add("First");
		list.add("Last");
		list.add(1, "Middle");
		System.out.println("List: " + list);

		// Indizierter Zugriff
		System.out.println("3nd:  " + list.get(2));
		
		// Vorderstes Element l�schen, "Last" mit indexOf() suchen und l�schen
		list.remove(0);
		list.remove(list.indexOf("Last"));
		System.out.println("List: " + list);
	}
}
