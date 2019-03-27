package ch08_applikationsbausteine.ranges;

import java.util.Arrays;

import com.google.common.collect.Range;

/**
 * Beispielklasse zur Demonstration weitergehender Funktionalität von Wertebereichen mit der Klasse Range
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class RangeImprovedExample 
{
	public static void main(final String[] args) 
	{
		final Range<Integer> lessThan100 = Range.atMost(99);
		final Range<Integer> moreThan10 = Range.atLeast(11);		
		
		// Prüfe Enthaltensein 
		System.out.println("-50 in [...99]: " + lessThan100.contains(-50));
		System.out.println("500 in [...99]: " + lessThan100.contains(500));
		System.out.println("10  in [11...]: " + moreThan10.contains(10));
		System.out.println("100 in [11...]: " + moreThan10.contains(100));
		
		// Vereinigung  
		final Range<Integer> intersection = moreThan10.intersection(lessThan100);
		System.out.println("Intersection:   " + intersection);
		
		// Obermenge 
		final Range<Integer> range_10_25 = Range.closed(10,  25);
		final Range<Integer> range_40_60 = Range.closed(40,  60);
		final Range<Integer> span = range_10_25.span(range_40_60);
		System.out.println("span:           " + span);
		
		// Prüfe, ob der Wertebreich umschlossen wird oder erzeuge eine solchen  
		final Range<Integer> lessThan1000 = Range.atMost(999);	
		System.out.println(lessThan1000.encloses(lessThan100));
		System.out.println(Range.encloseAll(Arrays.asList(5, 100, 500)));
	}	
}