package ch99_swing_gui.advanced.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Dieses Klasse stellt einige Demo-Daten für Listen und Tabellen bereit.
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
        famousJavaPersons.add(new Person("Bart", "Bates", Gender.MALE));
        famousJavaPersons.add(new Person("Kathy", "Sierra", Gender.FEMALE));
        famousJavaPersons.add(new Person("Angelika", "Langer", Gender.FEMALE));
    }
    
    private DataDefinitions()
    {        
    }
}
