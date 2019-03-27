package ch10_advancedjava.dynamicproxy;

import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm zur Definition eines statischen Proxys zur Performance-Messung
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ServicePerformanceProxy implements IService
{
	private final IService service;

	ServicePerformanceProxy(final IService service) 
	{
		this.service = service;
	}

	@Override
	public String calculateSomething(int value) 
	{
		final long startTime = System.nanoTime();

		final String result = service.calculateSomething(value);

		printExecTime("calculateSomething", System.nanoTime() - startTime);

		return result;
	}

	@Override
	public void doSomething() 
	{
		final long startTime = System.nanoTime();

		service.doSomething();

		printExecTime("doSomething", System.nanoTime() - startTime);
	}

    private void printExecTime(final String methodName, final long duration)
    {
        System.out.println("Method call of '" + methodName + "' took: " + 
                           TimeUnit.NANOSECONDS.toMillis(duration) + " ms");
    }
}