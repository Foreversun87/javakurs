package ch99_swing_gui.advanced.jtree;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;

import ch99_swing_gui.advanced.common.TreeStructure;

/**
 * Beispielklasse zur Demonstration von Selektionen in Bäumen
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public class JTreeSelectionExample
{
    public static void main(final String[] args)
    {    
        final JFrame frame = new JFrame("JTreeSelectionExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final MutableTreeNode rootNode = TreeStructure.createExampleTreeStructure();
        final TreeModel treeModel = new DefaultTreeModel(rootNode);
        final JTree tree = new JTree(treeModel);

        final JLabel infoLabel = new JLabel("No selection!");
        tree.addTreeSelectionListener(new SimpleTreeSelectionListener(infoLabel));
        
        frame.add(new JScrollPane(tree), BorderLayout.CENTER);
        frame.add(infoLabel, BorderLayout.SOUTH);

        frame.setSize(450, 150);
        frame.setVisible(true);
    }
}
