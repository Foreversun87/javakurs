package ch99_swing_gui.advanced.jtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * Utility-Klasse für JTree, hier nur mit minimaler Path-Funktionalität
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class TreeUtils
{
    public static TreePath getTreePath(final TreeNode treeNode)
    {
        final List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(treeNode);
        
        TreeNode parentNode = treeNode.getParent();
        while (parentNode != null)
        {
            treeNodes.add(parentNode);
            parentNode = parentNode.getParent();
        }
        
        Collections.reverse(treeNodes);
        
        // Nimmt ein Object[] entgegen! 
        return new TreePath(treeNodes.toArray());
    }
}
