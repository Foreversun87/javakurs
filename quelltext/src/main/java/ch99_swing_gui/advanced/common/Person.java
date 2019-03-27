package ch99_swing_gui.advanced.common;

/**
 * Diese Klasse modelliert definiert eine Person mit drei Attributen.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 * 
 * Anmerkung: Immutable-Klassen machen das Leben mit Swing-Datenmodellen
 * um einiges einfacher, da man dann nur noch die Zusammensetzung
 * nicht aber einzelne Datenänderungen von Attributen überwachen muss.
 * Hier mutable, da in einigen Beispielen Änderungen vorgenommen werden.
 */
public final class Person
{
    private final String firstname;
    private String lastname;
    private Gender gender;

    public Person(final String firstname, final String lastname, final Gender gender) 
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(final String lastname)
    {
        this.lastname = lastname;
    }
    
    public Gender getGender()
    {
        return gender;
    }
    
    public void setGender(final Gender gender)
    {
        this.gender = gender;
    }
}