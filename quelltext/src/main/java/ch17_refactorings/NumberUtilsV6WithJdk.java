package ch17_refactorings;

import com.google.common.base.Preconditions;

/**
 * Beispiel einer Utility-Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class NumberUtilsV6WithJdk
{
    public static boolean isNumber(final String value)
    {
        Preconditions.checkNotNull(value, "parameter 'value' must not be null");
    	
        try
        {
            Integer.parseInt(value); // Rückgabe ignorieren, nur prüfen 
            return true;
        }
        catch (final NumberFormatException ex)
        {
            return false;
        }
    }
}