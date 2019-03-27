package ch99_swing_gui.intro;

import javax.swing.JTextField;

/**
 * Utility-Klasse zum prüfen der Textlänge eines JTextFiled.
 * Ausgelagert, da mehrfach genutzt
 * <br>
 * <b>Neu in Auflage 3</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2013 by Michael Inden
 */
public class TextLengthChecker {

	public static boolean checkRequiredLength(final JTextField textField, 
			                                  final int requiredLength) 
	{
		final boolean hasEnoughText = textField.getText() != null && 
				                      textField.getText().length() >= requiredLength;
		return hasEnoughText;
	}
}
