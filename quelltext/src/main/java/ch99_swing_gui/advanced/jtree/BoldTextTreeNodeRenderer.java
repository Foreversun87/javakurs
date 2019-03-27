package ch99_swing_gui.advanced.jtree;

import java.awt.Component;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;

/**
 * Beispielklasse zur Demonstration eines Renderers zur speziellen (fetten) Darstellung 
 * von Nicht-Blatt-Knoten in einem JTree
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class BoldTextTreeNodeRenderer extends DefaultTreeCellRenderer
{
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, 
                             final Object value, final boolean isSelected, 
                             final boolean isExpanded, final boolean isLeaf,
                             final int row, final boolean hasFocus)
    {
        super.getTreeCellRendererComponent(tree, value, isSelected, isExpanded, isLeaf,
                row, hasFocus);

        // Für unser Modell gültig, da es DefaultMutableTreeNode's nutzt
        if (value instanceof DefaultMutableTreeNode)
        {
            final DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

            setMetaAttributes(tree, node);
        }

        return this;
    }

    private void setMetaAttributes(final JTree tree, final DefaultMutableTreeNode node)
    {
        final int childCount = node.getChildCount();
        if (childCount > 0)
        {
            setFont(getFont().deriveFont(Font.BOLD, 14));
            setText(getText() + " (" + childCount + "; " + 
                                       getTotalChildCount(node) + ")");                
        }
        else
        {
            setFont(tree.getFont());
        }
    }


    public static int getTotalChildCount(final DefaultMutableTreeNode parentNode)
    {
        if (parentNode.getChildCount() == 0)
            return 0;

        int count = 0;

        final Enumeration nodeEnumeration = parentNode.breadthFirstEnumeration();
        while (nodeEnumeration.hasMoreElements())
        {
            final TreeNode node = (TreeNode) nodeEnumeration.nextElement();
            System.out.println(node);
            count++;
        }

        // Enumeration nimmt auch immer die eigene TreeNode mit!
        return count - 1;
    }
}