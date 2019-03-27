package ch05_lambdas;

import java.util.function.Predicate;

import ch07_bulk_operations.Person;

/**
 * Beispielprogramm zur Demonstration der Formulierung einfacher Bedingungen mit Prädikaten.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstPredicatesExample 
{
	public static void main(final String[] args)
	{
		// Prädikate formulieren
		final Predicate<String> isNull = str -> str == null;
		final Predicate<String> isEmpty = String::isEmpty;
		final Predicate<Person> isAdult = person -> person.getAge() >= 18;
	
		System.out.println("isNull(''):     " + isNull.test(""));
		System.out.println("isEmpty(''):    " + isEmpty.test(""));
		System.out.println("isEmpty('Pia'): " + isEmpty.test("Pia"));
		System.out.println("isAdult(Pia):   " + isAdult.test(new Person("Pia", 55)));
	}
}