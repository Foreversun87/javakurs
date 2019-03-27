package ch04_javagrundlagen.primitives_and_wrappers;

/**
 * Beispiel zur Demonstration der Berechnungsungenauigkeiten von Flieﬂkommazahlen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class FloatPrecisionExample
{
	public static void main(final String[] args)
	{
	    float sum = 0.0f;
	    for (int i = 0; i < 10; i++)
	        sum += 0.1;

	    System.out.println("sum:  1 != " + sum);     
	    
		System.out.println("3 * add  = " + (0.1 + 0.1 + 0.1));   
		System.out.println("3 * 0.1  = " + 3 * 0.1);           
		System.out.println("7 * 0.1  = " + 7 * 0.1);           

		System.out.println("compare  = " + (0.3f == 0.3d)); // false, Float != Double
	}

    private FloatPrecisionExample()
    {
    }
}
