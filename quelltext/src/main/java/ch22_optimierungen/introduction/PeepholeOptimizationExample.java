package ch22_optimierungen.introduction;


/**
 * Beispielprogramm zur Demonstration verschiedener Peephole-Optimierungen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class PeepholeOptimizationExample
{
    // Source-Code
    private static long multiplyBy6(final long x)
    {
        return x * 6;
    }

    private static long multiplyBy6Optimized(final long x)
    {
        return (x << 2) + (x << 1);
    }

    // Inlinig
    private static int processValues(final int x, final int y)
    {
        return multiply(x, y);
    }

    private static int multiply(final int x, final int y)
    {
        return x * y;
    }

    // Integration der Methode multiply()
    private static int processValuesInlined(final int x, final int y)
    {
        return x * y;
    }

    // Loop-Unrolling
    private static int conventionalLoop()
    {
        int x = 0;
        for (int i = 1; i < 4; i++)
        {
            x += i * i;
        }
        return x;
    }

    private static int unrolledLoop()
    {
        int x = 0;
        x += 1 * 1;
        x += 2 * 2;
        x += 3 * 3;
        return x;
    }

    private static void assigment()
    {
        int x = 0;
        x = 4 * 25;
        // ...
    }

    private static void assigmentOptimized()
    {
        int x = 100; // Peephole: Zuweisung und Multiplikation
        // ...
    }

    public static void main(final String[] args)
    {
        final long ONE_BILLION = 1_000_000_000;
        long value = 0;

        PerformanceUtils.startMeasure("multiplyBy6");
        for (long i = 0; i < ONE_BILLION; i++)
        {
            value = i * 6; //multiplyBy6(i);            
        }
        PerformanceUtils.stopMeasure("multiplyBy6");
        PerformanceUtils.printTimingResultWithAverage("multiplyBy6", ONE_BILLION);

        // vermeide Hot-Spot-Weg-Optimierungen der Zuweisungen
        System.out.println("Result: " + value);

        value = 0;
        PerformanceUtils.startMeasure("multiplyBy6Optimized");
        for (long i = 0; i < ONE_BILLION; i++)
        {
            value = (i << 2) + (i << 1); //multiplyBy6Optimized(i);
            //int x = (int)Math.exp((double)(48 + (int)(value / (i+1))));
        }
        PerformanceUtils.stopMeasure("multiplyBy6Optimized");
        PerformanceUtils.printTimingResultWithAverage("multiplyBy6Optimized", ONE_BILLION);

        // vermeide Hot-Spot-Weg-Optimierungen der Zuweisungen
        System.out.println("Result: " + value);
    }
}
