package ch20_unittests.basics;

/**
 * Beispiel einer Rabattberechnung: Erste fehlerhafte Variante
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class DiscountCalculatorV1 
{
	public int calcDiscount(final int count)
	{
		if (count <= 50)
			return 0;
		if (count > 50 && count < 1000)
			return 4;
		if (count > 1000)
			return 7;

		throw new IllegalStateException("programming problem: should never " +
	                  "reach this line. value " + count + " is not handled!");
	}
}
 