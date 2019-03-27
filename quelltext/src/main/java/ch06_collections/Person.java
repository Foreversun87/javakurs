package ch06_collections;

import java.util.Objects;

/**
 * Diese Klasse modelliert eine Person auf simple Weise.
 * Dient für viele Beispiele als Grundlage. 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class Person implements Comparable<Person>
{
    private final String name;

    private final String city;

    private final int    age;

    public Person(final String name, final String city, final int age)
    {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.city = Objects.requireNonNull(city, "city must not be null");
        this.age = age;
    }

    public final String getName()
    {
        return name;
    }

    public final String getCity()
    {
        return city;
    }

    public final int getAge()
    {
        return age;
    }

    public String toString()
    {
        final StringBuffer buf = new StringBuffer();

        buf.append("Person: ");

        buf.append("Name='");
        buf.append(getName());
        buf.append("' ");
        buf.append("City='");
        buf.append(getCity());
        buf.append("' ");
        buf.append("Age='");
        buf.append(getAge());
        buf.append("'");

        return buf.toString();
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        final Person other = (Person) obj;
        return name.equals(other.name) && city.equals(other.city) && age == other.age;
    }

    @Override
    public int compareTo(final Person otherPerson)
    {
        int ret = getName().compareTo(otherPerson.getName());

        if (ret == 0)
        {
            ret = getCity().compareTo(otherPerson.getCity());
        }

        if (ret == 0)
        {
            // JDK 7: neue Funktionalität: Integer.compare(int, int)
            ret = Integer.compare(getAge(), otherPerson.getAge());
        }

        return ret;
    }
}