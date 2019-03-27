package ch20_unittests.ch20_8_tools;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

/**
 * Unit-Tests zur Demonstration der lesbaren Vergleiche von Attributen mit Hamcrest
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class SimplePersonAttributesTest 
{
	@Test
	public void testAttribuitesWithEquals() 
	{
		final Person mike = new Person("Mike", 38, "Aachen");
		
		assertThat("age", mike.getAge(), equalTo(38));
		assertThat("city", mike.getCity(), equalTo("Zürich"));
	}
}
