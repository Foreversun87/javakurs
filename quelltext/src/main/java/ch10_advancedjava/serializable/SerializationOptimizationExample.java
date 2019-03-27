package ch10_advancedjava.serializable;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Beispielprogramm zur Demonstration von Optimierungsm�glichkeiten bei der
 * Serialisierung
 *  
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class SerializationOptimizationExample
{
    public static void main(final String[] args) throws IOException
    {
        final PersonWithEyeColorV1 original = new PersonWithEyeColorV1("Test", "TestCity", new Date(), Color.GREEN);

        try (final ObjectOutputStream objectOutStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("TestWithEyeColor1.ser"))))
        {
            // Schreibe Objekt in die Datei  
            objectOutStream.writeObject(original);
            System.out.println("Wrote to stream: " + original);
        }
    }

    private SerializationOptimizationExample()
    {
    }
}