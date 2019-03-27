package ch04_javagrundlagen.primitives_and_wrappers;

/**
 * Beispielprogramm zur Demonstration von Vergleichen von primitiven Werten und Wrappern
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public class PrimitivesAndWrapperCompareExample 
{
	private PrimitivesAndWrapperCompareExample()
	{
		// avoid instantiation
	}
	
	public static void main(final String[] args) 
	{
		// Auto-Unboxing des Integes: 7 == new Integer(7)  
		System.out.println(7 == new Integer(7));                         // true
		System.out.println(7777 == new Integer(7777));                   // true
		
		// Auto-Unboxing (ebenfalls)  	
		System.out.println(new Integer(7) == 7);                         // true
		System.out.println(new Integer(7777) == 7777);                   // true!?
		System.out.println(new Integer(7777) == new Integer(7777));      // false
		System.out.println(new Integer(7777).equals(7777));              // true
		System.out.println(new Integer(7777).equals(new Integer(7777))); // true
	}
}
