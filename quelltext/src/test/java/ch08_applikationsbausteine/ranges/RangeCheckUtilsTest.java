package ch08_applikationsbausteine.ranges;

import static ch08_applikationsbausteine.ranges.RangeCheckUtils.isValueInRange;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testklasse für die Klasse RangeCheckUtils, basierend auf JUnit 4
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class RangeCheckUtilsTest
{  
    @Test 
    public void testValueInRange_With_Borders()
    {
        assertTrue("7 in [2 .. 9]", isValueInRange(7, 2, 9));
        assertTrue("2 in [2 .. 9]", isValueInRange(2, 2, 9));
        assertTrue("9 in [2 .. 9]", isValueInRange(9, 2, 9));
    }

    @Test 
    public void testValueInRange_Value_Not_Included()
    {
        assertFalse("1 not in [2 .. 3]", isValueInRange(1, 2, 3));
        assertFalse("4 not in [2 .. 3]", isValueInRange(4, 2, 3));
    }
    
    @Test 
    public void testValueInRangeDouble_With_Borders()
    {
        assertTrue("7.2 in [7.1 .. 7.3]", isValueInRange(7.2, 7.1, 7.3));
        assertTrue("7.1 in [7.1 .. 7.3]", isValueInRange(7.1, 7.1, 7.3));
        assertTrue("7.3 in [7.1 .. 7.3]", isValueInRange(7.3, 7.2, 7.3));
    }
    
    @Test 
    public void testValueInRangeDouble_Value_Not_Included()
    {
        assertFalse("1.0 not in [1.1 .. 1.2]", isValueInRange(1.0, 1.1, 1.2));
        assertFalse("1.3 not in [1.1 .. 1.2]", isValueInRange(1.3, 1.1, 1.2));
    }

    @Test 
    public void testValueInRangeComparable_With_Borders()
    {
        assertTrue("'BB' in [AA .. CC]", isValueInRange("BB", "AA", "CC"));
        assertTrue("'AA' in [AA .. CC]", isValueInRange("AA", "AA", "CC"));
        assertTrue("'CC' in [AA .. CC]", isValueInRange("CC", "AA", "CC"));

    }
    
    @Test 
    public void testValueInRangeComparable_Value_Not_Included()
    {
        assertFalse("'A ' not in [AA .. CC]", isValueInRange("A ", "AA", "CC"));
        assertFalse("'DD' not in [AA .. CC]", isValueInRange("DD", "AA", "CC"));
    }
}