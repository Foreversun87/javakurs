package ch20_unittests.basics;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch20_unittests.basics.MyClass;

/**
 * Unit-Tests zu der Utility-Klasse MyClass.
 * Demonstration des Einsatzes einer Testfixture
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class MyClassTestWithTestFixture
{
	// Testfixture
	private int offset;
	private MyClass objectToTest; 

	@Before
	public void initTestFixture() 
	{
		offset = 4711;
		objectToTest = new MyClass(offset);
	}

	@Test
	public void testGetValue() 
	{
		final int result = objectToTest.getValue();		

		final int expected = offset + MyClass.BASE;
		assertEquals("value should be rebased by " + MyClass.BASE, 
		             expected, result);     
	}

	@Test
	public void testCalcSum_NormalInputs() 
	{
		final List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		final int result = objectToTest.calc(values);

		assertEquals("sum should be calculated correnty", 21, result);		
	}

	@Test
	public void testCalcSum_When_NoValuesGiven() 
	{
		final int result = objectToTest.calc(Collections.<Integer>emptyList());

		assertEquals("sum should be null for empty list", 0, result);
	}

	@Test(expected=NullPointerException.class)
	public void testCalcSum_When_InputIsNull_ThenThrowException() 
	{
		objectToTest.calc(null);
	}
}