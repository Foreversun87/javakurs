package ch99_swing_gui.painting_in_components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Beispielprogramm zur Demonstration der Klasse FontMetrics. 
 * <br>
 * <b>Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012, 2014 by Michael Inden
 */
public final class FontMetricsExample
{
    public static void main(String[] args)
    {
        final JFrame frame = new JFrame("FontMetricsExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JComponent fontMetricsComponent = new JComponent()
        {
            @Override
            public void paintComponent(final Graphics graphics)
            {
                super.paintComponent(graphics);

                // Schriftart Arial, Bold, 96 pt wählen
                final Font font = new Font("Arial", Font.BOLD, 96);
                graphics.setFont(font);

                // Textausgabe an Position x=20, y=96
                final int textStartXPos = 20;
                final int baseLinePos = 96;
                final String demotext = "Test QÄqä";
                graphics.drawString(demotext, textStartXPos, baseLinePos);

                // Ermitteln der Werte zum Zeichnen der Begrenzungslinien
                final FontMetrics fontMetrics = graphics.getFontMetrics();
                final int ascent = fontMetrics.getAscent();
                final int descent = fontMetrics.getDescent();
                final int leading = fontMetrics.getLeading();
               
                // Basislinie/Grundlinie
                graphics.drawLine(10, baseLinePos, 550, baseLinePos);

                // Obere + untere Begrenzungslinie: Ascent und Descent
                graphics.setColor(Color.GRAY);
                graphics.drawLine(10, baseLinePos - ascent, 550, baseLinePos - ascent);
                graphics.drawLine(10, baseLinePos + descent, 550, baseLinePos + descent);

                // Zeilenabstand
                graphics.drawLine(10, baseLinePos + descent + leading, 550, baseLinePos + descent + leading);

                // Mittellinie basierend auf Ascent
                graphics.setColor(Color.BLUE);
                graphics.drawLine(10, baseLinePos - ascent / 2, 550, baseLinePos - ascent / 2);

                // Vermutete Mittellinie
                graphics.setColor(Color.CYAN);
                graphics.drawLine(10, baseLinePos - ascent / 3, 550, baseLinePos - ascent / 3);

                // Mittellinie basierend auf Ascent und Descent
                graphics.setColor(Color.GREEN);
                graphics.drawLine(10, baseLinePos + descent - (ascent + descent) / 2, 550, baseLinePos + descent - (ascent + descent)
                                / 2);

                // Bounding Box des gesamten Textes
                graphics.setColor(Color.RED);
                final Rectangle2D rect2D = fontMetrics.getStringBounds(demotext, graphics);
                final Rectangle rect = rect2D.getBounds();
                graphics.drawRect(rect.x + textStartXPos, rect.y + baseLinePos, rect.width, rect.height);

                // X-Offset für 3. Zeichen berechnen
                int startPosX = 0;
                for (int i = 0; i < 3; i++)
                    startPosX += fontMetrics.charWidth(demotext.charAt(i));

                // Bounding Box für Zeichen 3 bis 7
                final Rectangle2D innerRect2D = fontMetrics.getStringBounds(demotext, 3, 7, graphics);
                final Rectangle innerRect = innerRect2D.getBounds();
                graphics.setColor(Color.ORANGE);
                graphics.drawRect(innerRect.x + textStartXPos + startPosX, innerRect.y + baseLinePos, innerRect.width,
                                innerRect.height);
            }
        };

        frame.add(fontMetricsComponent);
        frame.setSize(575, 170);
        frame.setVisible(true);
    }
    
    private FontMetricsExample() 
    {        
    }
}
