package ch10_advancedjava.serializable;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Beispielklasse zur Demonstration des Deserialisierungsvorgangs
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class DeserializationExample
{
    public static void main(final String[] args) throws Exception
    {
        try (final ObjectInputStream objectInStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Test.ser"))))
        {
            // Rücklesen des Objekts, ohne Konstruktoraufruf 
            final Person personFromStream = (Person) objectInStream.readObject();
            System.out.println("Back from stream: " + personFromStream);
        }
    }

    private DeserializationExample()
    {
    }

}