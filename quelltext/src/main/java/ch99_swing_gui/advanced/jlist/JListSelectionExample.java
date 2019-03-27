package ch99_swing_gui.advanced.jlist;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Beispielklasse zur Demonstration der Auswahl aus einer JList mit 
 * NICHT EDT-konformer Anzeige des Ergebnisses, weil Dialog aus dem
 * EDT aufgerufen wird => Repaint-Probleme der Selektion möglich 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */

public final class JListSelectionExample
{
    private static final String[] NAMES = { "Alex", "Andi", "Andy", "Bernd", "Clemens", "Merten", "Michael", "Peter", "Rudolf" };

    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JListExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JList<String> list = new JList<>(new StringListModel(NAMES));
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        list.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(final ListSelectionEvent selectionEvent)
            {
                if (!selectionEvent.getValueIsAdjusting())
                {
                    @SuppressWarnings("unchecked")
                    final JList<String> list = ((JList<String>) selectionEvent.getSource());

                    // JDK 7: neu im JList-API: getSelectedValuesList()  
                    final List<String> selectedValues = list.getSelectedValuesList();
                    // Schachstelle: GUI-Aktion im EDT (siehe Text)
                    JOptionPane.showMessageDialog(null, "Folgende Einträge gewählt: " + selectedValues);
                }
            }
        });

        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
