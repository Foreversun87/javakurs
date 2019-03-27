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
public final class SerializationOptimizationExample3
{
    public static void main(final String[] args) throws IOException, ClassNotFoundException
    {
        final PersonWithEyeColorV3 original = new PersonWithEyeColorV3("Test", "TestCity", new Date(), Color.BLUE);

        try (final ObjectOutputStream objectOutStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("TestWithEyeColor3.ser"))))
        {
            // Schreibe Objekt in die Datei
            objectOutStream.writeObject(original);
            System.out.println("Wrote to stream: " + original);
        }
    }

    private SerializationOptimizationExample3()
    {
    }
}