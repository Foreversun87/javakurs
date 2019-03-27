package ch99_swing_gui.advanced.jtable;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ch99_swing_gui.advanced.common.DataDefinitions;
import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration der Sortierfunktionalität aus dem JDK.
 * Hier mit Einstellung einer initalen Sortierreihenfolge.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JTableInitialSortingExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JTableInitialSortingExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final List<Person> persons = DataDefinitions.famousJavaPersons;
        final TableModel tableModel = new PersonTableModel(persons);
        final JTable table = new JTable(tableModel);

        initColumnWidths(table);
        table.setDefaultRenderer(Gender.class, new GenderTableCellRenderer());
        table.setAutoCreateRowSorter(true);

        final TableRowSorter<TableModel> tableRowSorter = (TableRowSorter<TableModel>) table.getRowSorter();

        // Absteigende Sortierung der Spalte gender
        final RowSorter.SortKey genderDescending = new RowSorter.SortKey(2, SortOrder.DESCENDING);
        tableRowSorter.setSortKeys(Collections.singletonList(genderDescending));

        // Sortierung der Spalte gender aufsteigend, firstname aufsteigend
        final List<RowSorter.SortKey> genderAndFirstname = new ArrayList<>();
        genderAndFirstname.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        genderAndFirstname.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        tableRowSorter.setSortKeys(genderAndFirstname);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setSize(500, 270);
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
