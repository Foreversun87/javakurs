package ch99_swing_gui.advanced.jtable.modifications;

import java.util.ArrayList;
import java.util.List;

import ch99_swing_gui.advanced.common.Gender;

/**
 * Dieses Klasse stellt einige Demo-Daten f�r Listen und Tabellen bereit.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class DataDefinitions
{
    public static final List<Person> famousJavaPersons = new ArrayList<>();
    static
    {
        famousJavaPersons.add(new Person("Joshua", "Bloch", Gender.MALE));
        famousJavaPersons.add(new Person("Neil", "Gafter", Gender.MALE));
        famousJavaPersons.add(new Person("James", "Gosling", Gender.MALE));
        famousJavaPersons.add(new Person("Bart", "Bates", Gender.MALE, true));
        famousJavaPersons.add(new Person("Kathy", "Sierra", Gender.FEMALE, true));
        famousJavaPersons.add(new Person("Angelika", "Langer", Gender.FEMALE));
    }
}
