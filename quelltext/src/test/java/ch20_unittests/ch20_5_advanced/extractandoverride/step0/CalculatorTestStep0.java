package ch20_unittests.ch20_5_advanced.extractandoverride.step0;

import ch20_unittests.ch20_5_advanced.extractandoverride.step1_2.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testklasse f�r die Klasse Calculator mit ExtractAndOverride
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */ 
public class CalculatorTestStep0
{
    @Test
    public void testCalc_TwoNumbers_ShouldReturnSum()
    {
        final Calculator calculator = new Calculator();
        assertEquals(5, calculator.calc("2", "3"));
    }

    @Test
    public void testCalc_WithEqualNumbersButDifferentSigns_ShouldReturn0()
    {
        final Calculator calculator = new Calculator();
        assertEquals(0, calculator.calc("7", "-7"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCalc_IllegalInputs_ShouldRaiseException()
    {
        final Calculator calculator = new Calculator();
        calculator.calc("a2", "b3");
    }
}