package ch04_javagrundlagen.fileio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Beispiel zur Demonstration der Vereinfachungen von Dateioperationen: Kopieren
 * und Verschieben ist nun als Aktion möglich und muss nicht per Hand
 * ausprogrammiert werden.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden
 */
public final class FileIOExample
{
    public static void main(final String[] args) throws IOException
    {
        // Zugriff auf das systemspezifische tmp-Directory  
        final String tmpDir = System.getProperty("java.io.tmpdir");
        
        // Konstanten für die betroffenen Dateien
        final String SOURCE_FILE_PATH = "src/main/java/ch04_javagrundlagen/fileio/FileIOExample.java";
        final String DESTINATION_FILE_PATH1 = tmpDir + "CopiedFile.java";
        final String DESTINATION_FILE_PATH2 = tmpDir + "CopyOfFileIOExample.java";

        // Erzeugen eines Path-Objekts mit der Klasse FileSystem
        final FileSystem local = FileSystems.getDefault();
        final Path fromPath = local.getPath(SOURCE_FILE_PATH);

        // Erzeugen von Path-Objekten mit der Utility-Klasse Paths
        final Path toPath1 = Paths.get(DESTINATION_FILE_PATH1);
        final Path toPath2 = Paths.get(DESTINATION_FILE_PATH2);

        // Dateien vorsorglich löschen 
        Files.deleteIfExists(toPath1);
        Files.deleteIfExists(toPath2);
        
        // Kopieren und verschieben 
        Files.copy(fromPath, toPath1);
        Files.move(toPath1, toPath2);
        
        final File dir = new File(tmpDir);
        final String[] content = dir.list(new PreAndPostFixFilenameFilter("Copy", ".java"));
        System.out.println("Content of tmpDir '" + tmpDir + "': " +  Arrays.toString(content));
    }
}