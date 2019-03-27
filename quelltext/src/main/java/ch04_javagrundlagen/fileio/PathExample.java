package ch04_javagrundlagen.fileio;

import java.io.File;

/**
 * Beispielprogramm f�r Pfadaktionen von File-Objekten
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class PathExample
{
    public static void main(final String[] args)
    {
        printFileInfo(new File("C:\\toBeChecked"));
        printFileInfo(new File("C:\\toBeChecked\\./../toBeChecked/"));
    }

    private static void printFileInfo(final File file)
    {
        System.out.println("Name='" + file.getName() + "' / " + "Path='" + file.getAbsolutePath() + "'");
    }

    private PathExample()
    {
    }
}