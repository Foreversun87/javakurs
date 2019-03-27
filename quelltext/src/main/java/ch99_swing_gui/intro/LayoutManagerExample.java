package ch99_swing_gui.intro;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Dieses Programm erlaubt es, verschiedene Layoutmanager über eine Combobox auszuwählen.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public class LayoutManagerExample
{
    public static final LayoutManager[] layoutManagers = { new BorderLayout(), new FlowLayout(), 
                                                           new GridLayout(2, 3), new CardLayout() };

    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("LayoutManagerExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JPanel layoutPanel = new JPanel();
        frame.add(layoutPanel, BorderLayout.CENTER);

        final JComboBox<LayoutManager> layoutCombo = new JComboBox<>(layoutManagers);
        // Wichtig, weil sonst niemals bei der initialen Selektion der Code
        // von itemStateChanged aufgerufen wird
        layoutCombo.setSelectedIndex(-1);

        layoutCombo.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(final ItemEvent event)
            {
                if (event.getStateChange() == ItemEvent.SELECTED)
                {
                    final LayoutManager selectedLayoutManager = (LayoutManager) event.getItem();
                    layoutPanel.setLayout(selectedLayoutManager);
                    addButtons(layoutPanel);
                    layoutPanel.revalidate();
                    // ohne repaint wird nur der Bereich neu gezeichnet,
                    // der automatisch von Verï¿½nderungen als betroffen gilt
                    frame.repaint();
                }
            }
        });

        frame.add(layoutCombo, BorderLayout.SOUTH);
        layoutCombo.setSelectedIndex(0);

        frame.setSize(350, 200);
        frame.setVisible(true);
    }

    public static void addButtons(final JComponent parentComponent)
    {
        parentComponent.removeAll();
        parentComponent.add(new JButton("North"), BorderLayout.NORTH);
        parentComponent.add(new JButton("South"), BorderLayout.SOUTH);
        parentComponent.add(new JButton("Center"), BorderLayout.CENTER);
        parentComponent.add(new JButton("East"), BorderLayout.EAST);
        parentComponent.add(new JButton("West"), BorderLayout.WEST);
    }
}
