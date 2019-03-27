package ch10_advancedjava.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Beispielprogramm zur Definition eines InvocationHandler als Basis für einen dynamischen Proxy zur Performance-Messung
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class LoggingInvocationHandler implements InvocationHandler
{
    private Object target;

    public LoggingInvocationHandler(final Object target)
    {
        this.target = target;
    }

    public Object invoke(final Object proxy, final Method mmethod, final Object[] args) throws Throwable
    {
        System.out.println("Invoking " + mmethod.getName() + " " + Arrays.toString(args));
        return mmethod.invoke(target, args);
    }
}