package ch07_bulk_operations.advanced.zip;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Beispielprogram zeigt die Verarbeitung von ZIP mit Streams 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ZipAnalyzerExampleJdk7
{    
	public static void main(final String[] args) throws IOException
	{
	    final File zipFile = Paths.get("src/main/resources/ch07_bulk_operations/advanced/zip/Archiv.zip").toFile();
	    final List<ZipEntry> zipEntries = extractZipEntries(zipFile);
	    
	    for (final ZipEntry zipEntry : zipEntries)
	    {
	        printEntry(zipEntry);                    
	    }
	}
	
	private static List<ZipEntry> extractZipEntries(final File file) throws IOException
	{
	    final List<ZipEntry> result = new ArrayList<>();
	    
	    try (final ZipFile zipFile = new ZipFile(file))
	    {
	        final Enumeration<? extends ZipEntry> entries = zipFile.entries();
	        while (entries.hasMoreElements())
	        {
	            final ZipEntry zipEntry = entries.nextElement();
	            result.add(zipEntry);
	        }
	    }
	    
	    return result;
	}
	
	private static void printEntry(final ZipEntry zipEntry)  
	{
	    System.out.println("Name: " + zipEntry.getName());
	    System.out.println("Size / Compressed: " + zipEntry.getSize() + " / " + 
	                                               zipEntry.getCompressedSize());
	    System.out.println("Last Modified:     " + zipEntry.getLastModifiedTime());
	}
}