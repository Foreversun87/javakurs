package ch17_refactorings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch17_refactorings.NumberUtilsV2EmptyInputCorrected;

/**
 * Beispiel eines einfachen Unit Tests für die zweite Version der Klasse NumberUtils (NumberUtilsV2)
 * 
 * @author Michael Inden
 * 
 * Copyright 2011. 2014 by Michael Inden 
 */
public class NumberUtilsV2EmptyInputCorrectedTest
{
    // Teste gütige und ungültige Eingaben
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
}