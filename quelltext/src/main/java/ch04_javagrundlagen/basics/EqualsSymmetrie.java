package ch04_javagrundlagen.basics;

/**
 * Beispiel zur Demonstration der Symmetrie bei equals()
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class EqualsSymmetrie
{
    private static class BaseClass
    {
    }

    private static class SubClass extends BaseClass
    {
    }

    public static void main(final String[] args)
    {
        final BaseClass x = new BaseClass();
        final SubClass y = new SubClass();

        // instanceof prüfen
        System.out.println("y is-a BaseClass: " + (y instanceof BaseClass)); // true 
        System.out.println("x is-a SubClass: " + (x instanceof SubClass)); // false 

        // getClass() prï¿½fen, Ergebnis: false
        System.out.println("getClass(): " + (x.getClass() == y.getClass()));
    }

    private EqualsSymmetrie()
    {
    }
}
