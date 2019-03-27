package ch99_swing_gui.painting_in_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Beispielprogramm zur Demonstration des Zeichnens von fünf Rechtecken innerhalb der Fläche eines JLabels. 
 * <br>
 * <b>Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JLabelDrawingExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JLabelDrawingExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JLabel borderedLabel = new JLabel("Dies ist ein Text mit blauem Rand")
        {
            @Override
            public void paintComponent(final Graphics graphics)
            {
                super.paintComponent(graphics);

                // 5 Rechtecke mit 1 Pixel Breite zeichnen
                graphics.setColor(Color.BLUE);
                for (int i = 0; i < 5; i++)
                {
                    final int width = getWidth() - 1 - i * 2;
                    final int height = getHeight() - 1 - i * 2;

                    graphics.drawRect(i, i, width, height);
                }
            }
        };
        borderedLabel.setPreferredSize(new Dimension(250, 50));
        frame.add(borderedLabel);

        frame.setSize(300, 70);
        frame.setVisible(true);
    }
    
    private JLabelDrawingExample()
    {        
    }
}
