package ch17_refactorings;

/**
 * Beispiel einer Utility-Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class NumberUtilsV1
{
    public static boolean isNumber(final String value)
    {
        if (Character.isDigit(value.charAt(0)))
        {
            for (int i = 1, n = value.length(); i < n; i++)
            {
                if (!(Character.isDigit(value.charAt(i))))
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }    
        return true;
    }
}