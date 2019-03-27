package ch99_swing_gui.advanced.jtable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse für ein AbstractTableModel, das eine List von Personen
 * als Daten hält.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class PersonTableModel extends AbstractTableModel
{
    private static final String[] COLUMN_NAMES = { "Firstname", "Name", "Gender" };

    private static final Class<?>[] COLUMN_CLASSES = { String.class, String.class, Gender.class };

    private final List<Person> persons;

    public PersonTableModel(final List<Person> persons) 
    {
        // eigentlich wird eine tiefe Kopie benöigt, um Read-only zu sein
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

    @Override
    public Class<?> getColumnClass(final int columnIndex)
    {
        return COLUMN_CLASSES[columnIndex];
    }
}
