package ch04_javagrundlagen.basics;

import java.util.Date;
import java.util.Objects;

/**
 * Beispielprogramm zur Demonstration von Ausgaben mit toString()
 * <br>
 * Verbesserungen der Stringausgabe für Person-Objekte
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class PersonToStringExample
{
    public static void main(final String[] args)
    {
        final Person tom = new Person("Tom", new Date(), "Hamburg");
        System.out.println(tom);
        // System.out.println(tom.toStringWithStringBuilder());
    }
    
    private PersonToStringExample()
    {
    }
    
    private static class Person
    {
        private final String name;
        private final Date   birthday;
        private final String city;

        public Person(final String name, final Date birthday, final String city)
        {
            if ( name == null || birthday == null || city == null)
            {
            	// Hilfsklasse Objects neu in JDK 7
            	Objects.requireNonNull(name, "parameter 'name' must not be null!");
            	Objects.requireNonNull(city, "parameter 'city' must not be null!");
            	Objects.requireNonNull(city, "parameter 'city' must not be null!");
            }
            
            this.name = name;
            this.birthday = birthday;
            this.city = city;
        }

        public final String getName()
        {
            return name;
        }

        public final Date getBirthday()
        {
            return birthday;
        }

        public final String getCity()
        {
            return city;
        }
     

        @Override
        public String toString()
        {
            return "Person: " + 
                   "Name='" + getName() + "' " +		 // Variante 1
                   "Birthday=<" + getBirthday() + "> " + // Variante 2
            	   "City=\"" + getCity() + "\"";         // Variante 3                 
        }

        public String toStringWithStringBuilder()
        {
            final StringBuilder sb = new StringBuilder();

            sb.append(getClass().getSimpleName()).append(": ");
            sb.append("Name='").append(getName()).append("' ");
            sb.append("Birthday='").append(getBirthday()).append("' ");
            sb.append("City='").append(getCity()).append("' ");            

            return sb.toString();
        }
    }
}