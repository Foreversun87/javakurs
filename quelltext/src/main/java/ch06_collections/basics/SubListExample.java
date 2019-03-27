package ch06_collections.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration von Sublisten
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class SubListExample
{
    public static void main(final String[] args) 
    {
    	final List<String> original = new ArrayList<>(Arrays.asList(
    	                                   "ABC", "DEF", "GHI", 
    	                                   "JKL", "MNO", "PQR"));
    
    	final List<String> first3 = original.subList(0, 3);
    	
    	first3.remove(1);
        printLists(original, first3);
          
        original.add("XXX");
        printLists(original, first3);
    }
    
    private static void printLists(final List<String> original, final List<String> first3)
    {
        System.out.println("Original: " + original);
        System.out.println("SUblist:  " + first3);   
    }
}