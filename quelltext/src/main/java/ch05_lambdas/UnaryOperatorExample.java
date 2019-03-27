package ch05_lambdas;

import java.util.function.UnaryOperator;

/**
 * Beispielprogramm zur Demonstration des Interfaces UnaryOperator<T>
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class UnaryOperatorExample
{
    public static void main(final String[] args)
    {
        // Mark
        final UnaryOperator<String> markTextWithM = str -> str.startsWith("M") ? ">>" + str.toUpperCase() + "<<" : str;
        printResult("Mark 1", "unchanged", markTextWithM);
        printResult("Mark 2", "Michael", markTextWithM);

        // Trim
        final UnaryOperator<String> trimmer = String::trim;
        printResult("Trim 1", "no_trim", trimmer);
        printResult("Trim 2", " trim me ", trimmer);

        // Map
        final UnaryOperator<String> mapNullToEmpty = str -> str == null ? "" : str;
        printResult("Map same", "same", mapNullToEmpty);
        printResult("Map null", null, mapNullToEmpty);
    }

    private static void printResult(final String text, final String value, final UnaryOperator<String> op)
    {
        System.out.println(text + ": '" + value + "' -> '" + op.apply(value) + "'");
    }
}
