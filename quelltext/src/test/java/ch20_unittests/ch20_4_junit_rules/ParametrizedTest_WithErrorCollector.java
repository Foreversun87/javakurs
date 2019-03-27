package ch20_unittests.ch20_4_junit_rules;

import ch03_oodesign.generics.Pair;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit-Tests zur Demonstration von selbstgeschreibenen Parametrized Tests
 * mithilfe von der JUnit Rule ErrorCollector. Dadurch wird der Testfall
 * deutlich leichter lesbar.
 *
 * @author Michael Inden
 *
 * Copyright 2014 by Michael Inden
 */
public class ParametrizedTest_WithErrorCollector
{
    @Rule
    public ErrorCollector errors = new ErrorCollector();

    @Test
    public void testHexCodedByteValueToInt_With_AllValidInputs()
    {
        final List<Pair<Byte, Integer>> inputsAndResults = Arrays.asList(
                new Pair((byte)'0', 0), new Pair((byte)'9', 9),
                // errors
                new Pair((byte)'C', 122), new Pair((byte)'E', 144),
                new Pair((byte)'A', 10), new Pair((byte)'F', 15));

        for (final Pair<Byte, Integer> current : inputsAndResults)
        {
            try
            {
                assertEquals(current.getSecond().intValue(),
                             Controller.hexCodedByteToInt(current.getFirst()));
            }
            catch (final Throwable e)
            {
                errors.addError(e);
            }
        }
    }

    static class Controller {
        public static int hexCodedByteToInt(final byte byteValue) {
            if (byteValue >= 'A' && byteValue <= 'F') {
                return (10 + (byteValue - 'A'));
            }
            if (byteValue >= '0' && byteValue <= '9') {
                return (byteValue - '0');
            }
            throw new IllegalArgumentException("Unexpected byte value: " + byteValue + ". Must be in Range ’0’-’9’ (0x30-0x39) or ’A’-’F’ (0x41-0x46)");
        }
    }
}



