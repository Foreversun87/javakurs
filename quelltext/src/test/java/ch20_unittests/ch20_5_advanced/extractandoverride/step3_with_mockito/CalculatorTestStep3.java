package ch20_unittests.ch20_5_advanced.extractandoverride.step3_with_mockito;

import ch20_unittests.ch20_5_advanced.extractandoverride.step3_with_mockito.Calculator;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Testklasse für die Klasse Calculator mit ExtractAndOverride
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */ 
public class CalculatorTestStep3
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
    public void testCalc_IllegalInputs_ShouldRaiseException_UsingMockito()
    {
        // leere Implementierung erzeugen, tut nichts bei Methodenaufrufen und
        // liefert Defaultwerte
        final Calculator calculator = Mockito.mock(Calculator.class);

        // Verhalten fÃ¼r calc() vorgeben
        Mockito.when(calculator.calc("a2", "b3")).thenThrow(IllegalArgumentException.class);

        calculator.calc("a2", "b3");
    }
}