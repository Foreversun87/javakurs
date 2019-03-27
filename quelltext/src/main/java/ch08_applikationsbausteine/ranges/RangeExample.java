package ch08_applikationsbausteine.ranges;

import com.google.common.collect.Range;

/**
 * Beispielklasse zur Demonstration der Funktionalität von Wertebereichen mit der Klasse Range
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class RangeExample 
{
	public static void main(final String[] args) 
	{
		final Range<Integer> closed = Range.closed(0, 100);
		final Range<Integer> open = Range.open(0, 100);		
		final Range<Integer> openClosed = Range.openClosed(0, 100);
		final Range<Integer> closedOpen = Range.closedOpen(0, 100);
		
		System.out.println("Closed:     " + closed);
		System.out.println("Open:       " + open);
		System.out.println("openClosed: " + openClosed);
		System.out.println("closedOpen: " + closedOpen);
	}
}

