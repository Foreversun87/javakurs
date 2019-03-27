package ch04_javagrundlagen.primitives_and_wrappers;

/**
 * Beispiel zur Demonstration der verschiedenen Varianten der Angabe von Zahlenliteralen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public class BinaryOctalHexadecimalExample
{
	private BinaryOctalHexadecimalExample()
	{		
	}
	
	public static void main(final String[] args)
	{
		final int octalLiteral = 0567;                   
		final int hexLiteral = 0xABC;  
		final int binaryLiteral = 0b01101001;                  

		System.out.println("octalLiteral " + octalLiteral); 
		System.out.println("hexLiteral " + hexLiteral);
		System.out.println("binaryLiteral " + binaryLiteral); 
	}
}