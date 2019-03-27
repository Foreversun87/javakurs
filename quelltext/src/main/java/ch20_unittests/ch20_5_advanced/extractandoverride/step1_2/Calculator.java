package ch20_unittests.ch20_5_advanced.extractandoverride.step1_2;

import javax.swing.*;

/**
 * Beispielklasse, die eine Berechnung zweier int-Werte realisiert 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden
 */
public class Calculator
{
    public int calc(final String strNum1, final String strNum2)
	{
		try
		{
			final int num1 = Integer.parseInt(strNum1);
			final int num2 = Integer.parseInt(strNum2);
		
			return num1 + num2;
		}
		catch (final NumberFormatException ex)
		{
			showWarning("Keine gültige Ganzzahl");
			throw new IllegalArgumentException("Keine gültige Ganzzahl");
		}
	}

	protected void showWarning(final String message) 
	{
		JOptionPane.showConfirmDialog(null, message);
	}
}