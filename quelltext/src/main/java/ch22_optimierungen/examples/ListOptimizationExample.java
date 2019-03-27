package ch22_optimierungen.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * Simple Aufzählung zur Modellierung des Typs von Listen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
enum ListType
{
    ArrayList, LinkedList
}

/**
 * Beispielprogramm zur Demonstration verschiedener Optimierungstechniken
 * <br>
 * Ausgangsbasis bildet diese Klasse, die eine Tabelle mit 50.000 Eintrï¿½gen
 * darstellt, die in einer LinkedList verwaltet werden.
 * Die Darstellung erfolgt mit dem SimpleImageTableCellRenderer.
 * Dort werden die Bilder immer neu geladen.
 *
 * @author Michael Inden
 *
 * Copyright 2011, 2014 by Michael Inden
 */
public final class ListOptimizationExample extends JFrame
{
    private final PersonTableModel personTableModel;
    private final JTable           personTable;

    public ListOptimizationExample(final int personCount,
                                   final ListType listType,
                                   final TableCellRenderer cellRenderer)
    {
        setTitle("ListOptimizationExample Persons: " + personCount + " / Using: "
           + listType + " / Renderer: " + cellRenderer.getClass().getSimpleName());

        personTableModel = new PersonTableModel(listType, personCount);
        personTable = new JTable(personTableModel);
        personTable.setRowHeight(64);
        personTable.setDefaultRenderer(ImageIcon.class, cellRenderer);

        getContentPane().add(new JScrollPane(personTable));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(final String[] args)
    {
        final JFrame demoframe = new ListOptimizationExample(50_000,
                       ListType.LinkedList, new SimpleImageTableCellRenderer());

        demoframe.setSize(700, 500);
        demoframe.setVisible(true);
    }

    private static class PersonTableModel extends AbstractTableModel
    {
        private final List<Person> persons;

        public PersonTableModel(final ListType listType, final int personCount)
        {
            persons = createPersonList(listType);

            for (int i = 0; i < personCount; i++)
            {
                final Person newPerson = createExamplePerson(i);
                persons.add(newPerson);
            }
            fireTableDataChanged();
        }

        private static List<Person> createPersonList(final ListType listType)
        {
            if (listType == ListType.ArrayList)
                return new ArrayList<>();

            if (listType == ListType.LinkedList)
                return new LinkedList<>();

            throw new IllegalStateException("Unexpected list type");
        }

        private static Person createExamplePerson(final int index)
        {
            Gender gender = Gender.MALE;
            if (index % 2 == 0)
                gender = Gender.FEMALE;

            return new Person("Person " + index, gender, index);
        }

        public int getRowCount()
        {
            return persons.size();
        }

        public int getColumnCount()
        {
            return 7;
        }

        public Object getValueAt(int rowIndex, int columnIndex)
        {
            final Person person = persons.get(rowIndex);

            if (columnIndex == 0)
                return person.getName();

            if (columnIndex == 1)
                return person.getGender();

            // always return "" => Images
            return "";
        }

        @Override
        public Class<?> getColumnClass(int columnIndex)
        {
            if (columnIndex == 1)
                return Gender.class;

            if (columnIndex >= 2)
            {
                return ImageIcon.class;
            }

            return String.class;
        }
    }
}
