package ch17_refactorings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Beispiel eines einfachen Unit Tests für die zweite Version der Klasse NumberUtils 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011. 2014 by Michael Inden 
 */
public class NumberUtilsV2NullInputTest
{
    // Teste gültige und ungültige Eingaben
	@Test 
	public void testValidNumberInput()
    {
        assertTrue(NumberUtilsV2EmptyInputCorrected.isNumber("12345"));
    }

	@Test 
	public void testInvalidInput()
    {
        assertFalse(NumberUtilsV2EmptyInputCorrected.isNumber("ABC"));
    }

	// Prüfe Länge 0 und 1 bezüglich IndexOutOfBoundsException
	@Test 
	public void testNumberInputLength0()
    {
        assertFalse(NumberUtilsV2EmptyInputCorrected.isNumber(""));
    }

	@Test 
	public void testNumberInputLength1()
    {
        assertTrue(NumberUtilsV2EmptyInputCorrected.isNumber("1"));
    }
	
	@Test
    public void testNullInput()
    {
        try
        {
        	NumberUtilsV2EmptyInputCorrected.isNumber(null);
            // es wird als Reaktion eine Exception erwartet 
            fail();
        }
        catch (final Exception ex)
        {
            // einer der beiden Typen wird als Reaktion erwartet 
            assertTrue(ex instanceof NullPointerException);
            // Teste auf Standardexception 
            assertFalse(StringUtils.isEmpty(ex.getMessage()));
        }
    }
}