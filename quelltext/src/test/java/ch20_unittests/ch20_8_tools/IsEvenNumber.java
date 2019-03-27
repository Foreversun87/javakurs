package ch20_unittests.ch20_8_tools;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Beispielimplementierung eines Hamcrest-Matchers für gerade Zahlen  
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class IsEvenNumber extends TypeSafeMatcher<Integer>
{
    @Override
    public boolean matchesSafely(final Integer number)
    {
        return number.intValue() % 2 == 0;
    }

    public void describeTo(final Description description)
    {
        description.appendText("even number");
    }

    @Factory
    public static Matcher<Integer> evenNumber()
    {
        return new IsEvenNumber();
    }
}
