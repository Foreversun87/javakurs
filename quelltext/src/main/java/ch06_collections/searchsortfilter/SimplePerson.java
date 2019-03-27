package ch06_collections.searchsortfilter;

import java.util.Objects;

/**
 * Beispielklasse zur Demonstration einzelner Filterkriterien
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class SimplePerson
{
    private final String name;     
    private final int age;         
    
    public SimplePerson(final String name, final int age)
    {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.age = age;
    }

	@Override
    public String toString()
    {
        return "SimplePerson [age=" + age + ", name=" + name + "]";
    }
	    
    public String getName() 
    {
		return name;
	}

	public int getAge() 
	{
		return age;
	}
}