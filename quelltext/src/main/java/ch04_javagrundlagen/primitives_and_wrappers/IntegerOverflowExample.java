package ch04_javagrundlagen.primitives_and_wrappers;

/**
 * Beispiel zur Demonstration der m�glicher Probleme bei �berfl�ufen des Wertebereichs
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public class IntegerOverflowExample 
{
	private IntegerOverflowExample()
	{		
	}
	
	public static void main(final String[] args) 
	{
		final int value = Integer.MAX_VALUE - 7;

		System.out.println("Integer.MAX_VALUE - 7 + 10 = " + (value + 10));
	}
}