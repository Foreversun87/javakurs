package ch99_swing_gui.advanced.jlist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import ch09_multithreading.intro.SleepUtils;
import ch99_swing_gui.advanced.common.DataDefinitions;
import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration verschiedener Arten von Änderungen in einer JList
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class JListModificationExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JListModificationExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final List<Person> persons = DataDefinitions.famousJavaPersons;
        final DynamicListModel<Person> listModel = new DynamicListModel<>(persons);
        listModel.addListDataListener(new SimpleListModelModificationReporter());

        final JList<Person> list = new JList<>(listModel);
        list.setCellRenderer(new PersonGenderListCellRenderer());

        final JButton refreshButton = new JButton("Refresh");
        initRefreshListener(refreshButton, persons, listModel);
        frame.add(refreshButton, BorderLayout.NORTH);

        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        final JButton addEntryButton = new JButton("Add Entry");
        initAddEntryListener(addEntryButton, list, listModel);
        frame.add(addEntryButton, BorderLayout.SOUTH);

        frame.setSize(400, 200);
        frame.setVisible(true);

        // Inhaltsänderung parallel zum GUI: Also NICHT im EDT 
        System.out.println("Changing Joshua Blochs name");
        persons.get(0).setLastname("Bloch -- The Java Guru");
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                listModel.rowContentsChanged(0, 0);
            }
        });

        // Änderungen der Ausgangsdaten parallel zum GUI: Also NICHT im EDT  
        for (int i = 0; i < 20; i++)
        {
            persons.add(new Person("New ", "Entry " + i, Gender.MALE));
            SleepUtils.safeSleep(2000);
        }
    }

    private static void initRefreshListener(final JButton refreshButton, final List<Person> persons,
                    final DynamicListModel<Person> listModel)
    {
        refreshButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent event)
            {
                System.out.println("Refresh: Resetting business model content");
                listModel.setNewContent(persons);
            }
        });
    }

    private static void initAddEntryListener(final JButton addEntryButton, final JList<Person> list,
                    final DynamicListModel<Person> listModel)
    {
        addEntryButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent event)
            {
                System.out.println("Adding new entry");
                listModel.addEntry(new Person("Misses", "Test", Gender.FEMALE));
                // Neues Element sichtbar machen, evtl. selektieren:
                // list.setSelectedIndex(listModel.getSize()-1);
                list.ensureIndexIsVisible(listModel.getSize() - 1);
            }
        });
    }
}
