package ch99_swing_gui.advanced.common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

/**
 * Diese Klasse definiert ein Piktogramm für das weibliche Geschlecht.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class GenderFemaleIcon implements Icon
{   
    public void paintIcon(final Component c, final Graphics g, final int x, final int y)
    {
        final Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));

        // um relativ zu 0,0 malen zu kï¿½nnen
        g2d.translate(x, y);

        g2d.setColor(Color.BLACK);

        // beide Figuren haben eine Kreis als Grundform
        final Shape circle = new Ellipse2D.Float(9, 5, 14, 14);
        g2d.draw(circle);

        // female: Kreis mit Kreuz nach unten
        g2d.setColor(Color.RED);
        g2d.drawLine(16, 20, 16, 29);
        g2d.drawLine(12, 25, 20, 25);

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