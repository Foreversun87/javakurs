package ch99_swing_gui.advanced.jlist;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Beispielklasse zur Demonstration der Befüllung von Listen-Modellem
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class JListModelExample
{
    private static final String[] NAMES = { "Alex", "Andi", "Andy", "Bernd", "Clemens", "Merten", "Michael", "Peter", "Rudolf" };

    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JListModelExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Neu in JDK 7: typisierte JList und Diamond Operator
        final JList<String> list = new JList<>(new StringListModel(NAMES));

        // JList mit DefaultListModel aufwendig in der Konstruktion/Befï¿½llung
        final DefaultListModel<String> listModel = new DefaultListModel<>();
        for (final String name : NAMES)
            listModel.addElement(name);

        final JList<String> otherList = new JList<>();
        // Alternative: Modell per setModel() setzen
        otherList.setModel(listModel);

        // Integration der JList in eine JScrollPane
        frame.add(new JScrollPane(list), BorderLayout.CENTER);
        frame.add(new JScrollPane(otherList), BorderLayout.EAST);

        frame.setSize(400, 150);
        frame.setVisible(true);
    }
}
