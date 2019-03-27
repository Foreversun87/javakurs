package ch06_collections.basics;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Beispielprogramm zur Demonstration der Sortierung eines TreeSets.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class TreeSetStorageExample2 
{
	public static void main(final String[] args) 
	{
		final Integer[] ints = new Integer[] { 3, 2, 1, 33, 11, 22 };
		final SortedSet<Integer> numberSet = new TreeSet<>(Arrays.asList(ints));
		System.out.println("Initial: " + numberSet);              	 // 1, 2, 3, 11, 22, 33  

		System.out.println("first: " + numberSet.first());			 // 1 
		System.out.println("last: " + numberSet.last());			     // 33  
		
		final SortedSet<Integer> headSet  = numberSet.headSet(7);	 
		System.out.println("headSet:   " + headSet);	                 // 1, 2, 3 
		System.out.println("tailSet:   " + numberSet.tailSet(7));	 // 11, 22, 33  
		System.out.println("subSet:    " + numberSet.subSet(7, 23));  // 11, 22  

		// Modifikationen an einem einzelnen Set 
		headSet.remove(3);
		headSet.add(6);

		System.out.println("headSet:   " + headSet);		              // 1, 2, 6 
		System.out.println("numberSet: " + numberSet);                // 1, 2, 6, 11, 22, 33  
	}

	private TreeSetStorageExample2() 
	{
	}
}
