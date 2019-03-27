package ch99_swing_gui.advanced.jtable.modifications;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.jlist.GenderListCellRenderer;
import ch99_swing_gui.advanced.jtable.ContainsFilter;
import ch99_swing_gui.advanced.jtable.GenderTableCellRenderer;

/**
 * Beispielklasse zur Demonstration verschiedener Arten von Änderungen in einer JTable
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class JTableModificationExample
{
    public static void main(final String[] args) throws Exception
    {
        final JFrame frame = new JFrame("JTableModificationExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final List<Person> persons = DataDefinitions.famousJavaPersons;
        final DynamicPersonTableModel tableModel = new DynamicPersonTableModel(persons);
        tableModel.addTableModelListener(new SimpleTableModelModificationReporter());

        final JTable table = new JTable(tableModel);

        initColumnWidths(table);
        table.setDefaultRenderer(Gender.class, new GenderTableCellRenderer());

        // ComboBox mit zwei Einträgen füllen
        final JComboBox<Gender> genderCombos = new JComboBox<>(Gender.values());
        genderCombos.setRenderer(new GenderListCellRenderer());

        // Editor fÜr den Typ Gender.class registrieren (auf Doppelklick)
        final DefaultCellEditor genderEditor = new DefaultCellEditor(genderCombos);
        genderEditor.setClickCountToStart(2);
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

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                System.out.println("Inserting Mister X");
                tableModel.addEntry(new Person("Mister", "X", Gender.MALE));
            }
        });

        Thread.sleep(5000);

        final List<Person> otherFamousPersons = new ArrayList<>();
        otherFamousPersons.add(new Person("Gilad", "Braha", Gender.MALE));
        otherFamousPersons.add(new Person("Brian", "Goetz", Gender.MALE));
        otherFamousPersons.add(new Person("Doug", "Lea", Gender.MALE));

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                System.out.println("Changing gui model");
                tableModel.setNewContent(otherFamousPersons);
            }
        });

        Thread.sleep(5000);

        System.out.println("Back to the original famousJavaPersons model");
        SwingUtilities.invokeAndWait(new Runnable()
        {
            public void run()
            {
                // Spaltenbreiten und -anordnungen usw. gehen verloren
                final DynamicPersonTableModel newTableModel = new DynamicPersonTableModel(DataDefinitions.famousJavaPersons);
                newTableModel.addTableModelListener(new SimpleTableModelModificationReporter());

                // so werden nur 3 Zeilen angezeigt, nï¿½mlich die ersten drei =>
                // das liegt am Sorter !!!
                table.setModel(newTableModel);

                // der muss aktualisiert werden!
                rowsorter.setModel(newTableModel);

                newTableModel.addEntry(new Person("Mr", "Exception", Gender.MALE));
            }
        });

        Thread.sleep(5000);
    }

    private static void initColumnWidths(final JTable table)
    {
        final TableColumnModel tableColumnModel = table.getColumnModel();

        tableColumnModel.getColumn(0).setPreferredWidth(150);
        tableColumnModel.getColumn(1).setPreferredWidth(200);
        tableColumnModel.getColumn(2).setPreferredWidth(100);
        tableColumnModel.getColumn(3).setPreferredWidth(75);
    }
}
