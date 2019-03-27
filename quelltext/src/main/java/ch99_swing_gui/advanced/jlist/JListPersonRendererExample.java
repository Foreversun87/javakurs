package ch99_swing_gui.advanced.jlist;

import static ch99_swing_gui.advanced.common.DataDefinitions.famousJavaPersons;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration eines Renderers für Personen in einer JList 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JListPersonRendererExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JListPersonRendererExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final ListModel<Person> listModel = new PersonListModel(famousJavaPersons);
        final JList<Person> list = new JList<>(listModel);
        list.setCellRenderer(new PersonGenderListCellRenderer());

        frame.add(new JScrollPane(list), BorderLayout.CENTER);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}