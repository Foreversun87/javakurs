package ch99_swing_gui.advanced.jtree;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

/**
 * Beispielklasse für einen TreeModelListener, der Änderungen auf der
 * Konsole protokolliert.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class SimpleTreeModelModificationReporter implements TreeModelListener
{
    @Override
    public void treeNodesChanged(final TreeModelEvent e)
    {
        System.out.println("treeNodesChanged(TreeModelEvent)");        
    }

    @Override
    public void treeNodesInserted(final TreeModelEvent e)
    {
        System.out.println("treeNodesInserted(TreeModelEvent)");
    }

    @Override
    public void treeNodesRemoved(final TreeModelEvent e)
    {
        System.out.println("treeNodesRemoved(TreeModelEvent)");
    }

    @Override
    public void treeStructureChanged(final TreeModelEvent e)
    {
        System.out.println("treeStructureChanged(TreeModelEvent)");
    }
}