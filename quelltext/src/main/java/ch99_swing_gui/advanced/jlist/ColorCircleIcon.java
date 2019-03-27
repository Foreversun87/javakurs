package ch99_swing_gui.advanced.jlist;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * Beispielklasse für eine eigene Realisierung eines Icons
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class ColorCircleIcon implements Icon
{
    private final Color color;

    public ColorCircleIcon(final Color color)
    {
        this.color = color;
    }

    public int getIconHeight()
    {
        return 10;
    }

    public int getIconWidth()
    {
        return 10;
    }

    public void paintIcon(final Component c, final Graphics g, final int x, final int y)
    {
        g.setColor(color);
        g.fillOval(x, y, 10, 10);
    }
}