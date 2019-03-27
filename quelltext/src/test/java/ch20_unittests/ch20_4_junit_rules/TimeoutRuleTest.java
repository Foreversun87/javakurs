package ch20_unittests.ch20_4_junit_rules;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Unit-Tests zur Demonstration der JUnit Rule Timeout
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class TimeoutRuleTest 
{
	@Rule
	public Timeout timeout = new Timeout(500, TimeUnit.MILLISECONDS);
	 
	@Test
	public void longRunningAction() throws InterruptedException 
	{
		for (int i=0; i < 20; i++)
		{
			TimeUnit.SECONDS.sleep(1);
		}
	}

	@Test
	public void loopForever() throws InterruptedException 
	{
		for (;;)
		{
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
