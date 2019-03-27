package ch09_multithreading.concurrency;

/**
 * Beispiel für ein Runnable, dass Ein-und Ausgaben unterstützt
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2014 by Michael Inden 
 */
public class InOutputRunnableExample<T1, T2, V> implements Runnable
{
    private final T1 input1;
	private final T2 input2;
	
	private V resultValue = null;

	private volatile boolean calculationFinished = false;

	public InOutputRunnableExample(final T1 input1, final T2 input2)
	{
		this.input1 = input1;
		this.input2 = input2;
	}

	public void run()
	{
		calculationFinished = false;

		resultValue = calculateResult(input1, input2);
		
		calculationFinished = true;		
	}

	public V getResult()
	{
		return resultValue;
	}

	public boolean isCalculationFinished()
	{
		return calculationFinished;
	}

	private V calculateResult(final T1 input1, final T2 input2)
	{
		return null;
	}
}