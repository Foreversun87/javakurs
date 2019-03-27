package ch99_swing_gui.intro;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Beispielklasse einer sehr einfachen ersten Swing-Applikation.
 * Hier wird aber nur ein Bedienelement dargestellt obwohl zwei hinzugef�gt wurden.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012, 2014 by Michael Inden
 */
public class FirstSwingExample
{
    public static void main(final String[] args)
    {
    	// JFrame als Fenster und als Container f�r Bedienelemente erzeugen
    	final JFrame frame = new JFrame("First Swing");
    
    	// JLabel bzw. JButton erzeugen und zum frame hinzuf�gen
    	frame.add(new JLabel("Text-Label:"));
    	frame.add(new JButton("Button -- Press Me!"));
    
    	// Gr��e festlegen und sichtbar machen
       frame.setSize(400, 200);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

