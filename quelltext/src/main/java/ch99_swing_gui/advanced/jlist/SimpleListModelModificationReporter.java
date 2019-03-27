package ch99_swing_gui.advanced.jlist;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Beispielklasse für einen ListDataListener, der Änderungen auf der
 * Konsole protokolliert.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class SimpleListModelModificationReporter implements ListDataListener
{
    @Override
    public void intervalAdded(final ListDataEvent event)
    {
        System.out.println("intervalAdded(ListDataEvent)\n" + event +"\n");
    }

    @Override
    public void intervalRemoved(final ListDataEvent event)
    {
        System.out.println("intervalRemoved(ListDataEvent)\n" + event +"\n");
    }

    @Override
    public void contentsChanged(final ListDataEvent event)
    {
        System.out.println("contentsChanged(ListDataEvent)\n" + event +"\n");
    }
}