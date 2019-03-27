package ch20_unittests.basics;

import static org.junit.Assert.*;

import org.junit.Test;

import ch20_unittests.basics.DiscountCalculatorV1;

/**
 * Unit-Tests zu der Utility-Klasse DiscountCalculatorV1.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class DiscountCalculatorV1Test 
{
	private final DiscountCalculatorV1 calculator = new DiscountCalculatorV1();
	
	@Test
	public void testCalcDiscount_SmallOrder_NoDiscount() 
	{
		final int smallAmount = 20;
		assertEquals("no discount", 0, calculator.calcDiscount(smallAmount));
	}

	@Test
	public void testCalcDiscount_MediumOrder_MediumDiscount() 
	{
		final int mediumAmount = 200;
		assertEquals("4% discount", 4, calculator.calcDiscount(mediumAmount));
	}

	@Test
	public void testCalcDiscount_BigOrder_BigDiscount() 
	{
		final int bigAmount = 2000;
		assertEquals("7% discount", 7, calculator.calcDiscount(bigAmount));
	}
}
