package ch22_optimierungen.cpubound;

import ch22_optimierungen.introduction.PerformanceUtils;

/**
 * Beispielprogramm zur Demonstration des Einflusses von Vorausberechnungen mit Look-up-Tabellen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class SinCalculationLookUpOptimizationExample2
{
    private static final double[] sinLookUp = new double[360];
    
    public static void main(final String[] args)
    {
        final long ONE_MILLION = 1000 * 1000;
        final long[] maxElements = { ONE_MILLION, 10 * ONE_MILLION, 
                                     100 * ONE_MILLION, 1000 * ONE_MILLION };

        for (final long maxCounter : maxElements)
        {        
            double sinValue = 0.0;
            
            PerformanceUtils.startMeasure("calcSin " + maxCounter);
            for (long i = 0; i < maxCounter; i++)
            {
                sinValue = calcSin(i);
            }
            PerformanceUtils.stopMeasure("calcSin " + maxCounter);
            PerformanceUtils.printTimingResultWithAverage("calcSin " + maxCounter, maxCounter);
            System.out.println("Result= " + sinValue);
    
            PerformanceUtils.startMeasure("calcSinOptimized " + maxCounter);
            populateLookUpTable();
            for (long i = 0; i < maxCounter; i++)
            {
                sinValue = calcSinOptimized(i);
            }
            PerformanceUtils.stopMeasure("calcSinOptimized " + maxCounter);
            PerformanceUtils.printTimingResultWithAverage("calcSinOptimized " + maxCounter, maxCounter);
            
            System.out.println("Result= " + sinValue);
        }
    }
    
    private static double calcSin(final double x)
    {
        return Math.sin(x % 360);
    }
    
    private static double calcSinOptimized(final double x)
    {
        final int lookUpPos = (int) (x % 360);
        return sinLookUp[lookUpPos];
    }
    
    private static void populateLookUpTable()
    {
        for (int i = 0; i < 360; i++)
        {
            sinLookUp[i] = Math.sin(i);
        }
    }
    
    private SinCalculationLookUpOptimizationExample2()
    {        
    }
}
