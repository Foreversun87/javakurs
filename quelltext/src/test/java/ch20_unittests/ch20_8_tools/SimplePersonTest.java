package ch20_unittests.ch20_8_tools;

import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

/**
 * Unit-Tests zur Demonstration der lesbaren Ausgaben mit Hamcrest
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class SimplePersonTest 
{
	@Test 
	public void testEquals() 
	{
		final Person mike = new Person("Mike", 38, "Aachen");
		final Person otherPerson = new Person("Mike", 38, "Aachen");

		assertThat(mike, equalTo(otherPerson));
	}
}
