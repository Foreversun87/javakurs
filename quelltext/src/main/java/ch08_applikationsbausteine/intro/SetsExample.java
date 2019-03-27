package ch08_applikationsbausteine.intro;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/**
 * Beispielklasse zur Demonstration der Funktionalität der Klasse Sets
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class SetsExample 
{
	public static void main(final String[] args) 
	{		
		final Set<String> names = ImmutableSet.of("Andy", "Mike", "Tim", "Peter");
		final Set<String> readers = ImmutableSet.of("Sagi", "Mike", "Tim", "Jï¿½rg");
		
		final Set<String> intersection = Sets.intersection(names, readers);
		final Set<String> union = Sets.union(names, readers);
		final Set<String> difference1 = Sets.difference(names, readers);
		final Set<String> difference2 = Sets.difference(readers, names);
		final Set<String> symDifference1 = Sets.symmetricDifference(names, readers);
		final Set<String> symDifference2 = Sets.symmetricDifference(readers, names);
		final Set<String> symDifference3 = Sets.difference(union, intersection);
		
		System.out.println("intersection:   " + intersection);
		System.out.println("union:          " + union);
		System.out.println("difference1:    " + difference1);
		System.out.println("difference2:    " + difference2);
		System.out.println("symDifference1: " + symDifference1);
		System.out.println("symDifference2: " + symDifference2);
		System.out.println("symDifference3: " + symDifference3);
	}
}