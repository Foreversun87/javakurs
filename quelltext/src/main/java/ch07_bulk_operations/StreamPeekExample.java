package ch07_bulk_operations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Beispielprogamm zeigt die Methode peek() zur Inspektion von Verarbeitungsschritten.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class StreamPeekExample
{
    public static void main(final String[] args)
    {
        final List<Person> persons = createDemoData();

        System.out.println("Protokollierung jedes einzelnen Schritts");
        final Stream<Person> stream = persons.stream();

        final Stream<String> allMikes = stream.peek(System.out::println).filter(Person::isAdult)
                        .peek(System.out::println).map(Person::getName).peek(System.out::println)
                        .filter(name -> name.startsWith("Mi")).peek(System.out::println).map(String::toUpperCase);

        // Löst die Verarbeitung aus  
        System.out.println("Filter for 'Mi':");
        allMikes.forEach(System.out::println);
    }

    private static List<Person> createDemoData()
    {
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Michael", 43));
        persons.add(new Person("Max", 5));
        persons.add(new Person("Moritz", 7));
        persons.add(new Person("Merten", 38));
        persons.add(new Person("Micha", 42));
        return persons;
    }
}
