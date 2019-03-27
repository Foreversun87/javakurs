package ch99_swing_gui.advanced.jlist;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Beispielklasse zur Demonstration der Auswahl aus einer JList mit 
 * EDT-konformer Anzeige des Ergebnisses 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JListSelectionImprovedExample
{
    private static final String[] NAMES = { "Alex", "Andi", "Andy", "Bernd", "Clemens", "Merten", "Michael", "Peter", "Rudolf" };

    public static void main(final String[] args)
    {
        // JFrame als Fenster und als Container für Bedienelemente erzeugen
        final JFrame frame = new JFrame("JListEDTExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JList<String> list = new JList<>(new StringListModel(NAMES));
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        list.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(final ListSelectionEvent e)
            {
                if (!e.getValueIsAdjusting())
                {
                    @SuppressWarnings("unchecked")
                    final JList<String> list = ((JList<String>) e.getSource());

                    // JDK 7
                    final List<String> selectedValues = list.getSelectedValuesList();
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        public void run()
                        {
                            JOptionPane.showMessageDialog(null, "Folgende Einträge gewählt: " + selectedValues);
                        }
                    });
                }
            }
        });
        list.setCellRenderer(new ColorListCellRenderer());

        // Größe festlegen und sichtbar machen
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
