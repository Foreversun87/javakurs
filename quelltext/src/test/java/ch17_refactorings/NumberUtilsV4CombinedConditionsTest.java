package ch17_refactorings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Beispiel eines einfachen Unit Tests für die vierte Version der Klasse NumberUtils  
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class NumberUtilsV4CombinedConditionsTest 
{
	@Test
    public void testValidNumberInput()
    {
        assertTrue(NumberUtilsV4CombinedConditions.isNumber("12345"));
    }

	@Test
    public void testInvalidInput()
    {
        assertFalse(NumberUtilsV4CombinedConditions.isNumber("ABC"));
    }

	// Prüfe Länge 0 und 1 bezüglich IndexOutOfBoundsException
	@Test
    public void testNumberInputLength0()
    {
        assertFalse(NumberUtilsV4CombinedConditions.isNumber(""));
    }

	@Test
    public void testNumberInputLength1()
    {
        assertTrue(NumberUtilsV4CombinedConditions.isNumber("1"));
    }

	@Test
    public void testNullInput()
    {
        try
        {
        	NumberUtilsV4CombinedConditions.isNumber(null);
            // es wird als Reaktion eine Exception erwartet
            fail();
        }
        catch (final Exception ex)
        {
            // einer der beiden Typen wird als Reaktion erwartet  
            assertTrue(isNullPointerOrIllegalArgumentException(ex));
            // Teste auf Standardexception  
            assertFalse(StringUtils.isEmpty(ex.getMessage()));
        }
    }

    private boolean isNullPointerOrIllegalArgumentException(final Exception ex)
    {
        return (ex instanceof NullPointerException || ex instanceof IllegalArgumentException);
    }
}