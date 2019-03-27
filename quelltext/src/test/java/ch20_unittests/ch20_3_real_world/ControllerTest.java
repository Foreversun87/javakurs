package ch20_unittests.ch20_3_real_world;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit-Tests zur Klasse Controller.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public class ControllerTest
{
    @Test
    public void testCalcState_WithInput_07()
    {
        assertEquals(7, Controller.calcState((byte) '0', (byte) '7'));
    }

    @Test
    public void testCalcState_WithInput_20()
    {
        assertEquals(2 * 16 + 0, Controller.calcState((byte) '2', (byte) '0'));
    }

    @Test
    public void testCalcState_WithInput_79()
    {
        assertEquals(7 * 16 + 9, Controller.calcState((byte) '7', (byte) '9'));
    }

    @Test
    public void testCalcState_WithInput_3F()
    {
        assertEquals(0x3f, Controller.calcState((byte) '3', (byte) 'F'));
    }

    @Test
    public void testCalcState_WithInput_AE()
    {
        assertEquals(0xAE, Controller.calcState((byte) 'A', (byte) 'E'));
    }

    @Test
    public void testCalcState_WithLowerCaseInput_ac()
    {
        assertEquals(0xAC, Controller.calcState((byte) 'a', (byte)'c'));
    }
}