package ch22_optimierungen.cpubound;

import ch22_optimierungen.introduction.PerformanceUtils;

/**
 * Beispielprogramm zur Demonstration des Einflusses von Vorausberechnungen mit Look-up-Tabellen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class SinCalculationLookUpOptimizationExample
{
    private static final double[] sinLookUp = new double[360];
    
    public static void main(final String[] args)
    {
        final long counter = 1000 * 1000;

        double sinValue = 0.0;
        
        PerformanceUtils.startMeasure("calcSin");
        for (long i = 0; i < counter; i++)
        {
            sinValue = calcSin(i);
        }
        PerformanceUtils.stopMeasure("calcSin");
        PerformanceUtils.printTimingResultWithAverage("calcSin", counter);
        System.out.println("Result= " + sinValue);

        PerformanceUtils.startMeasure("calcSinOptimized");
        populateLookUpTable();
        for (long i = 0; i < counter; i++)
        {
            sinValue = calcSinOptimized(i);
        }
        PerformanceUtils.stopMeasure("calcSinOptimized");
        PerformanceUtils.printTimingResultWithAverage("calcSinOptimized", counter);
        
        System.out.println("Result= " + sinValue);
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
    
    private SinCalculationLookUpOptimizationExample()
    {        
    }
}
