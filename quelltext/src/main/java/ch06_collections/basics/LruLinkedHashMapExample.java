package ch06_collections.basics;

import java.util.Collection;

/**
 * Beispielprogramm zur Demonstration einer größenbeschränkten HashMap mithilfe der 
 * Callback-Methode removeEldestEntry(), die das älteste Element basierend auf der 
 * Zugriffsreihenfolge bestimmt.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class LruLinkedHashMapExample
{
    public static void main(final String[] args)
    {
        // Größenbeschränkung auf vier Elemente + JDK 7 Diamond Operator
        final int MAX_ELEMENT_COUNT = 4;
        final LruLinkedHashMap<String, Customer> lruMap = new LruLinkedHashMap<>(MAX_ELEMENT_COUNT);

        lruMap.put("A. Mustermann", new Customer("A. Mustermann", "Stuhr", 16));
        lruMap.put("B. Mustermann", new Customer("B. Mustermann", "Hamburg", 32));
        lruMap.put("C. Mustermann", new Customer("C. Mustermann", "Zürich", 64));
        lruMap.put("M. Inden", new Customer("M. Inden", "Kiel", 32));
        printCustomerList("Initial", lruMap.values());

        // Zugriff auf alle bis auf M. Inden           
        lruMap.get("A. Mustermann");
        lruMap.get("B. Mustermann");
        lruMap.get("C. Mustermann");

        // Neuer Eintrag sollte M. Inden ersetzen           
        lruMap.put("Dummy", new Customer("D. Dummy", "Oldenburg", 128));
        printCustomerList("Nach Zugriffen", lruMap.values());
    }

    private static void printCustomerList(final String title, final Collection<Customer> customers)
    {
        System.out.println(title);
        for (final Customer customer : customers)
            System.out.println(customer);
    }
}
