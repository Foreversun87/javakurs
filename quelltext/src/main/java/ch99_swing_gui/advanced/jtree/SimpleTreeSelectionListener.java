package ch99_swing_gui.advanced.jtree;

import javax.swing.JLabel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

/**
 * Beispielklasse für einen TreeSelectionListener, der Änderungen an der
 * Selektion in einem JLabel protokolliert.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class SimpleTreeSelectionListener implements TreeSelectionListener
{
    private final JLabel infoLabel;

    public SimpleTreeSelectionListener(final JLabel infoLabel)
    {
        this.infoLabel = infoLabel;
    }

    @Override
    public void valueChanged(final TreeSelectionEvent event)
    {
        final TreePath treePath = event.getPath();
        final Object pathComponent = treePath.getLastPathComponent();
        final String type = pathComponent.getClass().getSimpleName();

        infoLabel.setText("Path: " + treePath + " / Object: " + pathComponent + " / Type: " + type);
    }
}
