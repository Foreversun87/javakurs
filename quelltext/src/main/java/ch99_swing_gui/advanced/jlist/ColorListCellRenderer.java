package ch99_swing_gui.advanced.jlist;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 * Beispielklasse zur Demonstration der farbigen Einfärbung von textuellen Listen-Einträgen
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class ColorListCellRenderer extends DefaultListCellRenderer
{
    @Override
    public Component getListCellRendererComponent(final JList<?> list, final Object value, final int index, 
                                                  final boolean isSelected, final boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        final String name = value.toString();

        Color color = Color.black;
        if (name.startsWith("A"))
            color = Color.red;
        else if (name.startsWith("M"))
            color = Color.blue;                

        setForeground(color);

        return this;
    }
}
