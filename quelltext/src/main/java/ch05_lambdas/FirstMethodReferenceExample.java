package ch05_lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm, das die bessere Lesbarkeit durch Methodenreferenzen statt Lambdas zeigt.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstMethodReferenceExample 
{
	public static void main(final String[] args)
	{
		final List<String> names = Arrays.asList("Max", "Andy", "Michael", "Stefan");
	
		// Lambda
		names.forEach(it -> System.out.println(it));
		
		// Methodenreferenz
		names.forEach(System.out::println);
	}
}