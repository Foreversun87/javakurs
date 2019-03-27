package ch20_unittests.basics;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import ch20_unittests.basics.MyClass;

/**
 * Unit-Tests zu der Utility-Klasse MyClass.
 * Dienen zur Demonstration der Benennung von Methodennamen
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden
 */
public class MyClassTest 
{
	@Test
	public void testCalcSum_NormalInputs() 
	{
		final MyClass objectToTest = createMyClassObjectForTest();
		
		final List<Integer> values = Arrays.asList(1, 2, 3, -4);
		final int result = objectToTest.calc(values);

		final int expected = 2;
		assertEquals("sum should be calculated correnty", expected, result);		
	}

	@Test
	public void testCalcSum_When_NoValuesGiven() 
	{
		final MyClass objectToTest = createMyClassObjectForTest();

		final int result = objectToTest.calc(Collections.<Integer>emptyList());

		final int expected = 0;
		assertEquals("sum should be null for empty list", expected, result);
	}

	@Test(expected=NullPointerException.class)
	public void testCalcSum_When_InputIsNull_ThenThrowException() 
	{
		final MyClass objectToTest = createMyClassObjectForTest();
		
		objectToTest.calc(null);
	}

	@Test
	public void testGetValue()
	{
		final int base = MyClass.BASE;
		final int offset = 4711;
		final MyClass objectToTest = createMyClassObjectForTest();

		final int result = objectToTest.getValue();

		final int expected = offset + base;
		assertEquals("value should be rebased by " + base,
				expected, result);
	}

	private MyClass createMyClassObjectForTest()
	{
		final int dummyOffset = 4711;
		return new MyClass(dummyOffset);
	}
}