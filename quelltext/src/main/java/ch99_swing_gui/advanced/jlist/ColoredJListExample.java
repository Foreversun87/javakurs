package ch99_swing_gui.advanced.jlist;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Beispielklasse für eine Liste mit farbig dargestellten Namen
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class ColoredJListExample
{
    private static final String[] NAMES = { "Alex", "Andi", "Andy", "Bernd", "Clemens", "Merten", "Michael", "Peter", "Rudolf" };

    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("ColoredJListExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JList<String> list = new JList<>(new StringListModel(NAMES));
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        list.setCellRenderer(new ColorListCellRenderer());

        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
