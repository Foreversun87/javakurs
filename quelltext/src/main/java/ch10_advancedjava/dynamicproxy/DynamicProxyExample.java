package ch10_advancedjava.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Beispielprogramm zum Einsatz eines dynamischen Proxy 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class DynamicProxyExample
{
    public static void main(final String[] args)
    {
        final IService service = createService();

        service.calculateSomething(42);
    }

    private static IService createService()
    {
        final IService service = new Service();

        final InvocationHandler handler = new PerformanceMeasureInvocationHandler(service);

        final Class<?>[] proxyInterfaces = { IService.class };
        return (IService) Proxy.newProxyInstance(Service.class.getClassLoader(), proxyInterfaces, handler);
    }
}