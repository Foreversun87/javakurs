package ch04_javagrundlagen.errorhandling;

import java.util.StringTokenizer;

/**
 * Beispielprogramm für Assertions
 * <br>
 * Erweiterung um Methodenaufruf zum Prüfen der Bedingungen 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class AssertExampleWithMethods
{
    public static void main(final String[] args)
    {
        // ACHTUNG: fehlendes Token Minor-Version 
        final String versions = "12. ";
        final StringTokenizer tokenizer = new StringTokenizer(versions, ".");

        final int tokenCount = tokenizer.countTokens();
        if (tokenCount > 1)
        {
            final String majorVersion = tokenizer.nextToken().trim();
            final String minorVersion = tokenizer.nextToken().trim();

            // Sicherstellen, dass Tokens einen Wert enthalten 
            assert !majorVersion.isEmpty() : "Major-Version must not be empty";
            assert !minorVersion.isEmpty() : buildWarnMessage("Minor-Version");

            System.out.println("Major: '" + majorVersion + "'");
            System.out.println("Minor: '" + minorVersion + "'");
            System.out.println("#Tokens: '" + tokenCount + "'");
        }
    }

    private static String buildWarnMessage(final String version)
    {
        return version + " must not be empty!";
    }

    private AssertExampleWithMethods()
    {
    }
}
