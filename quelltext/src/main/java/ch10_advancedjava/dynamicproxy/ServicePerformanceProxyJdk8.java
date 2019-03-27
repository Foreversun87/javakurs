package ch10_advancedjava.dynamicproxy;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm zur Definition eines statischen Proxys zur Performance-Messung mit Lambdas aus JDK 8
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ServicePerformanceProxyJdk8 implements IService
{
    private final IService original;

    ServicePerformanceProxyJdk8(final IService original)
    {
        this.original = original;
    }

    @Override
    public void doSomething() 
    {
        measuredExecute(() -> { original.doSomething(); return null; }, "doSomething");
    }

    @Override
    public String calculateSomething(int value)
    {
        return measuredExecute(() -> original.calculateSomething(value), "calculateSomething");
    }

    private <V> V measuredExecute(final Callable<V> callable, final String methodName)
    {
        final long startTime = System.nanoTime();

        V result = null;
        try
        {
            result = callable.call();
        }
        catch (Exception e)
        {
            System.out.println("exception in call of '" + methodName + "': " + e.getMessage());
        }

        printExecTime(methodName, System.nanoTime() - startTime);
        return result;
    }

    private void printExecTime(final String methodName, final long duration)
    {
        System.out.println("Method call of '" + methodName + "' took: " + TimeUnit.NANOSECONDS.toMillis(duration) + " ms");
    }
}