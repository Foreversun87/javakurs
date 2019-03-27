package ch06_collections.basics;

import java.util.Collection;

/**
 * Beispielprogramm zur Demonstration einer gr��enbeschr�nkten HashMap 
 * mithilfe der Callback-Methode removeEldestEntry().
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class FixedSizeLinkedHashMapExample
{
    public static void main(final String[] args)
    {
        // Gr��enbeschr�nkung auf drei Elemente + JDK 7 Diamond Operator
        final int MAX_ELEMENT_COUNT = 3;
        final FixedSizeLinkedHashMap<String, Customer> fixedSizeMap = 
                                    new FixedSizeLinkedHashMap<>(MAX_ELEMENT_COUNT);

        // Initial bef�llen
        fixedSizeMap.put("Erster", new Customer("Erster", "Stuhr", 11));
        fixedSizeMap.put("Zweiter", new Customer("Zweiter", "Hamburg", 22));
        fixedSizeMap.put("M. Inden", new Customer("Inden", "Aachen", 39));
        printCustomerList("Initial", fixedSizeMap.values());

        // �nderungen durchf�hren und ausgeben
        fixedSizeMap.put("New1", new Customer("New_1", "London", 44));
        printCustomerList("After insertion of 'New_1'", fixedSizeMap.values());

        fixedSizeMap.put("New2", new Customer("New_2", "San Francisco", 55));
        printCustomerList("After insertion of 'New_2'", fixedSizeMap.values());
    }

    private static void printCustomerList(final String title, final Collection<Customer> customers)
    {
        System.out.println(title);
        customers.forEach(System.out::println);
    }

    private FixedSizeLinkedHashMapExample()
    {
    }
}
