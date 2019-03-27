package ch08_applikationsbausteine.intro;

import com.google.common.base.Splitter;

/**
 * Beispielklasse zur Demonstration der Funktionalität der Klasse Splitter
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class SplitterExample 
{
	public static void main(final String[] args) 
	{
		final String input = "  Mike,,Florian ,    Tim ,, Erkan ";
	
		final Iterable<String> splittedNames = Splitter.on(',').split(input); 
		for (final String name : splittedNames) 
		{
			System.out.println(name);
		}		
	}
}