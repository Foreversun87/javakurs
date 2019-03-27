package ch08_applikationsbausteine.intro;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

/**
 * Beispielklasse zur Demonstration der Funktionalität des Joiners
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class JoinerExample 
{
	public static void main(final String[] args) 
	{
	   // Verschiedene Demodaten  
	   final List<String> words = Arrays.asList("Text", "is", "concatenated");
	   final List<String> withNulls = Arrays.asList("Skip", "null", null, "values");
	   final List<String> names = Arrays.asList("Tim B. ", " Mike I.", " Andy S. ");
	   
	   // Einfache Verknï¿½pfung mit Trennzeichenfolge  
	   System.out.println(Joiner.on("-+-").join(words));
	   
	   // Verknï¿½pfung mit null-Werten  
	   System.out.println(Joiner.on(" ").skipNulls().join(withNulls));
	   
	   // Spezielle Markierung von Werten mit Hochkommata  
	   final String markedValues = "'" + Joiner.on("','").join(names) + "'";
	   System.out.println(markedValues);
	}
}