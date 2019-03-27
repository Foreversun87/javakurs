package ch10_advancedjava.serializable;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import ch04_javagrundlagen.basics.EqualsUtils;

/**
 * Beispielklasse zur Modellierung einer Person
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class Person implements Serializable
{
    private final String name;
    private final String city;
    private final Date   birthday;
    
    public Person(final String name, final String city, final Date birthday)
    {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.city = Objects.requireNonNull(city, "city must not be null");
        this.birthday = Objects.requireNonNull(birthday, "birthday must not be null");
    }

    @Override
    public String toString()
    {
        return "Person: [name=" + name + ", city=" + city + ", birthday=" + birthday + "]" + " / " + super.toString();
    }

    // ...

    public final String getName()
    {
        return name;
    }

    public final String getCity()
    {
        return city;
    }

    public final Date getBirthday()
    {
        return birthday;
    }

    public boolean equals(final Object other)
    {
        if (other == null) // null safe
            return false;

        if (this == other) // reflexive
            return true;

        if (this.getClass() != other.getClass())
            return false;

        final Person otherPerson = (Person) other;
        return equalsImpl(otherPerson);
    }

    private boolean equalsImpl(final Person otherPerson)
    {
        return EqualsUtils.nullSafeEquals(this.getName(), otherPerson.getName())
               && EqualsUtils.nullSafeEquals(this.getCity(), otherPerson.getCity())
               && EqualsUtils.nullSafeEquals(this.getBirthday(), otherPerson.getBirthday());
    }
    
    // Vermeide FindBugs Warning, obwohl diese Klasse niemals in Hash-Container verwendet wird
    @Override
    public int hashCode()
    {
    	return Objects.hash(this.name, this.birthday, this.city);
    } 
}