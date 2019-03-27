package ch06_collections.searchsortfilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ch06_collections.Person;

/**
 * Beispielprogramm zur Demonstration des Einsatz des universellen, zusammengesetzten Komparators
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class PersonUniversalComparatorExample
{
    public static void main(final String[] args)
    {
        final List<Person> customers = createCustomerList();

        // Definition von Einzelkomparatoren 
        final Comparator<Person> ageComparator = new PersonAgeComparator();
        final Comparator<Person> nameComparator = new PersonNameComparator();

        // Definition zusammengesetzter Komparatoren 
        final Comparator<Person> ageAndNameComparator = 
        		                 new UniversalComparator<>(ageComparator, nameComparator);
        final Comparator<Person> nameAndAgeComparator = 
        		                 new UniversalComparator<>(nameComparator, ageComparator);

        // Einsatz der Komparatoren
        Collections.sort(customers, ageAndNameComparator);
        printCustomerList("Sorted by Age And Name:", customers);        
        System.out.println("-------------------------------------------------");        
        Collections.sort(customers, nameAndAgeComparator);
        printCustomerList("Sorted by Name And Age:", customers);
    }

	private static List<Person> createCustomerList() 
	{
		final List<Person> customers = new ArrayList<>();
        customers.add(new Person("Michael", "Stuhr", 43));
        customers.add(new Person("Tim", "Kiel", 33));
        customers.add(new Person("Tim", "Aachen", 43));
        customers.add(new Person("Michael", "Oldenburg", 55));
        customers.add(new Person("Lili", "Zürich", 37));
		return customers;
	}

    private static void printCustomerList(final String title, final List<Person> myCustomers)
    {
        System.out.println(title);
        for (final Person customer : myCustomers)
            System.out.println(customer);
    }
}