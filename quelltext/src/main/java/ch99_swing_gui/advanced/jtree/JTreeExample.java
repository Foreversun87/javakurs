package ch99_swing_gui.advanced.jtree;

import static ch99_swing_gui.advanced.common.TreeStructure.createExampleTreeStructure;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;

/**
 * Beispielklasse zur Demonstration eines Baums mit einem JTree
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class JTreeExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JTreeExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Erzeugen der Baumstruktur, des Modells und des Bedienelements
        final MutableTreeNode rootNode = createExampleTreeStructure();
        final TreeModel treeModel = new DefaultTreeModel(rootNode);
        final JTree tree = new JTree(treeModel);

        frame.add(new JScrollPane(tree), BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
