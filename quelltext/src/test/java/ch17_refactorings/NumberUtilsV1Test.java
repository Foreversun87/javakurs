package ch17_refactorings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch17_refactorings.NumberUtilsV1;

/**
 * Beispiel eines einfachen Unit Tests f�r die erste Version der Klasse NumberUtils (NumberUtilsV1)
 * 
 * @author Michael Inden
 * 
 * Copyright 2011. 2014 by Michael Inden 
 */
public class NumberUtilsV1Test
{
    // Teste g�tige und ung�ltige Eingaben
	@Test 
	public void testValidNumberInput()
    {
        assertTrue(NumberUtilsV1.isNumber("12345"));
    }

	@Test 
	public void testInvalidInput()
    {
        assertFalse(NumberUtilsV1.isNumber("ABC"));
    }

    // Pr�fe L�nge 0 und 1 bez�glich IndexOutOfBoundsException
	@Test 
	public void testNumberInputLength0()
    {
        assertFalse(NumberUtilsV1.isNumber(""));
    }

	@Test 
	public void testNumberInputLength1()
    {
        assertTrue(NumberUtilsV1.isNumber("1"));
    }
}