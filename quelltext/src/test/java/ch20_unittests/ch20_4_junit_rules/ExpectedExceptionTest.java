package ch20_unittests.ch20_4_junit_rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit-Tests zur Demonstration der JUnit Rule ExpectedException
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ExpectedExceptionTest 
{	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void noExceptionExpected() 
	{
		// ...
	}

	@Test
	public void illegalStateExceptionWithMessageTextExpected() 
	{	
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("XYZ is not initialized");
		
		throw new IllegalStateException("XYZ is not initialized");
	}
}
