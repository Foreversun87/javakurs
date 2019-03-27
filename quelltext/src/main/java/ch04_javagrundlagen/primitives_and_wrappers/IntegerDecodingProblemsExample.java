package ch04_javagrundlagen.primitives_and_wrappers;

/**
 * Beispiel zeigt, dass zwar _ in Literalen erlaubt sind, jedoch nicht decodiert werden.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class IntegerDecodingProblemsExample 
{
	private IntegerDecodingProblemsExample()
	{		
	}
	
	public static void main(final String[] args) 
	{
		final String value1 = "4711";
		final String value2 = "0567";
		final String value3 = "0xABC";
		final String error1 = "1_000_000";
		final String error2 = "0b11110000";

		System.out.println("value1 " + Integer.decode(value1));
		System.out.println("value2 " + Integer.decode(value2));
		System.out.println("value3 " + Integer.decode(value3));
		System.out.println("error1 " + Integer.decode(error1));
		System.out.println("error2 " + Integer.decode(error2));
	}
		
//    final String hexValue = "ABC"; // "0x0001111";
//    final String octalValue = "0123";
//    final String binaryValue = "0b0001111";
//    final String undescoreValue = "1_000_000";
//    
//    System.out.println(Integer.parseInt(hexValue));
//    System.out.println(Integer.parseInt(octalValue));
//    System.out.println(Integer.parseInt(binaryValue));
//    System.out.println(Integer.parseInt(undescoreValue));
}