package ch99_swing_gui.advanced.jtree;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import ch99_swing_gui.advanced.common.TreeStructure;

/**
 * Beispielklasse zur Demonstration von Pfaden in Bäumen und der Klasse TreePath
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class JTreeTreePathExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JTreeTreePathExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final MutableTreeNode rootNode = TreeStructure.createExampleTreeStructure();
        final TreeModel treeModel = new DefaultTreeModel(rootNode);
        final JTree tree = new JTree(treeModel);

        frame.add(new JScrollPane(tree), BorderLayout.CENTER);

        // Root => Knoten 2 => Knoten 2.2
        final TreePath treePath = TreeUtils.getTreePath(rootNode.getChildAt(1).getChildAt(1));
        System.out.println("TreePath: " + treePath);

        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
