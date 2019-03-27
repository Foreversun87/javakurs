package ch08_applikationsbausteine.ranges;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * Beispielklasse zur Demonstration der Funktionalitï¿½t von Mengen von Wertebereichen mit RangeSet
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class RangeSetExample 
{
	public static void main(final String[] args) 
	{
		final RangeSet<Integer> rangeSet = TreeRangeSet.create();
		
		// Bereich 0--9 aus den Teilen 0--5 und 6--9 erstellen  
		rangeSet.add(Range.closed(0, 5));    		
		System.out.println(rangeSet);
		
		// Zweiter Bereich aus zwei Subbereichen erstellen  
		rangeSet.add(Range.closedOpen(6, 8));  // eigenständiger Teil  
		rangeSet.add(Range.closedOpen(8, 10)); // wird verbunden zu [6, 10)  	
		System.out.println(rangeSet);
	
		// Wertebereich (40--70]  
		rangeSet.add(Range.openClosed(40, 70));  		
		System.out.println(rangeSet);
	
		// Teilbereich (40--50) entfernen  
		rangeSet.remove(Range.open(40, 50)); 
		System.out.println(rangeSet);
	
		//  Prüfungen auf Enthaltensein  
		System.out.println(rangeSet.contains(7));
		System.out.println(rangeSet.contains(55));
		System.out.println(rangeSet.contains(777));
	}	
}
