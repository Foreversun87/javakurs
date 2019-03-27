package ch99_swing_gui.advanced.jlist;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JList;

import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.common.GenderFemaleIcon;
import ch99_swing_gui.advanced.common.GenderMaleIcon;
import ch99_swing_gui.advanced.common.Person;

/**
 * Beispielklasse zur Demonstration eines Renderers für Personen in einer JList <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class PersonGenderListCellRenderer extends DefaultListCellRenderer
{
    private final Icon maleIcon = new GenderMaleIcon();
    private final Icon femaleIcon = new GenderFemaleIcon();

    @Override
    public Component getListCellRendererComponent(final JList<?> list, final Object value, final int index, 
                                                  final boolean isSelected, final boolean cellHasFocus)
    {

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        final Person person = (Person) value;
        setText(person.getLastname() + ", " + person.getFirstname());

        if (person.getGender() == Gender.MALE)
            setIcon(maleIcon);
        if (person.getGender() == Gender.FEMALE)
            setIcon(femaleIcon);

        return this;
    }
}