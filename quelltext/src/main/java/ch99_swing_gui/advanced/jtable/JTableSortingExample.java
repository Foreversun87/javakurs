package ch99_swing_gui.advanced.jtable;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import ch99_swing_gui.advanced.common.DataDefinitions;
import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration der Sortierfunktionalitïät aus dem JDK 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JTableSortingExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JTableSortingExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Datenmodell
        final List<Person> persons = DataDefinitions.famousJavaPersons;

        // GUI-Datenmodell
        final TableModel tableModel = new PersonTableModel(persons);
        final JTable table = new JTable(tableModel);

        initColumnWidths(table);
        table.setDefaultRenderer(Gender.class, new GenderTableCellRenderer());
        table.setAutoCreateRowSorter(true);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setSize(500, 230);
        frame.setVisible(true);
    }

    private static void initColumnWidths(final JTable table)
    {
        final TableColumnModel tableColumnModel = table.getColumnModel();

        tableColumnModel.getColumn(0).setPreferredWidth(150);
        tableColumnModel.getColumn(1).setPreferredWidth(200);
        tableColumnModel.getColumn(2).setPreferredWidth(75);
    }
}
