package ch20_unittests.basics;

import com.google.common.base.Preconditions;

/**
 * Beispiel einer Rabattberechnung: Verbesserte dritte Variante
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class DiscountCalculatorV3 {

	static final int NO_DISCOUNT = 0;
	static final int MEDIUM_DISCOUNT = 4;
	static final int BIG_DISCOUNT = 7;

	public int calcDiscount(final int count)
	{
		Preconditions.checkArgument(count >= 0, "count should not be negative");
		
		if (count < 50)
			return NO_DISCOUNT;
		if (count >= 50 && count <= 1000)
			return MEDIUM_DISCOUNT;
		if (count > 1000)
			return BIG_DISCOUNT;

		throw new IllegalStateException("programming problem: should never " +
                         "reach this line. value " + count + " not handled!");
	}
}
