package ch99_swing_gui.advanced.jtable.modifications;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.jlist.GenderListCellRenderer;
import ch99_swing_gui.advanced.jtable.ContainsFilter;
import ch99_swing_gui.advanced.jtable.GenderTableCellRenderer;

/**
 * Beispielklasse zur Demonstration der Editierbarkeit einzelner Tabellenzellen.
 * <br>
 * Hier lÄsst sich nun auch die Spalte mit dem Geschlecht editieren (JComboBox-Editor).
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012, 2014 by Michael Inden 
 */
public final class JTableEditingExampleImproved
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JTableEditingExampleImproved");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final List<Person> persons = DataDefinitions.famousJavaPersons;
        final TableModel tableModel = new PersonTableModel(persons);
        final JTable table = new JTable(tableModel);

        initColumnWidths(table);
        table.setDefaultRenderer(Gender.class, new GenderTableCellRenderer());

        // JComboBox mit zwei EintrÄgen fÜllen  
        final JComboBox<Gender> genderComboBox = new JComboBox<>(Gender.values());
        genderComboBox.setRenderer(new GenderListCellRenderer());

        // Editor basierend auf Combobox erstellen (auf Doppelklick)  
        final DefaultCellEditor genderEditor = new DefaultCellEditor(genderComboBox);
        genderEditor.setClickCountToStart(2);

        // Editor fÜr den Typ Gender.class registrieren 
        table.setDefaultEditor(Gender.class, genderEditor);

        final TableRowSorter<TableModel> rowsorter = new TableRowSorter<>(table.getModel());
        final ContainsFilter rowfilter = new ContainsFilter("");
        rowsorter.setRowFilter(rowfilter);
        table.setRowSorter(rowsorter);

        final JTextField filterTextField = new JTextField();
        filterTextField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent event)
            {
                rowfilter.setFilterValue(filterTextField.getText());
                rowsorter.sort();
            }
        });

        frame.add(filterTextField, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setSize(550, 300);
        frame.setVisible(true);
    }

    private static void initColumnWidths(final JTable table)
    {
        final TableColumnModel tableColumnModel = table.getColumnModel();

        tableColumnModel.getColumn(0).setPreferredWidth(150);
        tableColumnModel.getColumn(1).setPreferredWidth(200);
        tableColumnModel.getColumn(2).setPreferredWidth(100);
        tableColumnModel.getColumn(3).setPreferredWidth(100);
    }
}
