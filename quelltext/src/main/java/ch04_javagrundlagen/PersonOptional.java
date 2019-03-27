package ch04_javagrundlagen;

import java.util.Date;
import java.util.Objects;

/**
 * Beispielklasse zur Demonstration der Implementierung von equals()
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class PersonOptional
{
    private final String       name;
    private final Date         birthday;
    private final String       city;
    private String             street;      // Optional => null-Wert erlaubt  
    private String             zipcode;     // Optional => null-Wert erlaubt  

    public PersonOptional(final String name, final Date birthday, final String city,
                  // $\mbox{\bfseries Optional }$
                  final String street, final String zipcode)
    {
        if (name == null || birthday == null || city == null)
            throw new IllegalArgumentException("parameters 'name', 'birthday'" +
                                               " and 'city' must not be null!");

        this.name = name;
        this.birthday = birthday;
        this.city = city;

        this.street = street;
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(final Object other)
    {
        if (other == null)
            return false;

        if (this == other)
            return true;

        if (this.getClass() != other.getClass())
            return false;

        final PersonOptional otherPerson = (PersonOptional) other;
        return compareAttributes(otherPerson);
    }

private boolean compareAttributes(final PersonOptional otherPerson)
{
   return getName().equals(otherPerson.getName()) &&
          getCity().equals(otherPerson.getCity()) &&
          getBirthday().equals(otherPerson.getBirthday()) &&		
       // $\mbox{\bfseries korrigierte Behandlung optionaler Attribute }$
       (getStreet() == otherPerson.getStreet() || 
       (getStreet() != null && getStreet().equals(otherPerson.getStreet()))) &&
       (getZipCode() == otherPerson.getZipCode() || 
       (getZipCode() != null && getZipCode().equals(otherPerson.getZipCode())));
}  

    public final String getName()       { return name; }
    public final Date   getBirthday()   { return birthday; }
    public final String getStreet()     { return street; }
    public final String getZipCode()    { return zipcode; }
    public final String getCity()       { return city; }


    @Override
    public String toString()
    {
        final StringBuilder buf = new StringBuilder();

        buf.append("Person: ");

        buf.append("Name='");
        buf.append(getName());
        buf.append("' ");
        buf.append("City='");
        buf.append(getCity());
        buf.append("' ");
        buf.append("Birthday='");
        buf.append(getBirthday());
        buf.append("'");

        return buf.toString();
    }  
    
    // Vermeide FindBugs Warning, obwohl diese Klasse niemals in Hash-Container verwendet wird
    @Override
    public int hashCode()
    {
    	return Objects.hash(this.name, this.birthday, this.city);
    } 
}