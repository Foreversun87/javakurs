package ch99_swing_gui.advanced.jtable.modifications;

import java.util.List;

/**
 * Beispielklasse zur Demonstration eines PersonTableModel, dass es erlaubt, Einträge hinzuzufügen
 * und den Inhalt komplett zu tauschen.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class DynamicPersonTableModel extends PersonTableModel
{
    public DynamicPersonTableModel(final List<Person> persons) 
    {
        super(persons);
    }

    // Veräderlichkeit von Einträgen und des gesamten Inhalts
    public void addEntry(final Person newPerson)
    {
        getModifiablePersons().add(newPerson);
        fireTableRowsInserted(getModifiablePersons().size()-1, getModifiablePersons().size()-1);
    }
    
    public void setNewContent(final List<Person> newPersons)
    {
        getModifiablePersons().clear();
        getModifiablePersons().addAll(newPersons);       
        fireTableDataChanged();
    }
}
