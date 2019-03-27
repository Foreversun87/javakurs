package ch17_refactorings;

import com.google.common.base.Preconditions;

/**
 * Beispiel einer Utility-Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class NumberUtilsV4CombinedConditions
{
	public static boolean isNumber(final String value) 
	{
		Preconditions.checkNotNull(value, "parameter 'value' must not be null");

		if (value.isEmpty())
		{
			return false;
		}
		for (int i = 0; i < value.length(); i++) 
		{
			if (!(Character.isDigit(value.charAt(i)))) 
			{
				return false;
			}
		}
		return true;
	}
	
	private NumberUtilsV4CombinedConditions()
	{}
}