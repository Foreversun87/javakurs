package ch17_refactorings;

import com.google.common.base.Preconditions;

/**
 * Beispiel einer Utility-Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class NumberUtilsV5Sign
{
    public static boolean isNumber(final String value)
    {
		Preconditions.checkNotNull(value, "parameter 'value' must not be null");

		if (value.isEmpty())
			return false;

		// erlaube Vorzeichen
		String number = value;
		if (value.startsWith("-") || value.startsWith("+"))
		{
			number = value.substring(1, value.length());
		}
		for (int i = 0; i < number.length(); i++) 
		{
			if (!(Character.isDigit(number.charAt(i)))) 
			{
				return false;
			}
		}
		return true;
    }
}