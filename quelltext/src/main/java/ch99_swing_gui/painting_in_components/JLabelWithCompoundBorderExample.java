package ch99_swing_gui.painting_in_components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Beispielprogramm zur Demonstration der Klasse Border für Umrahmungen von GUI-Komponenten. 
 * <br>
 * <b>Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JLabelWithCompoundBorderExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JLabelWithCompoundBorderExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JLabel label = new JLabel("Text mit zwei Rändern vom Typ Border");

        // Verschiedene Umrahmungen erzeugen  
        final Border blueBorder = BorderFactory.createLineBorder(Color.BLUE, 5);
        final Border titledBorder = BorderFactory.createTitledBorder("Title");
        final Border compoundBorder = BorderFactory.createCompoundBorder(
                                                     titledBorder, blueBorder);

        // Umrahmungen mit dem JLabel verknï¿½pfen  
        label.setBorder(compoundBorder);

        frame.add(label);
        frame.setSize(350, 90);
        frame.setVisible(true);
    }
    
    private JLabelWithCompoundBorderExample()
    {        
    }
}