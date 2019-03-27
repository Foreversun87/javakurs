package ch99_swing_gui.advanced.jlist;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Beispielklasse zur Demonstration von Namen in einer JList
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class JListExample
{
    private static final String[] NAMES = { "Alex", "Andi", "Andy", "Bernd", "Clemens", "Merten", "Michael", "Peter", "Rudolf" };

    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JListExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // JDK 7: JList ist typisiert + Diamond Operator  
        // JList mit Datenmodell StringListModel erzeugen 
        final JList<String> list = new JList<>(new StringListModel(NAMES));
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
