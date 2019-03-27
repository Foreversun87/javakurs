package ch22_optimierungen.cpubound;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm zur Demonstration der Geschwindigkeit von aufwendigen 
 * mathematischen Berechnungen einmal iterativ und einmal rekursiv
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class FibonacciExample 
{
	public static void main(final String[] args) 
	{
		final int[] values = { 10, 30, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 55, 57 };
	
		for (final int currentValue : values)
		{
			System.out.println("currentValue: " + NumberFormat.getIntegerInstance().
							                                   format(currentValue));
			System.out.println("-----------------------------------------");
	
			final long start1 = System.nanoTime();
			final long fibRecursive = fibonacciRecursive(currentValue);
			final long end1 = System.nanoTime();
	
			System.out.println("fibonacciRecursive took: " + TimeUnit.NANOSECONDS.toMillis(end1 - start1) + " ms");
			System.out.println("fibonacciRecursive is: " + fibRecursive);  
	
			final long start2 = System.nanoTime();
			final long fibIterative = fibonaccieIterative(currentValue);
			final long end2 = System.nanoTime();
	
			System.out.println("fibonaccieIterative took: " + TimeUnit.NANOSECONDS.toMillis(end2 - start2) + " ms");
			System.out.println("fibonaccieIterative is: " + fibIterative);  
	
			System.out.println("-----------------------------------------");
		}
	}

	public static long fibonacciRecursive(long n)
	{
		if (n == 0)
			return 0;

		if (n == 1)
			return 1;

		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	public static long fibonaccieIterative(final long n) 
	{
		if (n == 0)
			return 0;
		
		if (n == 1)
			return 1;

		long fib_n_2 = 0;
		long fib_n_1 = 1;
		long fib_n = 0;
		
		for (long i = 2; i <= n; i++)
		{
			fib_n = fib_n_2 + fib_n_1;

			fib_n_2 = fib_n_1;
			fib_n_1 = fib_n;
		}

		return fib_n;
	}
}