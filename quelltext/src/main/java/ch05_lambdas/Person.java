package ch05_lambdas;

/**
 * Diese Klasse modelliert eine Person auf simple Weise.
 * Dient für viele Beispiele als Grundlage. 
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class Person
{
    private final String name;

    private final int    age;

    private final Gender gender;

    public Person(final String name, final int age)
    {
        this(name, age, Gender.MALE);
    }

    public Person(final String name, final int age, final Gender gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public Gender getGender()
    {
        return gender;
    }

    public boolean isAdult()
    {
        return age >= 18;
    }

    @Override
    public String toString()
    {
        return "Person [name = " + name + " / age = " + age + " / gender = " + gender + "]";
    }
}