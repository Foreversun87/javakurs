package ch10_advancedjava.serializable;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Beispielklasse zur Demonstration der Serialisierung mithilfe des
 * Externalizable-Interfaces
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden
 */
public final class ExternalizableExample 
{
	public static void main(final String[] args) throws IOException, ClassNotFoundException
	{
	   final PersonExternalizable original = new PersonExternalizable("Test", 
	                                         "TestCity", new Date(), Color.GREEN);
											 
	   final String filename = "TestExternalizable.ser";
											 
	   try (final ObjectOutputStream objectOutStream = new ObjectOutputStream(
	        new BufferedOutputStream(new FileOutputStream(filename))))
	   {
	       // Schreibe Objekt mit writeExternal() in die Datei 
	       original.writeExternal(objectOutStream);
	       System.out.println("Wrote to stream: " + original);
	   }
	    
	   try (final ObjectInputStream objectInStream = new ObjectInputStream(
	        new BufferedInputStream(new FileInputStream(filename))))
	   {
	       // Rücklesen des Objekts: Konstruktoraufruf und readExternal()  
	       final PersonExternalizable readInObject = new PersonExternalizable();
	       readInObject.readExternal(objectInStream);
	       System.out.println("Back from stream: " + readInObject);
	   }    
	}

	private ExternalizableExample() 
	{
	}
}