package ch99_swing_gui.advanced.jtree;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import ch99_swing_gui.advanced.common.TreeStructure;

/**
 * Beispielklasse zur Demonstration verschiedener Arten von Änderungen in einem JTree
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class JTreeModificationExample
{
    public static void main(final String[] args) throws Exception
    {
        final JFrame frame = new JFrame("JTreeModificationExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final MutableTreeNode rootNode = TreeStructure.createExampleTreeStructure();
        final TreeModel model = new DefaultTreeModel(rootNode);
        final JTree tree = new JTree(model);

        model.addTreeModelListener(new SimpleTreeModelModificationReporter());

        final JLabel infoLabel = new JLabel("No selection!");
        tree.addTreeSelectionListener(new SimpleTreeSelectionListener(infoLabel));

        frame.add(new JScrollPane(tree), BorderLayout.CENTER);
        frame.add(infoLabel, BorderLayout.SOUTH);

        frame.setSize(400, 200);
        frame.setVisible(true);

        // Achtung hier außerhalb des EDT !!!
        sleepAndShowInfo("Adding a two nodes in 'First' -- using repaint()");

        // Wir wissen, dass der Baum aus DefaultMutableTreeNodes besteht
        final DefaultMutableTreeNode firstChild = (DefaultMutableTreeNode) rootNode.getChildAt(0);
        final DefaultMutableTreeNode secondChild = (DefaultMutableTreeNode) rootNode.getChildAt(1);
        final DefaultMutableTreeNode thirdChild = (DefaultMutableTreeNode) rootNode.getChildAt(2);

        // Versuch 1: Einfï¿½gen an der TreeNode, dabei zwei Varianten mï¿½glich
        firstChild.add(new DefaultMutableTreeNode("1.1"));
        firstChild.insert(new DefaultMutableTreeNode("1.2"), 1);
        // Repaint forcieren => bei JTree werden Änderungen sichtbar!
        frame.repaint();

        sleepAndShowInfo("Adding a third node in 'First' -- using reload");

        // Versuch 1b
        firstChild.add(new DefaultMutableTreeNode("1.3"));
        // wichtig zu wissen, welches Modell
        final DefaultTreeModel defaultModel = (DefaultTreeModel) tree.getModel();
        defaultModel.reload(firstChild);
        // Programmatisch aufklappen
        tree.expandPath(TreeUtils.getTreePath(firstChild));

        sleepAndShowInfo("Adding two nodes in 'Third'");

        // Veruch 2: EinfÜgen im Modell
        defaultModel.insertNodeInto(new DefaultMutableTreeNode("3.1"), thirdChild, 0);
        defaultModel.insertNodeInto(new DefaultMutableTreeNode("3.2"), thirdChild, 1);

        sleepAndShowInfo("Removing 'Second'");

        defaultModel.removeNodeFromParent(secondChild);

        sleepAndShowInfo("Changing 'First' -> 'Changed First'");

        // Inhaltliche Änderung eines Knotens
        firstChild.setUserObject("Changed First"); // keine Auswirkung im Modell
        frame.repaint();

        sleepAndShowInfo("Changing 'Changed First' -> 'Changed First 2'");

        final TreePath treePath = TreeUtils.getTreePath(firstChild);
        model.valueForPathChanged(treePath, "Changed First 2");
    }

    private static void sleepAndShowInfo(final String info) throws InterruptedException
    {
        Thread.sleep(3000);
        System.out.println(info);
        Thread.sleep(2000);
    }

    public static class SimpleTreeSelectionListener implements TreeSelectionListener
    {
        private final JLabel infoLabel;

        public SimpleTreeSelectionListener(final JLabel infoLabel) {
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
}
