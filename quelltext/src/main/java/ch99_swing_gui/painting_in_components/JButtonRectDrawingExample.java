package ch99_swing_gui.painting_in_components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Beispielprogramm zur Demonstration des Zeichnens innerhalb der Fläche eines JButtons. 
 * <br>
 * <b>Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JButtonRectDrawingExample 
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JButtonRectDrawingExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JButton button = new JButton("Button mit blauem Rechteck")
        {
            @Override
            public void paintComponent(final Graphics graphics)
            {
                super.paintComponent(graphics);

                graphics.setColor(Color.BLUE);
                graphics.fillRect(0, 0, 50, 50);
            }            
        };
        
        frame.add(button);
        frame.setSize(300, 70);
        frame.setVisible(true);
    }
    
    private JButtonRectDrawingExample()
    {        
    }
}
