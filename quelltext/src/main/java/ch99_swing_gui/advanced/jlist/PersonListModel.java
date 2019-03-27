package ch99_swing_gui.advanced.jlist;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration eines einfachen Listenmodells für Personen
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
class PersonListModel extends AbstractListModel<Person>
{
    private final List<Person> persons;

    public PersonListModel(final List<Person> persons) 
    {
        // Vorsicht mit herein gereichten Referenzen auf extern verwaltete Daten 
        this.persons = new ArrayList<>(persons);
    }

    @Override
    public int getSize()
    {
        return persons.size();
    }

    @Override
    public Person getElementAt(final int index)
    {
        return persons.get(index);
    }
}