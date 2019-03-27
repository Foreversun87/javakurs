package ch99_swing_gui.advanced.jtable;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import ch99_swing_gui.advanced.common.DataDefinitions;
import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration tabellarischer Personendaten mit einer JTable
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public class JTableExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("JTableExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final List<Person> persons = DataDefinitions.famousJavaPersons;
        final TableModel tableModel = new PersonTableModel(persons);
        final JTable table = new JTable(tableModel);
        
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setSize(500, 150);
        frame.setVisible(true);
    }
}
