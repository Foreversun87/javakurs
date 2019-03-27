package ch04_javagrundlagen.fileio;

import java.io.File;

/**
 * Utility-Klasse zur Dateiverarbeitung
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class FileUtils 
{
    public static String[] getContents(final File directoryToCheck)
    {
        if (directoryExists(directoryToCheck))
        {
            final String[] contents = directoryToCheck.list();

            if (contents != null)
            {
                return contents;
            }
        }

        return new String[0];
    }

    public static boolean directoryExists(final File directoryToCheck)
    {
        if (directoryToCheck == null)
            return false;

        return directoryToCheck.exists() && directoryToCheck.isDirectory();
    }
}
