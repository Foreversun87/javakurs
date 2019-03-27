package ch99_swing_gui.intro;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Beispielklasse einer sehr einfachen ersten Swing-Applikation.
 * Hier werden beide Bedienelemente dargestellt.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012, 2014 by Michael Inden
 */
public class FirstSwingExampleImproved
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("First Swing Improved Layout");

        // JLabel bzw. JButton mit Positionierungsangaben zum JFrame hinzufügen 
        frame.add(new JLabel("Text-Label:"), BorderLayout.WEST);
        frame.add(new JButton("Button -- Press Me!"), BorderLayout.CENTER);

        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
