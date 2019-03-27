package ch06_collections.basics;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Beispielprogramm zur Demonstration der Sortierung eines TreeSets.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class TreeSetStorageExample 
{
	public static void main(final String[] args) 
	{
		final Integer[] ints = new Integer[] { 3, 2, 1 };
		final Set<Integer> numberSet = new TreeSet<>(Arrays.asList(ints));
		System.out.println("Initial: " + numberSet); // 1, 2, 3  

		final Integer[] moreInts = new Integer[] {  33, 11, 22 };
		numberSet.addAll(Arrays.asList(moreInts));
		System.out.println("Add: " + numberSet); // 1, 2, 3, 11, 22, 33  
	}

	private TreeSetStorageExample() 
	{
	}
}
