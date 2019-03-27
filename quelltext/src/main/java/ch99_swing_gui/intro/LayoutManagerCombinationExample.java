package ch99_swing_gui.intro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;

/**
 * In diesem Beispiel werden verschiedene Bedienelemente in einem JFrame durch verschiedene
 * Erzeugungsmethdoden erzeugt und anschließend platziert.
 * platziert.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public class LayoutManagerCombinationExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("LayoutManagerCombinationExample");

        // Das Hauptfenster wird in drei Bereiche unterteilt 
        frame.add(createToolBarPanel(), BorderLayout.NORTH);
        frame.add(createCenterPanel(), BorderLayout.CENTER);
        frame.add(createStatusBarPanel(), BorderLayout.SOUTH);

        frame.setSize(600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private static JPanel createToolBarPanel()
    {
        // Zwei Toolbars erzeugen 
        final JToolBar zoomToolBar = new JToolBar();
        zoomToolBar.add(new JButton("+"));
        zoomToolBar.add(new JButton("-"));
        zoomToolBar.addSeparator();
        zoomToolBar.add(new JButton("100%"));

        final JToolBar skipToolBar = new JToolBar();
        skipToolBar.add(new JButton("|<-"));
        skipToolBar.add(new JButton("<<"));
        skipToolBar.add(new JButton(">>"));
        skipToolBar.add(new JButton("->|"));

        // Ausrichtung LEFT ist wichtig, da die Toolbars sonst mittig sind. 
        final JPanel toolbarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolbarPanel.add(zoomToolBar);
        toolbarPanel.add(skipToolBar);

        // JPanel fï¿½r Toolbar und Separator 
        final JPanel compoundPanel = new JPanel(new BorderLayout());
        compoundPanel.add(toolbarPanel, BorderLayout.NORTH);
        compoundPanel.add(new JSeparator(), BorderLayout.SOUTH);

        return compoundPanel;
    }

    private static JComponent createCenterPanel()
    {
        final JSplitPane splitPane = new JSplitPane();
        splitPane.setLeftComponent(new JScrollPane(new JTree()));

        // Tipp: nur mit JScrollPane wird Header gezeichnet
        final String[] headers = { "Vorname", "Name", "Alter" };
        final String[][] values = { { "Hans", "Meyer", "27" }, { "Hans", "Meyer", "28" },
                { "Hans", "Meyer", "29" }, { "Max", "Muster", "30" },
                { "Max", "Muster", "31" }, { "Max", "Muster", "32" } };
        final JScrollPane scrollPane = new JScrollPane(new JTable(values, headers));
        splitPane.setRightComponent(scrollPane);

        return splitPane;
    }

    private static JPanel createStatusBarPanel()
    {
        final JPanel statusbarPanel = new JPanel();
        statusbarPanel.setLayout(new BorderLayout());

        final JPanel leftPanel = new JPanel();
        final JPanel rightPanel = new JPanel();

        final JLabel info1 = new JLabel("Left aligned info");
        final JLabel info2 = new JLabel("Right aligned info");
        leftPanel.add(info1);
        rightPanel.add(info2);

        statusbarPanel.add(new JSeparator(), BorderLayout.NORTH);
        statusbarPanel.add(leftPanel, BorderLayout.WEST);
        statusbarPanel.add(rightPanel, BorderLayout.EAST);

        return statusbarPanel;
    }
}
