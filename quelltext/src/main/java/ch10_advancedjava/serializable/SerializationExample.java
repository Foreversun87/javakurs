package ch10_advancedjava.serializable;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Beispielklasse zur Demonstration der Serialisierung
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class SerializationExample
{
    public static void main(final String[] args) throws IOException
    {
        try (final ObjectOutputStream objectOutStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Test.ser"))))
        {
            // Schreibe Objekt in die Datei  
            final Person person = new Person("Test", "TestCity", new Date());
            objectOutStream.writeObject(person);
            System.out.println("Wrote to stream: " + person);
        }
    }    

    private SerializationExample()
    {
    }
}