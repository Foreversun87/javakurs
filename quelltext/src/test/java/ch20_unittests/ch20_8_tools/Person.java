package ch20_unittests.ch20_8_tools;

/**
 * Beispielimplementierung einer Personen-Klasse zur Demonstartion von Hamcrest-Tests.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
class Person
{
    final String name;
    final int    age;
    final String city;

    public Person(final String name, final int age, final String city)
    {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	@Override
    public boolean equals(Object other)
    {
        if (other == null) // null safe
            return false;

        if (this == other) // reflexive
            return true;

        if (!(other instanceof Person)) // compare only objects of same type
            return false;

        final Person otherPerson = (Person) other;
        return equalsImpl(otherPerson);
    }

    private boolean equalsImpl(final Person otherPerson)
    {
        return nullSafeEquals(this.name, otherPerson.name) && this.age == otherPerson.age && nullSafeEquals(this.city, otherPerson.city);
    }

    private static boolean nullSafeEquals(final Object o1, final Object o2)
    {
        return (o1 == o2) || (o1 != null && o1.equals(o2));
    }
}