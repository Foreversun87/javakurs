package ch05_lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration von Lambdas als
 * Paramter und als Rückgabewert 
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class LambdaAsParamAndReturnValueExample 
{
	public static void main(final String[] args) 
	{
		final List<String> names = Arrays.asList("Andy", "Michael", "Max", "Stefan");
		
		// Lambda als Methodenparameter
		Collections.sort(names, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
		// Alternative mit Lambda als Rückgabe einer Methode
		names.sort(compareByLength());
		System.out.println(names);
	}

	public static Comparator<String> compareByLength() 
	{
		return (str1, str2) -> Integer.compare(str1.length(), str2.length());
	}
}