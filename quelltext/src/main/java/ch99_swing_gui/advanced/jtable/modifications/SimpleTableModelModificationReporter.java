package ch99_swing_gui.advanced.jtable.modifications;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * Beispielklasse fÜR einen TableModelListener, der Änderungen auf der
 * Konsole protokolliert.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class SimpleTableModelModificationReporter implements TableModelListener
{
    @Override
    public void tableChanged(final TableModelEvent event)
    {
        System.out.println("tableChanged(TableModelEvent)" + toString(event));
    }

    public String toString(final TableModelEvent event)
    {
        final String rows = "first row: " + event.getFirstRow() + " / " + "last row: " + event.getLastRow();

        final String column = "column: " + event.getColumn();
        final String type = "type: " + typeToString(event.getType());

        return event.getClass().getCanonicalName() + "[" + rows + ", " + column + ", " + type + "]";
    }

    public String typeToString(final int type)
    {
        switch (type)
        {
        case TableModelEvent.DELETE:
            return "DELETE";
        case TableModelEvent.INSERT:
            return "INSERT";
        case TableModelEvent.UPDATE:
            return "UPDATE";
        }
        return "Unknown";
    }
}