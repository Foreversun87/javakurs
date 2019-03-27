package ch07_bulk_operations.advanced.zip;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Beispielprogram zeigt die Verarbeitung von ZIP mit Streams 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class ComplexZipAnalyzerJdk8Example
{
	public static void main(final String[] args) throws IOException
	{
	    final File zipFile = Paths.get("src/main/resources/ch07_bulk_operations/advanced/zip/Archiv.zip").toFile();
	    final List<ZipEntry> zipEntries = extractZipEntries(zipFile);
	    zipEntries.forEach(ze -> printEntry(ze));
	}
	
	public static List<ZipEntry> extractZipEntries(final File file) throws IOException
	{
	    final Predicate<ZipEntry> isFile = ze -> !ze.isDirectory();
	    final Predicate<ZipEntry> isJava = ze -> ze.getName().endsWith(".java");
	    final Comparator<ZipEntry> bySize = Comparator.comparingLong(ZipEntry::getSize);
	    
	    try (ZipFile zipFile = new ZipFile(file))
	    {            
	        return zipFile.stream().
	                       filter(isFile.and(isJava)).
	                       sorted(bySize.reversed()).
	                       collect(Collectors.toList());
	    }
	}
	
	public static void printEntry(final ZipEntry zipEntry)
	{
	    System.out.println("Name: " + zipEntry.getName());
	    System.out.println("Size / Compress: " + zipEntry.getSize() + " / " + zipEntry.getCompressedSize());
	    System.out.println("Last Modified:   " + zipEntry.getLastModifiedTime());
	}
}