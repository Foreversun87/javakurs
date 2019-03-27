package ch16_badsmells;

/**
 * Beispiel f�r den Aufruf abstrakter Methoden im Konstruktor
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class AbstractMethodInConstructorExample
{
    abstract static class AbstractBase
    {
        protected final Integer baseValue = 42;

        AbstractBase()
        {
            // Aufruf der Initialisierung
            init(); 
        }

        abstract void init();
    }

    static class Derived extends AbstractBase
    {
        private final Integer value = 13;

        Derived()
        {
        }

        void init()
        {
            // Zugriff auf Attribut der Basisklasse 
            System.out.println("baseValue = " + baseValue);
            
            // Zugriff auf Attribut dieser Klasse  
            System.out.println("value = " + value);
        }
    }

    public static void main(String[] args)
    {
        // Konstruktion zur Demonstration der Probleme 
        new Derived(); 
    }
}