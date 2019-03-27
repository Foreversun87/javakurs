package ch20_unittests.basics;

import static ch20_unittests.basics.DiscountCalculatorV2.BIG_DISCOUNT;
import static ch20_unittests.basics.DiscountCalculatorV2.MEDIUM_DISCOUNT;
import static ch20_unittests.basics.DiscountCalculatorV2.NO_DISCOUNT;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit-Tests zu der Utility-Klasse DiscountCalculatorV2.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2107 by Michael Inden 
 */
public class DiscountCalculatorV2Test 
{
	private final DiscountCalculatorV2 calculator = new DiscountCalculatorV2();
	
	@Test
	public void testCalcDiscount_SmallOrder_NoDiscount() 
	{
		final int smallAmount = 20;
		assertEquals("no discount", NO_DISCOUNT, calculator.calcDiscount(smallAmount));
	}

	@Test
	public void testCalcDiscount_MediumOrder_MediumDiscount() 
	{
		final int mediumAmount = 200;
		assertEquals("4% discount", MEDIUM_DISCOUNT, calculator.calcDiscount(mediumAmount));
	}

	@Test
	public void testCalcDiscount_BigOrderBigDiscount() 
	{
		final int bigAmount = 2000;
		assertEquals("7% discount", BIG_DISCOUNT, calculator.calcDiscount(bigAmount));
	}
	
	// Randfälle prüfen
	
	@Test
	public void testCalcDiscount_Input_49_ShouldHaveNoDiscount() 
	{
		assertEquals("No discount", NO_DISCOUNT, calculator.calcDiscount(49));
	}
	
	@Test
	public void testCalcDiscount_Input_50_ShouldHaveMediumDiscount() 
	{
		assertEquals("Medium discount", MEDIUM_DISCOUNT, calculator.calcDiscount(50));
	}
	
	@Test
	public void testCalcDiscount_Input_51_Should_HaveMediumDiscount() 
	{
		assertEquals("Medium discount", MEDIUM_DISCOUNT, calculator.calcDiscount(51));
	}

	@Test
	public void testCalcDiscount_Input_999_ShouldHaveMediumDiscount() 
	{
		assertEquals("Medium discount", MEDIUM_DISCOUNT, calculator.calcDiscount(999));
	}

	@Test
	public void testCalcDiscount_Input_1000_ShouldHaveMediumDiscount() 
	{
		assertEquals("Medium discount", MEDIUM_DISCOUNT, calculator.calcDiscount(1000));
	}

	@Test
	public void testCalcDiscount_Input_1001_ShouldHaveBigDiscount() 
	{
		assertEquals("Big discount", BIG_DISCOUNT, calculator.calcDiscount(1001));
	}

	// Ungültige Werte prüfen
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalcDiscount_NegativeInput_ShouldThrowException() 
	{
		calculator.calcDiscount(-1);
	}
}
