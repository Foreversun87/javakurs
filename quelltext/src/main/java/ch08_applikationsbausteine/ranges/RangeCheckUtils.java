package ch08_applikationsbausteine.ranges;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Hilfsklasse für Wertebereichsprüfungen 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class RangeCheckUtils
{
    // ##################### Einfache Wertebereiche #################################    

    // Basismethode 
    public static boolean isValueInRange(final long value, final long minValue, final long maxValue)
    {
		checkArgument(minValue <= maxValue, "minValue: " + minValue + " must be <= maxValue: " + maxValue);

        return (minValue <= value && value <= maxValue);
    }

    // Spezialbehandlung fï¿½r Floating-Point-Werte (Rundung) 
    public static boolean isValueInRange(final double value, final double minValue, final double maxValue)
    {
		checkArgument(minValue <= maxValue, "minValue: " + minValue + " must be <= maxValue: " + maxValue);
		
        return (value >= minValue && value <= maxValue);
    }

    // Typsichere Definition 
    public static <T extends Comparable<T>> boolean isValueInRange(final T value, 
    				                                               final T minValue, final T maxValue)
    {
    	checkNotNull(value, "value must no be null");
    	checkNotNull(minValue, "minValue must no be null");
    	checkNotNull(maxValue, "maxValue must no be null");   	
    	checkArgument(minValue.compareTo(maxValue) <= 0, "minValue: " + minValue + " must be <= maxValue: " + maxValue);

    	return (minValue.compareTo(value) <= 0 && value.compareTo(maxValue) <= 0);
    }

    // ##################### Einfache Wertemengen #################################

    public static boolean isValueValid(final long value, final long[] validValues)
    {
        for (final long currentValue : validValues)
        {
            if (value == currentValue)
                return true;
        }

        return false;
    }

    public static boolean isValueValid(final double value, final double[] validValues)
    {
        for (final double currentValue : validValues)
        {
            if (value == currentValue)
                return true;
        }

        return false;
    }

    public static <T> boolean isValueValid(final Comparable<T> value, final T[] validValues)
    {
        for (final T currentValue : validValues)
        {
            if (value.compareTo(currentValue) == 0)
                return true;
        }

        return false;
    }

    // ################# Einfache und mehrfache Wertebereiche ###########################

    // Methoden fï¿½r immer wiederkehrende Null-Prï¿½fungen 
    public static void assertStringParamNotNullOrEmpty(final String paramName, final String value)
    {
        if (value == null || value.length() == 0)
            throw new IllegalArgumentException("parameter '" + paramName + "' " + "must not be empty or null");
    }

    public static void assertArrayParamNotNullOrEmpty(final String paramName, final Object[] values)
    {
        if (values == null || values.length == 0)
            throw new IllegalArgumentException("parameter '" + paramName + "' " + "must not be empty or null");
    }

    public static void assertReferenceParamNotNull(final String paramName, final Object value)
    {
        if (value == null)
            throw new IllegalArgumentException("parameter '" + paramName + "' " + "must not be null");
    }
}