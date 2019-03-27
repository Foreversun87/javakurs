package ch04_javagrundlagen.fileio;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Beispiel zur Demonstration der Vereinfachungen bei der Bearbeitung von Pfadbestandteilen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class PathOperationsExample
{
    public static void main(final String[] args)
    {
        // Konvertierung java.io.File -> java.nio.file.Path  
        final Path currentDirOldStyle = new File(".").toPath();

        // Variante 
        final FileSystem fileSystem = FileSystems.getDefault();
        final Path currentDir = fileSystem.getPath(".");

        // Als absoluten Pfad ausgeben  
        final Path absolutePath = currentDir.toAbsolutePath();
        System.out.println(absolutePath);

        // Pfadbestandteile ermitteln  
        System.out.println(absolutePath.getNameCount());
        for (int i = 0; i < absolutePath.getNameCount(); i++)
        {
            System.out.println(absolutePath.getName(i));
        }
    }

    private PathOperationsExample() 
    {
    }
}