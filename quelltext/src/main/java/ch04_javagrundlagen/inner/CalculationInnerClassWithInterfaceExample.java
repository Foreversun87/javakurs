package ch04_javagrundlagen.inner;

/**
 * Beispielprogramm für den Einsatz innerer Klassen und Interfaces
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class CalculationInnerClassWithInterfaceExample
{    
    // Basisinterface 
    public interface Calculation
    {
        public int calc(final int value1, final int value2);

        public String getName();
    }

    // Nur zur Demonstration von Vererbung 
    private static abstract class AbstractCalculation implements Calculation
    {
        public String getName()
        {
            return getClass().getSimpleName();
        }
    }

    // Für alle Klassen zugreifbar 
    public static final class Plus extends AbstractCalculation
    {
        public int calc(final int value1, final int value2)
        {
            return value1 + value2;
        }
    }

    // Nur innerhalb des Packages und abgeleiteter Klassen zugreifbar   
    protected static final class Minus extends AbstractCalculation
    {
        public int calc(final int value1, final int value2)
        {
            return value1 - value2;
        }
    }

    // Extrem selten sinnvoll, nur innerhalb dieser Klasse zugreifbar 
    private static class Modulo extends AbstractCalculation
    {
        public int calc(final int value1, final int value2)
        {
            return value1 % value2;
        }
    }

    public static void main(final String[] args)
    {
        final Calculation[] calculations = { new Plus(), new Minus(), new Modulo() };

        for (final Calculation calculation : calculations)
        {
            System.out.println("7 " + calculation.getName() + " 2 = " + calculation.calc(7, 2));
        }
    }
}
