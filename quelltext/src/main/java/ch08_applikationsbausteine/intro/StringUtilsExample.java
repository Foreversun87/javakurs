package ch08_applikationsbausteine.intro;

import org.apache.commons.lang3.StringUtils;

/**
 * Beispielklasse zur Demonstration der Funktionalität der Klasse StringUtils
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class StringUtilsExample 
{
	public static void main(final String[] args)
	{	
		// Spezielle Prüfungen 
		System.out.println("isEmpty:          " + StringUtils.isEmpty("   "));   
		System.out.println("isBlank:          " + StringUtils.isBlank("   "));  
		System.out.println("isBlank/null:     " + StringUtils.isBlank(null));  
	
		// Ausrichtung 	
		final String rightAligned = StringUtils.leftPad("Right", 15, "*");
		System.out.println("leftPad:          " + rightAligned);                
	
		// Abkürzungen 	
		final int maxWidth = 15;
		final String longText = "This is a long text that has to be shortened!";
		final String shortened = StringUtils.abbreviate(longText, maxWidth);
		final String shortened2 = StringUtils.abbreviateMiddle(longText, 
		                                                       "...", maxWidth);
		System.out.println("abbreviate:       " + shortened);                  
		System.out.println("abbreviateMiddle: " + shortened2);                  
	}
}