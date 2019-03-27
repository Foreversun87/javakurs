package ch10_advancedjava.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Beispielprogramm zum kombinierten Einsatz von zwei dynamischen Proxies 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class DynamicProxyCombinationExample
{
    public static void main(final String[] args)
    {
        final IService service = createService();
        service.calculateSomething(42);
    }

	private static IService createService()
	{
	    final IService origService = new Service();
	    final InvocationHandler handler1 = new PerformanceMeasureInvocationHandler(origService);
	
	    final Class<?>[] proxyInterfaces = { IService.class };
	    final  IService service = (IService) Proxy.newProxyInstance(Service.class.getClassLoader(), 
	                                                                proxyInterfaces, handler1);
	
	    final InvocationHandler handler2 = new LoggingInvocationHandler(service);
	    return (IService) Proxy.newProxyInstance(Service.class.getClassLoader(), proxyInterfaces, handler2);
	}
}