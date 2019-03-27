package ch99_swing_gui.advanced.common;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 * Dieses Klasse stellt einige Demo-Daten bereit.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class TreeStructure
{
    public static MutableTreeNode createExampleTreeStructure()
    {
        // Wurzelknoten erstellen 
        final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");

        // Knoten für erste Ebene erstellen  
        final MutableTreeNode firstChild = new DefaultMutableTreeNode("First");
        final MutableTreeNode secondChild = new DefaultMutableTreeNode("Second");
        final MutableTreeNode thirdChild = new DefaultMutableTreeNode("Third");
        
        // Erste Ebene mit Wurzelknoten verbinden -- DefaultMutableTreeNode.add()  
        rootNode.add(firstChild);
        rootNode.add(secondChild);
        rootNode.add(thirdChild);
        
        // Zweite Ebene erstellen und einfügen -- MutableTreeNode.insert()  
        secondChild.insert(new DefaultMutableTreeNode("2.1"), 0);
        secondChild.insert(new DefaultMutableTreeNode("2.2"), 1);

        return rootNode;
    }
    
    private TreeStructure()
    {        
    }
}
