package ch17_refactorings.basics;

import static ch17_refactorings.basics.TimeStampUtilsStepFinal.createTimeStampString;
import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * Beispiel für einfache Testfälle
 *  
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class TimeStampUtilsTest 
{
	@Test
	public void test_createTimeStampString_Monthly()
	{
		final boolean MONTHLY = true;
		assertEquals("2000-2", createTimeStampString(new DateTime(2000, 2, 7, 0, 0), MONTHLY));
		assertEquals("2000-7", createTimeStampString(new DateTime(2000, 7, 14, 0, 0), MONTHLY));
		assertEquals("2000-12", createTimeStampString(new DateTime(2000, 12, 24, 0, 0), MONTHLY));
	}
	
	@Test
	public void test_createTimeStampString_Quarterly()
	{
		final boolean QUARTERLY = false;
		assertEquals("2000-Q1", createTimeStampString(new DateTime(2000, 2, 7, 0, 0), QUARTERLY));
		assertEquals("2000-Q3", createTimeStampString(new DateTime(2000, 7, 14, 0, 0), QUARTERLY));
		assertEquals("2000-Q4", createTimeStampString(new DateTime(2000, 12, 24, 0, 0), QUARTERLY));
	}
}
