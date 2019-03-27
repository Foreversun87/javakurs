package ch04_javagrundlagen.errorhandling;

import java.util.StringTokenizer;

/**
 * Beispielprogramm für Assertions 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class AssertExample
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
            assert !majorVersion.isEmpty();
            assert !minorVersion.isEmpty(); 

            System.out.println("Major: '" + majorVersion + "'");
            System.out.println("Minor: '" + minorVersion + "'");
            System.out.println("#Tokens: '" + tokenCount + "'");
        }
        else
        {
            System.err.println("Unexpected version number format => no '.' found");
        }
    }

    private AssertExample()
    {
    }
}
