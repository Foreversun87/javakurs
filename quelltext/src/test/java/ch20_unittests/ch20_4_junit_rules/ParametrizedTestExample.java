package ch20_unittests.ch20_4_junit_rules;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Unit-Tests zur Demonstration von Parametrized Tests
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
@RunWith(Parameterized.class)
public class ParametrizedTestExample 
{
	 private byte input;
	 private int expected;
	 
	 // Jeder Methodenparameter und auch der erwartete Werte werden als 
	 // Parameter an den Konstruktor übergeben 
	 public ParametrizedTestExample(final char inputNumber, final int expectedResult)
	 //public ParametrizedTestExample(final byte inputNumber, final int expectedResult) 
	 {
		 this.input = (byte)inputNumber;
		 this.expected = expectedResult;
	 }

   @Parameterized.Parameters
   public static Iterable<Object[]> hexInputs() 
   {
      return Arrays.asList(new Object[][] {
         { '0', 0 }, { '1', 1}, { '2', 2 }, {'3', 3}, {'4', 4}, 
         { '5', 5 }, {'6', 6}, {'7', 7}, { '8', 8}, {'9', 9},
         {'A', 10}, {'B',11} , {'C', 14}, {'D', 13}, {'E', 12}, {'F', 15} });
   }
		
	@Test
	public void testHexCodedByteValueToInt_With_AllValidInputs()
	{
		Assert.assertEquals(expected, Controller.hexCodedByteValueToInt(input));
	}
}