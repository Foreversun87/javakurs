package ch06_collections.searchsortfilter;

/**
 * Diese Klasse modelliert eine person auf simple Weise.
 * Dient für viele Beispiele als Grundlage. 
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class Person
{
    private final String name;

    private final int    age;

    private final Gender gender;

    private String       city;
    
    private String       favoriteColor;

    public Person(final String name, final int age)
    {
        this(name, age, Gender.MALE);
    }

    public Person(final String name, final int age, final Gender gender)
    {
        this(name, age, gender, "n/a");
    }

    public Person(final String name, final int age,  final String city)
    {
        this(name, age, Gender.MALE, city);
    }
    
    public Person(final String name, final int age, final Gender gender, final String city)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
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

    public String getCity()
    {
        return city;
    }
    
    public String getFavoriteColor()
    {
        return favoriteColor;
    }
    
    public boolean isAdult()
    {
        return age >= 18;
    }

    @Override
    public String toString()
    {
        return "Person [name = " + name + " / age = " + age + " / gender = " + gender + " / city = " + city + "]";
    }
}