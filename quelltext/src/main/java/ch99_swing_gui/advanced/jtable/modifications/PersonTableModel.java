package ch99_swing_gui.advanced.jtable.modifications;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ch99_swing_gui.advanced.common.Gender;

/**
 * Beispielklasse für ein AbstractTableModel, das eine ListE von Personen
 * als Daten hält.
 * <br>
 * Hinweis:
 * Hier nochmal komplett ausimplementiert, da wir eine andere Klasse "Person" als Basis nutzen.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public class PersonTableModel extends AbstractTableModel
{
    private static final String[] COLUMN_NAMES = { "Firstname", "Name", "Gender", "Vegetarian?" };
    private static final Class<?>[] COLUMN_CLASSES = { String.class, String.class, Gender.class, Boolean.class };

    private static final int COLUMN_IDX_FIRSTNAME = 0;
    private static final int COLUMN_IDX_NAME = 1;
    private static final int COLUMN_IDX_GENDER = 2;
    private static final int COLUMN_IDX_IS_VEGETARIAN = 3;

    private final List<Person> persons;

    public PersonTableModel(final List<Person> persons) 
    {
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
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        final Person person = persons.get(rowIndex);

        if (columnIndex == COLUMN_IDX_FIRSTNAME)
            return person.getFirstname();
        if (columnIndex == COLUMN_IDX_NAME)
            return person.getLastname();
        if (columnIndex == COLUMN_IDX_GENDER)
            return person.getGender();
        if (columnIndex == COLUMN_IDX_IS_VEGETARIAN)
            return person.isVegetarian();

        throw new IllegalArgumentException("Invalid columIndex " + columnIndex);
    }

    @Override
    public String getColumnName(final int column)
    {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(final int columnIndex)
    {
        return COLUMN_CLASSES[columnIndex];
    }

    // Neu

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return columnIndex >= COLUMN_IDX_NAME;
    }

    @Override
    public void setValueAt(final Object value, final int rowIndex, final int columnIndex)
    {
        final Person person = persons.get(rowIndex);

        if (columnIndex == COLUMN_IDX_NAME)
            person.setLastname((String) value);
        else if (columnIndex == COLUMN_IDX_GENDER)
            person.setGender((Gender) value);
        else if (columnIndex == COLUMN_IDX_IS_VEGETARIAN)
            person.setVegetarian((Boolean) value);

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    protected List<Person> getModifiablePersons()
    {
        return persons;
    }
}
