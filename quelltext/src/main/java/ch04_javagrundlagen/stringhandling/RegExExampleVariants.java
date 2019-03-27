package ch04_javagrundlagen.stringhandling;

import ch04_javagrundlagen.StringUtils;

/**
 * Beispielprogramm zur Demonstration regul�rer Ausdr�cke
 * <br>
 * Auswertung von Varianten/ Alternativen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class RegExExampleVariants
{
    public static void main(final String[] args)
    {
        final String input = "#1# Wert1 #5# Wert5 #7# Wert7";
        final String delimiter = "#(0|1|2|3|4|5|6|7|8|9)#";

        final String[] tokens = input.split(delimiter);
        StringUtils.printTokens(tokens);
    }

    private RegExExampleVariants()
    {
    }
}
