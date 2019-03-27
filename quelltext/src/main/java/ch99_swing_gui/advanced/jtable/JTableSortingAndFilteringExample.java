package ch99_swing_gui.advanced.jtable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ch99_swing_gui.advanced.common.DataDefinitions;
import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration sowohl der Sortier- als auch der Filter-Funktionalit�t aus dem JDK 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JTableSortingAndFilteringExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JTableSortingAndFilteringExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final List<Person> persons = DataDefinitions.famousJavaPersons;
        final TableModel tableModel = new PersonTableModel(persons);
        final JTable table = new JTable(tableModel);

        initColumnWidths(table);
        table.setDefaultRenderer(Gender.class, new GenderTableCellRenderer());

        // Sortierung und Filterung initialisieren
        final TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<>(table.getModel());

        final ContainsFilter containsFilter = new ContainsFilter("");
        tableRowSorter.setRowFilter(containsFilter);
        table.setRowSorter(tableRowSorter);

        // Filtereingabe
        final JTextField filterTextField = new JTextField();
        filterTextField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent event)
            {
                // Filterung basierend auf Eingabe ausf�hren
                containsFilter.setFilterValue(filterTextField.getText());
                tableRowSorter.sort();
            }
        });

        frame.add(filterTextField, BorderLayout.NORTH);
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
