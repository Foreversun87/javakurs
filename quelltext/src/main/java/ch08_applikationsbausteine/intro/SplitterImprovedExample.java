package ch08_applikationsbausteine.intro;

import java.util.List;

import com.google.common.base.Splitter;

/**
 * Beispielklasse zur Demonstration der Funktionalität der Klasse Splitter mit Parametrierung
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class SplitterImprovedExample 
{
	public static void main(final String[] args) 
	{
		final String input = "  Mike,,Florian ,    Tim ,, Erkan ";
	
		final List<String> splittedNames = Splitter.on(',').trimResults().
		                                                    omitEmptyStrings().limit(3).
		                                                    splitToList(input); 
	
		for (final String name : splittedNames) 
		{
			System.out.println(name);
		}		
	}
}