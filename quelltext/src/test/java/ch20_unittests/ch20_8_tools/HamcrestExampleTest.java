package ch20_unittests.ch20_8_tools;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testklasse, die unseren eigenen IsEvenMatcher nutzt
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class HamcrestExampleTest 
{
	@Test
    public void testAgeJUnit()
    {
        final Person mike = new Person("Mike", 38, "Aachen");
        assertTrue(mike.age > 30 && mike.age % 2 != 0);
    }
	
	@Test
    public void testAgeHamcreat()
    {
        final Person mike = new Person("Mike", 38, "Aachen");
        assertThat(mike.age, allOf(greaterThan(30),  not(IsEvenNumber.evenNumber())));
    }
    	
	@Test
    public void testAgeJUnitWithComment()
    {
        final Person mike = new Person("Mike", 38, "Aachen");
        assertTrue("age > 30 and odd", mike.age > 30 && mike.age % 2 != 0);
    }
    
	@Test
    public void testAgeHamcreatWithComment()
    {
        final Person mike = new Person("Mike", 38, "Aachen");
        assertThat("age > 30 and odd", mike.age, allOf(greaterThan(30), not(IsEvenNumber.evenNumber())));
    }   
}