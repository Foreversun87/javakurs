package ch05_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Beispielprogramm zur Demonstration von komplexeren Bedingungen mit Pr�dikaten.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class ComplexPredicatesExample 
{
	public static void main(final String[] args)
	{
	    final List<Person> persons = new ArrayList<>();
	    persons.add(new Person("Michael", 44));
	    persons.add(new Person("Barbara", 22, Gender.FEMALE));
	    persons.add(new Person("Lili", 17, Gender.FEMALE));
	    persons.add(new Person("Tom", 8));
		
		// Einfache Pr�dikate formulieren
		final Predicate<Person> isAdult = person -> person.getAge() >= 18;
		final Predicate<Person> isMale = person -> person.getGender() == Gender.MALE;
	
		// Negation einzelner Pr�dikate
		final Predicate<Person> isYoung = isAdult.negate();
		final Predicate<Person> isFemale = isMale.negate();
		
		// Kombination von Pr�dikaten mit AND
		final Predicate<Person> boys = isMale.and(isYoung);
		final Predicate<Person> women = isFemale.and(isAdult);
		
		// Kombination von Pr�dikaten mit OR
		final Predicate<Person> boysOrWomen = boys.or(women);
		
		persons.removeIf(boysOrWomen);
		System.out.println(persons);
	}
}