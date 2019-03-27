package ch99_swing_gui.painting_in_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Beispielklasse zum einfacheren Zugriff auf Datenbankverbindungseinstellungen
 * <br>
 * <b>Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class DimensionAndInsetsExample
{
    public static void main(final String[] args)
    {
        final JFrame appFrame = new JFrame("DimensionAndInsetsExample");
        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JLabel label = new JLabel("Dieser Text wird überschrieben!")
        {
            @Override
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);

                final Insets insets = getInsets();
                final Dimension dimension = getSize();

                setText("<HTML><ul><li>Size: " + dimension + "<li>Inset: " + insets + "</ul></HTML>");

                g.setColor(Color.RED);
                g.drawRect(insets.left, insets.top, dimension.width - insets.left - insets.right - 1, dimension.height - insets.top
                                - insets.bottom - 1);
            }
        };

        // Verschiedene Umrahmungen erzeugen
        final Border blueBorder = BorderFactory.createLineBorder(Color.blue, 5);
        final Border titledBorder = BorderFactory.createTitledBorder("Title");
        final Border compoundBorder = BorderFactory.createCompoundBorder(titledBorder, blueBorder);

        // Mit JLabel verknüpfen
        label.setBorder(compoundBorder);

        appFrame.add(label);
        appFrame.setSize(450, 110);
        appFrame.setVisible(true);
    }
    
    private DimensionAndInsetsExample() 
    {        
    }
}
