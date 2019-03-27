package ch04_javagrundlagen.fileio;

import java.util.Scanner;

/**
 * Beispiel zur Demonstration der Möglichkeiten eines Scanners
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden
 */
public class ScannerExample
{
	public static void main(final String[] args)
	{
		try (final Scanner scanner = new Scanner("Version-2.17_45")) 
		{
			scanner.useDelimiter("\\.|_|-");		
		
			while (scanner.hasNext())
			{
				System.out.print(scanner.next() + " ");
			}
		}
	}
}
