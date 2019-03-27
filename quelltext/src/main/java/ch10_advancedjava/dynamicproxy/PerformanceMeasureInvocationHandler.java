package ch10_advancedjava.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm zur Definition eines InvocationHandler als Basis für einen dynamischen Proxy zur Performance-Messung
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class PerformanceMeasureInvocationHandler implements InvocationHandler
{
    private final IService service;

    public PerformanceMeasureInvocationHandler(final IService service) 
	{
		this.service = service;
	}

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable
    {
        final long startTime = System.nanoTime();

        Object result = null;
        try
        {
            // Achtunng hier nicht versehentlich proxy Ã¼bergeben
            result = method.invoke(service, args);
        }
        catch (InvocationTargetException ex)
        {
            throw ex.getTargetException();
        }

        printExecTime("calculateSomething", System.nanoTime() - startTime);

        return result;
    }
    
    private void printExecTime(final String methodName, final long duration)
    {
        System.out.println("Method call of '" + methodName + "' took: " + TimeUnit.NANOSECONDS.toMillis(duration) + " ms");
    }
}