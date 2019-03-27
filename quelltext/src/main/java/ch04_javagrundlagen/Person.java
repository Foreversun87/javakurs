package ch04_javagrundlagen;

import java.util.Date;
import java.util.Objects;

/**
 * Beispielklasse zur Demonstration der Implementierung von equals()
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class Person
{
    private final String name;
    private final Date birthday;
    private final String city;

    public Person(final String name, final Date birthday, final String city)
    {
    	// Hilfsklasse Objects neu in JDK 7
    	Objects.requireNonNull(name, "parameter 'name' must not be null!");
    	Objects.requireNonNull(birthday, "parameter 'birthday' must not be null!");
    	Objects.requireNonNull(city, "parameter 'city' must not be null!");
        
        this.name = name;
        this.birthday = birthday;
        this.city = city;
    }

    public final String getName()       { return name; }
    public final Date   getBirthday()   { return birthday; }
    public final String getCity()       { return city; }
   
       
    public boolean equals(Object other)
    {
        if (other == null)          // null safe
            return false;
            
        if (this == other)          // reflexive
            return true;
            
        if (this.getClass() != other.getClass())   // same type ?
            return false;      
        
        final Person otherPerson = (Person)other;
        return compareAttributes(otherPerson);
    }
    
    private boolean compareAttributes(final Person otherPerson)
    {
        return this.getName().equals(otherPerson.getName()) &&                
               this.getBirthday().equals(otherPerson.getBirthday()) &&
               this.getCity().equals(otherPerson.getCity());           
    }      
    
    public final int getAge()
    {
        final Date now = new Date();

        final int monthNow = now.getMonth();
        final int monthBirthDay = birthday.getMonth();
        final int dayNow = now.getDate();
        final int dayBirthDay = birthday.getDate();

        final int correction;
        if (monthNow > monthBirthDay || 
           (monthNow == monthBirthDay && dayNow >= dayBirthDay))
        {
            correction = 0; // keine Korrektur, wenn Monat und Tag erreicht  
        }
        else
        {
            correction = -1;
        }

        return now.getYear() - birthday.getYear() + correction;
    }
    
    // Vermeide FindBugs Warning, obwohl diese Klasse niemals in Hash-Container verwendet wird
    @Override
    public int hashCode()
    {
    	return Objects.hash(this.name, this.birthday, this.city);
    } 

}