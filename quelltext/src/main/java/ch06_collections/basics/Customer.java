package ch06_collections.basics;

/**
 * Beispielklasse zur Demonstration einzelner Map-Funktionalitäten
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
final class Customer
{
    private String name;
    private String city;
    private int    age;
    
    Customer(final String name, final String city, final int age)
    {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Customer [name=" + name + ", city=" + city + ", age=" + age + "]";
    }
}