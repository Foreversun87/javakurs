package ch17_refactorings;

import com.google.common.base.Preconditions;

/**
 * Beispiel einer Utility-Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class NumberUtilsV3NullInputCorrected
{
	public static boolean isNumber(final String value) 
	{
		Preconditions.checkNotNull(value, "parameter 'value' must not be null");

		if (value.isEmpty())
		{
			return false;
		}
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