package ch99_swing_gui.advanced.jlist;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration einer JList mit Person-Objekten 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JListPersonExample
{
    private static final Person[] PERSONS = { new Person("Andi", "Nachname", Gender.MALE), 
                                              new Person("Mike", "Inden", Gender.MALE),
                                              new Person("Kathy", "Sierra", Gender.FEMALE) };

    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JListPersonExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JList<Person> list = new JList<>(PERSONS);
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        frame.setSize(400, 100);
        frame.setVisible(true);
    }
}
