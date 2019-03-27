package ch20_unittests.ch20_4_junit_rules;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;
import org.junit.rules.Timeout;

/**
 * Unit-Tests zur Demonstration der Kombination von JUnit Rules
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class TimeoutAndExpectedExceptionTest 
{ 	
	public Timeout timeout = new Timeout(500, TimeUnit.MILLISECONDS);
	public ExpectedException thrown = ExpectedException.none();
	
	/*
	@Rule
    public RuleChain chain = RuleChain.outerRule(thrown).around(timeout);                             
*/
	@Rule
	public RuleChain chain = RuleChain.outerRule(timeout).around(thrown);         
	   
	@Test
	public void longRunningActionThrowTimeoutException() throws InterruptedException
	{
		thrown.expect(org.junit.runners.model.TestTimedOutException.class);
		thrown.expectMessage("test timed out after 500 milliseconds");
		
		for (int i=0; i < 20; i++)
		{
			TimeUnit.SECONDS.sleep(1);
		}
	}
}