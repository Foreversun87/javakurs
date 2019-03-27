package ch06_collections.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch06_collections.Person;

/**
 * Beispielprogramm zur Demonstration des Interfaces Comparable.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class ComparableExample
{
    public static void main(String[] args)
    {
        // JDK 7: Diamond Operator
        final List<Person> customers = new ArrayList<>();

        customers.add(new Person("Müller", "Bremen", 27));
        customers.add(new Person("Müller", "Kiel", 37));
        customers.add(new Person("Meyer", "Oldenburg", 47));

        Collections.sort(customers);
        for (final Person currentPerson : customers)
            System.out.println(currentPerson);
    }
}