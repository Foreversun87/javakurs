package ch22_optimierungen.memorybound;

import java.util.Formatter;

import ch22_optimierungen.introduction.PerformanceUtils;

/**
 * Beispielprogramm zuer Ermittlung der Laufzeit verschiedener Formen der
 * Stringkonkatenation
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class StringBenchmark2
{   
    public static void main(String[] args)
    {
        final String name = "Sarah vom Auetal";
        final int counter = 1_000_000;
        String result = "";

        // Messung mit String + 
        result = measureStringPlus(name, counter);

        // Messung mit String += 
        result = measureStringPlusEquals(name, counter);

        // Messung mit StringBuilder 
        result = measureStringBuilderAppend(name, counter);

        // Messung mit StringBuilder und initialer Kapazit�t
        result = measurePresizedStringBuilderAppend(name, counter);

        // Messung mit String.format()
        result = measureStringFormat(name, counter);

        // Messung mit StringBufferr 
        result = measureStringBufferAppend(name, counter);

        // Messung mit StringBufferr und initialer Kapazit�t
        result = measurePresizedStringBufferAppend(name, counter);

        // Messung mit String und Formatter
        result = measureStringAndFormatter(name, counter);

        // Messung mit StringBuilder, initialer Kapazit�t und Formatter
        result = measureStringBuilderAndFormatter(name, counter);

        // Ausgabe des Ergebnisses vermeidet Weg-Optimierung der Berechnungen
        System.out.println(result);
    }

    private static String measureStringPlus(final String name, final int counter)
    {
    	String result = "";
        PerformanceUtils.startMeasure("String +");
        for (int i = 0; i < counter; i++)
        {
            result = "Mein Hund ist " + i + " Jahre alt und hei�t " + name + ".";
        }
        PerformanceUtils.stopMeasure("String +");
        PerformanceUtils.printTimingResultWithAverage("String +", counter);
        return result;
    }

    private static String measureStringPlusEquals(final String name, final int counter)
    {
    	String result = "";
        PerformanceUtils.startMeasure("String +=");
        for (int i = 0; i < counter; i++)
        {
            result = "Mein Hund ist ";
            result += i;
            result += " Jahre alt und hei�t ";
            result += name;
            result += ".";
        }
        PerformanceUtils.stopMeasure("String +=");
        PerformanceUtils.printTimingResultWithAverage("String +=", counter);
        return result;
    }

    private static String measureStringBuilderAppend(final String name, final int counter)
    {
    	String result = "";
        PerformanceUtils.startMeasure("StringBuilder");
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counter; i++)
        {
        	sb.setLength(0);
            sb.append("Mein Hund ist ").append(i).append(" Jahre alt und hei�t ").append(name).append(".");
            result = sb.toString();
        }
        PerformanceUtils.stopMeasure("StringBuilder");
        PerformanceUtils.printTimingResultWithAverage("StringBuilder", counter);
        return result;
    }

    // ----------------------
    
    private static String measureStringBuilderAndFormatter(final String name, final int counter)
    {
    	String result = "";
        PerformanceUtils.startMeasure("StringBuilder And Formatter");
        final StringBuilder sb = new StringBuilder(100);
        final Formatter formatter = new Formatter(sb);
        for (int i = 0; i < counter; i++)
        {
            result = formatter.format("Mein Hund ist %1$d Jahre alt und hei�t %2$s.", i, name).toString();
        }
        PerformanceUtils.stopMeasure("StringBuilder And Formatter");
        PerformanceUtils.printTimingResultWithAverage("StringBuilder And Formatter", counter);
        return result;
    }

    private static String measureStringFormat(final String name, final int counter)
    {
    	String result = "";
        PerformanceUtils.startMeasure("String.format()");
        for (int i = 0; i < counter; i++)
        {
            result = String.format("Mein Hund ist %d Jahre alt und hei�t %s.", i, name);
        }
        PerformanceUtils.stopMeasure("String.format()");
        PerformanceUtils.printTimingResultWithAverage("String.format()", counter);
        return result;
    }

    private static String measureStringAndFormatter(final String name, final int counter)
    {
    	String result = "";
        PerformanceUtils.startMeasure("String And Formatter");
        final Formatter formatter = new Formatter();
        for (int i = 0; i < counter; i++)
        {
            result = formatter.format("Mein Hund ist %1$d Jahre alt und hei�t %2$s.", i, name).toString();
        }
        PerformanceUtils.stopMeasure("String And Formatter");
        PerformanceUtils.printTimingResultWithAverage("String And Formatter", counter);
        return result;
    }

    private static String measureStringBufferAppend(final String name, final int counter)
    {
    	String result = "";
        PerformanceUtils.startMeasure("StringBuffer");
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < counter; i++)
        {
        	sb.setLength(0);
            sb.append("Mein Hund ist ").append(i).append(" Jahre alt und hei�t ").append(name).append(".");
            result = sb.toString();
        }
        PerformanceUtils.stopMeasure("StringBuffer");
        PerformanceUtils.printTimingResultWithAverage("StringBuffer", counter);
        return result;
    }

    private static String measurePresizedStringBufferAppend(final String name, final int counter)
    {
    	String result = "";
        PerformanceUtils.startMeasure("StringBuffer Presized");
        for (int i = 0; i < counter; i++)
        {
            final StringBuffer sb = new StringBuffer(100);
            sb.append("Mein Hund ist ").append(i).append(" Jahre alt und hei�t ").append(name).append(".");
            result = sb.toString();
        }
        PerformanceUtils.stopMeasure("StringBuffer Presized");
        PerformanceUtils.printTimingResultWithAverage("StringBuffer Presized", counter);
        return result;
    }

    private static String measurePresizedStringBuilderAppend(final String name, final int counter)
    {
    	String result = "";
        PerformanceUtils.startMeasure("StringBuilder Presized");
        for (int i = 0; i < counter; i++)
        {
            final StringBuilder sb = new StringBuilder(100);
            sb.append("Mein Hund ist ").append(i).append(" Jahre alt und hei�t ").append(name).append(".");
            result = sb.toString();
        }
        PerformanceUtils.stopMeasure("StringBuilder Presized");
        PerformanceUtils.printTimingResultWithAverage("StringBuilder Presized", counter);
        return result;
    }

    private StringBenchmark2()
    {
    }
}