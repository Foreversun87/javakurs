package ch20_unittests.basics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Beispiel zur Demnonstration des Tests von (kleinen) Abweichungen
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class DoubleWithDeviationTest
{
	@Test
	public void testDoubleWithDeviation() 
	{
		final double EPSILON = 0.0001;

		// komplexe Berechnung, hier nur exemplarisch
		final double result = 10.0 / 3.0 * 100;

		assertEquals(333.3333, result, EPSILON);
	}
}
