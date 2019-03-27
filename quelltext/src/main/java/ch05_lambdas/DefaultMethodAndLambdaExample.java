package ch05_lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm, das die neuen Defaultmethoden sort() und forEach()
 * für Collections und deren Zusammenspiel mit Lambdas zeigt.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class DefaultMethodAndLambdaExample
{
    public static void main(final String[] args)
    {
        final List<String> names = Arrays.asList("Andy", "Michael", "Max", "Stefan");

        names.sort((str1, str2) -> Integer.compare(str1.length(), str2.length()));
        names.forEach(it -> System.out.print(it.length() + ", "));
    }
}