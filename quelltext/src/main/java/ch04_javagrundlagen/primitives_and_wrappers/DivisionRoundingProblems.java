package ch04_javagrundlagen.primitives_and_wrappers;

/**
 * Beispiel zur Demonstration der Fallstricke beim Runden bei Divisionen
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class DivisionRoundingProblems 
{
	private DivisionRoundingProblems()
	{		
	}
	
	public static void main(final String[] args) 
	{
		System.out.println(7 / 2);      // 3
		System.out.println(7 / 2.0);    // 3.5
		System.out.println(7.0 / 2);    // 3.5
		System.out.println(7.0 / 2.0);  // 3.5�_�
	}
}
