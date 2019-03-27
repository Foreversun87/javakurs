package ch04_javagrundlagen.fileio;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Beispiel zur Demonstration der Möglichkeiten eines DirectoryStreams
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden
 */
public final class DirectoryStreamExample
{
    public static void main(final String[] args) throws IOException
    {
        // Konvertierung java.io.File -> java.nio.file.Path 
        final Path currentDir = new File(".").toPath();        

        try (final DirectoryStream<Path> dirStream = Files.newDirectoryStream(currentDir))
        {
            for (final Path entry : dirStream)
            {
                System.out.println(entry);
            }
        }
    }

    private DirectoryStreamExample() 
    {
    }
}
