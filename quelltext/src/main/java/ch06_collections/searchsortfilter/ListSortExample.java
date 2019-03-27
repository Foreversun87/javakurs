package ch06_collections.searchsortfilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration des Sortierens von Listen
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ListSortExample 
{
	public static void main(final String[] args) 
	{	
	   final List<String> names = Arrays.asList("Andy", "Michael", "Tim", "Stefan");
	
	   // $\mbox{\bfseries Comparable basierte Sortierung }$
	   Collections.sort(names);		
	   System.out.println(names);
		
	   final Comparator<String> byLength = new Comparator<String>()
	   {
	      @Override
	      public int compare(final String str1, final String str2) 
	      {
	         return Integer.compare(str1.length(), str2.length());
	      }
	   };
		
	   // $\mbox{\bfseries Comparator bestimmte Sortierung }$ 
	   Collections.sort(names, byLength);		
	   System.out.println(names);
	}
}

