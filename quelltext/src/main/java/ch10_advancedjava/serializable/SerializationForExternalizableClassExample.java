package ch10_advancedjava.serializable;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Beispielklasse zur Demonstration der Serialisierung einer Klasse, die das Externalizable-Interface erf�llt.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden
 */
public final class SerializationForExternalizableClassExample 
{
	public static void main(final String[] args) throws IOException, ClassNotFoundException 
	{
		final PersonExternalizable original = new PersonExternalizable("Test", "TestCity", new Date(), Color.GREEN);

        try (final ObjectOutputStream objectOutStream = new ObjectOutputStream(
             new BufferedOutputStream(new FileOutputStream("TestSerializationForExternalizableClass.ser"))))
        {
            // Schreibe Objekt in die Datei  
            objectOutStream.writeObject(original);
            System.out.println("Wrote to stream: " + original);
        }
	}

	private SerializationForExternalizableClassExample() 
	{
	}
}