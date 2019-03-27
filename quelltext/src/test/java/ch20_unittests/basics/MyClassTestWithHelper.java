package ch20_unittests.basics;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Unit-Tests zu der Utility-Klasse MyClass.
 * Demonstration des Einsatzes von Hilfemthoden
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class MyClassTestWithHelper 
{
	@Test
	public void testGetId() 
	{
		final int offset = 4711;
		final MyClass objectToTest = createMyClass(offset);

		final int result = objectToTest.getValue();		

		final int expected = offset + MyClass.BASE;
		assertEquals("value should be rebased by " + MyClass.BASE, 
		             expected, result);    		    
	}

	private MyClass createMyClass(final int offset) 
	{
		return new MyClass(offset);
	}

	@Test
	public void testCalcSum_NormalInputs() 
	{
		final MyClass objectToTest = createMyClass(4711);
		
		final List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		final int result = objectToTest.calc(values);

		assertEquals("sum should be calculated correnty", 21, result);		
	}

	@Test
	public void testCalcSum_When_NoValuesGiven() 
	{
		final MyClass objectToTest = createMyClass(4711);

		final int result = objectToTest.calc(Collections.<Integer>emptyList());

		assertEquals("sum should be null for empty list", 0, result);
	}

	@Test(expected=NullPointerException.class)
	public void testCalcSum_When_InputIsNull_ThenThrowException() 
	{
		final MyClass objectToTest = createMyClass(4711);
		
		objectToTest.calc(null);
	}
}
