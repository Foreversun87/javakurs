package ch99_swing_gui.advanced.common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

import javax.swing.Icon;

/**
 * Diese Klasse definiert ein Piktogramm ür das männliche Geschlecht: 
 * Kreis mit Pfeil rechts hoch 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class GenderMaleIcon implements Icon
{
    public void paintIcon(final Component c, final Graphics g, final int x, final int y)
    {
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setStroke(new BasicStroke(2));

        // Verschiebe das Koordinatensystem, um die Figur relativ zu 0,0 malen zu können
        g2d.translate(x, y);

        // Schwarzer Kreis
        g2d.setColor(Color.BLACK);
        final Shape circle = new Ellipse2D.Float(9, 9, 14, 14);
        g2d.draw(circle);

        // Blauer Pfeil nach rechts oben
        g2d.setColor(Color.BLUE);
        final GeneralPath path = new GeneralPath();
        path.moveTo(22f, 11f);
        path.lineTo(29f, 4f);
        path.lineTo(22f, 4f);
        path.moveTo(29f, 4f);
        path.lineTo(29f, 11f);
        g2d.draw(path);

        g2d.translate(-x, -y);
    }

    public int getIconWidth()
    {
        return 32;
    }

    public int getIconHeight()
    {
        return 32;
    }
}