package ch22_optimierungen.memorybound;

import ch22_optimierungen.introduction.MemoryInfo;
import ch22_optimierungen.introduction.PerformanceUtils;

/**
 * Beispielprogramm zur Demonstration des Einflusses von Pooling bei Booleans
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class BooleanPoolingOptimization
{
    public static void main(final String[] args)
    {
    	    final Boolean[] testArray = new Boolean[10_000_000];
	    reportMemory("Start");        
	    performTests(testArray, "Boolean.TRUE", false);
	    reportMemory("After Boolean.TRUE");
	    performTests(testArray, "new Boolean(true)", true);
	    reportMemory("After new Boolean(true)");
    }

	private static void reportMemory(final String info) 
	{		
		MemoryInfo.gcAndSleep5s();
		System.out.println(info);
        System.out.println(MemoryInfo.statistics());
	}

    public static void performTests(final Boolean[] testArray, 
                                    final String info, 
                                    final boolean createNew)
    {
        PerformanceUtils.startMeasure(info);
        for (int i = 0; i < testArray.length; i++)
        {
            if (createNew)
                testArray[i] = new Boolean(true);
            else
                testArray[i] = Boolean.TRUE;
        }
        PerformanceUtils.stopMeasure(info);
        PerformanceUtils.printTimingResult(info);
    }

    private BooleanPoolingOptimization()
    {
    }
}
