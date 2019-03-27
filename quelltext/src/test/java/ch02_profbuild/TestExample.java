package ch02_profbuild;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Beispiel für verschiedene assert()-Methoden
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class TestExample
{
    @Test
    public void testAssertTrue()
    {
        final List<String> names = new ArrayList<>(); 
        names.add("Max");
        names.add("Moritz");
        names.clear();
        assertTrue(names.isEmpty());
    }
    
    @Test
    public void testAssertFalse()
    {
        final List<Integer> primes = Arrays.asList(2, 3, 5, 7);
		// Hier wird bewusst ein Fehler provoziert 
        assertFalse(primes.contains(7));
    }

    @Test
    public void testAssertNull()
    {
        assertNull(null);
    }
    
    @Test
    public void testAssertNotNull()
    {
        // Hier wird bewusst ein Fehler provoziert 
        assertNotNull("Unexpected null value", null);
    }

    @Test
    public void testAssertEquals()
    {
        assertEquals("EXPECTED", "expected".toUpperCase());
    }

    @Test
    public void testAssertEqualsWithPrecision()
    {
        assertEquals(2.75, 2.74999, 0.1);
    }
    
    @Test(expected = java.lang.NumberFormatException.class)
    public void testFailWithExceptionJUnit4()
    {
        // Hier wird bewusst ein Fehler provoziert
        final int value = Integer.parseInt("Fehler simulieren!");
        fail("calculation should throw an exception!");
    }
}
