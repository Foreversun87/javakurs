package ch99_swing_gui.advanced.jlist;

import java.util.Arrays;

import javax.swing.AbstractListModel;

/**
 * Beispielklasse zur Demonstration eines einfachen Listenmodells für Strings
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class StringListModel extends AbstractListModel<String>
{
    private final String[] values;
    
    public StringListModel(final String[] inputData)
    {
        this.values = Arrays.copyOf(inputData, inputData.length);
    }
    
    @Override
    public int getSize()
    {
        return values.length;
    }

    @Override
    public String getElementAt(final int index)
    {
        return values[index];
    }
}