package ch99_swing_gui.intro;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Dieses Beispiel demonstiert die MouseListener-Funktionalität: Es wird auf einen
 * Doppelklick auf einen Listen-Eintrag gehorcht.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class MouseListenerExample
{
    private static final String[] NAMES = { "Alex", "Andi", "Andy", "Merten" };

    public static final void main(final String[] args)
    {
        final JFrame frame = new JFrame("MouseListenerExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // JDK 7: JList ist seit JDK 7 typisiert + Diamond Operator
        final JList<String> list = new JList<>(NAMES);
        frame.add(list, BorderLayout.CENTER);

        frame.setSize(400, 200);
        frame.setVisible(true);

        // MouseListener hinzufügen
        list.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(final MouseEvent event)
            {
                // Mindestens Doppelklick
                if (event.getClickCount() >= 2)
                {
                    final int index = list.locationToIndex(event.getPoint());
                    final String value = list.getSelectedValue();

                    JOptionPane.showMessageDialog(frame, "Details zu Eintrag " + index + ", selectedValue='" + value + "'");
                }
            }
        });
    }
}
