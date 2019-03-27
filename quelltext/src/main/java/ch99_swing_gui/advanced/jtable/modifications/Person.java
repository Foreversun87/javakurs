package ch99_swing_gui.advanced.jtable.modifications;

import ch99_swing_gui.advanced.common.Gender;

// Info: Immutable-Klassen machen das Leben mit Swing-Datenmodellen
// um einiges einfacher, da man dann nur noch die Zusammensetzung
// nicht aber einzelne Datenänderungen von Attributen üerwachen muss
class Person
{
    private final String firstname;
    private String lastname;
    private Gender gender;
    private boolean isVegetarian = false; // explizit klarstellen, was der Default ist

    public Person(final String firstname, final String lastname, final Gender gender) {
        this(firstname, lastname, gender, false);
    }

    public Person(final String firstname, final String lastname, final Gender gender, final boolean isVegetarian) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.isVegetarian = isVegetarian;
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

    public boolean isVegetarian()
    {
        return isVegetarian;
    }

    public void setVegetarian(final boolean isVegetarian)
    {
        this.isVegetarian = isVegetarian;
    }
    
    @Override
    public String toString()
    {
        return "Person [firstname=" + firstname + ", lastname=" + lastname + ", gender="
                + gender + ", isVegetarian=" + isVegetarian + "]";
    }
}