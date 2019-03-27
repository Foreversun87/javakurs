package ch17_refactorings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Beispiel eines einfachen Unit Tests für die dritte Version der Klasse NumberUtils  
 * 
 * @author Michael Inden
 * 
 * Copyright 2011. 2014 by Michael Inden 
 */
public class NumberUtilsV3NullInputCorrectedTest
{
    // Teste gültige und ungültige Eingaben
	@Test 
	public void testValidNumberInput()
    {
        assertTrue(NumberUtilsV3NullInputCorrected.isNumber("12345"));
    }

	@Test 
	public void testInvalidInput()
    {
        assertFalse(NumberUtilsV3NullInputCorrected.isNumber("ABC"));
    }

	// Prüfe Länge 0 und 1 bezüglich IndexOutOfBoundsException
	@Test 
	public void testNumberInputLength0()
    {
        assertFalse(NumberUtilsV3NullInputCorrected.isNumber(""));
    }

	@Test 
	public void testNumberInputLength1()
    {
        assertTrue(NumberUtilsV3NullInputCorrected.isNumber("1"));
    }
	
	@Test
    public void testNullInput()
    {
        try
        {
        	NumberUtilsV3NullInputCorrected.isNumber(null);
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