package ch99_swing_gui.advanced.jlist;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

/**
 * Beispielklasse zur Demonstration eines AbstractListModel, dass es erlaubt, Einträge hinzuzufügen
 * und den Inhalt komplett zu tauschen.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class DynamicListModel<E> extends AbstractListModel<E>
{
    private final List<E> entries;

    public DynamicListModel(final List<E> entries) 
    {
        // Vorsicht mit hereingereichten Referenzen auf extern verwaltete Daten
        this.entries = new ArrayList<>(entries);
    }

    @Override
    public int getSize()
    {
        return entries.size();
    }

    @Override
    public E getElementAt(final int index)
    {
        return entries.get(index);
    }

    public void addEntry(final E newEntry)
    {
        entries.add(newEntry);
        // Darstellungs- und Bedienfehler ohne folgende Zeile
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    }

    public void setNewContent(final List<E> newEntries)
    {
        entries.clear();
        entries.addAll(newEntries);
        // Darstellungs- und Bedienfehler ohne folgende Zeile
        fireContentsChanged(this, 0, getSize() - 1);
    }

    public void rowContentsChanged(final int startIndex, final int endIndex)
    {
        fireContentsChanged(this, startIndex, endIndex);
    }
}