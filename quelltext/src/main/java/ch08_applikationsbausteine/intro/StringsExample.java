package ch08_applikationsbausteine.intro;

import com.google.common.base.Strings;

/**
 * Beispielklasse zur Demonstration der Funktionalit�t aus Strings
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class StringsExample 
{
	public static void main(final String[] args)
	{	
		// Pr�fmethoden  
		System.out.println(Strings.isNullOrEmpty(""));  
		System.out.println(Strings.isNullOrEmpty("   "));  
	
		// Mapping  
		System.out.println("'" + Strings.emptyToNull("") + "'");   
		System.out.println("'" + Strings.nullToEmpty(null) + "'");   
		
		// Ausrichtung  
		final String rightAligned = Strings.padStart("Right", 15, '*');
		System.out.println(rightAligned);                 
	}
}