package ch99_swing_gui.advanced.jtable;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import ch99_swing_gui.advanced.common.DataDefinitions;
import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration von eigenen Renderern für Spalten.
 * Hier wird gezeigt, dass die Auswahl entscheidened von der Implementierung des 
 * Modells abhängt:
 * Es wird der Renderer nicht korrekt gewählt, wenn alle Spalten laut
 * AbstractTableModel.getColumnClass(int) noch den Typ Object besitzen.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class JTableGenderRendererExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JTableGenderRendererExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Datenmodell
        final List<Person> persons = DataDefinitions.famousJavaPersons;

        // GUI-Datenmodell
        final TableModel tableModel = new PersonTableModel(persons);
        final JTable table = new JTable(tableModel);

        initColumnWidths(table);
        table.setDefaultRenderer(Gender.class, new GenderTableCellRenderer());

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setSize(500, 150);
        frame.setVisible(true);
    }

    private static void initColumnWidths(final JTable table)
    {
        final TableColumnModel tableColumnModel = table.getColumnModel();

        tableColumnModel.getColumn(0).setPreferredWidth(150);
        tableColumnModel.getColumn(1).setPreferredWidth(200);
        tableColumnModel.getColumn(2).setPreferredWidth(75);
    }

    // Dieses Modell verdeutlicht das Problem, wenn alle Spalten laut
    // AbstractTableModel.getColumnClass(int) noch den Typ Object besitzen
    public static class PersonTableModel extends AbstractTableModel
    {
        private static final String[] COLUMN_NAMES = { "Firstname", "Name", "Gender" };

        private final List<Person> persons;

        public PersonTableModel(final List<Person> persons) {
            // eigentlich wird eine tiefe Kopie benï¿½tigt, um Read-only zu sein
            this.persons = new ArrayList<>(persons);
        }

        @Override
        public int getRowCount()
        {
            return persons.size();
        }

        @Override
        public int getColumnCount()
        {
            return COLUMN_NAMES.length;
        }

        @Override
        public Object getValueAt(final int rowIndex, final int columnIndex)
        {
            final Person person = persons.get(rowIndex);

            if (columnIndex == 0)
                return person.getFirstname();
            else if (columnIndex == 1)
                return person.getLastname();
            else if (columnIndex == 2)
                return person.getGender();

            throw new IllegalArgumentException("Invalid columIndex " + columnIndex);
        }

        @Override
        public String getColumnName(final int columnIndex)
        {
            return COLUMN_NAMES[columnIndex];
        }
    }
}
