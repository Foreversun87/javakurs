package ch10_advancedjava.dynamicproxy;

/**
 * Beispielprogramm zur Definition eines statischen Proxys
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class StaticProxyExample 
{
	public static void main(String[] args) 
	{
		final IService service = createService();
		service.calculateSomething(42);
	}

	private static IService createService() 
	{
		final IService oriinal = new Service();
		return new ServicePerformanceProxy(oriinal);
	}
}
