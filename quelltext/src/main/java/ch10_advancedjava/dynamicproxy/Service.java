package ch10_advancedjava.dynamicproxy;

import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm zur Definition eines einfachen Services
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class Service implements IService
{
    @Override
    public void doSomething()
    {
        System.out.println("doSomething");
    }

    @Override
    public String calculateSomething(final int value)
    {
        System.out.println("calculateSomething");
        try
        {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (final InterruptedException e)
        {
            // can't happen here, no other thread to interrupt us
        }

        return "" + value;
    }
}