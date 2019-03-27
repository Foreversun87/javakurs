package ch20_unittests.ch20_4_junit_rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Unit-Tests zur Demonstration der JUnit Rule TestName
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class NameRuleTest 
{
    @Rule 
    public TestName name = new TestName();

    @Test 
    public void testMethod() 
    {
        assertEquals("testMethod", name.getMethodName());
    }
}
