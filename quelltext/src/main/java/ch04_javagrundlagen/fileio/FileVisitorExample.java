package ch04_javagrundlagen.fileio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Beispiel zur Demonstration der Möglichkeiten eines FileVisitors
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden
 */
public final class FileVisitorExample
{
    public static void main(final String[] args) throws IOException
    {
        final ExtensionFilterVisitor jpgVisitor = new ExtensionFilterVisitor("JPG");
        Files.walkFileTree(Paths.get("config/tiles"), jpgVisitor);

        final List<Path> results = jpgVisitor.getResults();
        System.out.println("JPG-Files: " + results);
    }

    public static class ExtensionFilterVisitor extends SimpleFileVisitor<Path>
    {
        private final String extension;
        private final List<Path> results = new ArrayList<>();

        public ExtensionFilterVisitor(final String imageExtension) {
            this.extension = imageExtension.toLowerCase();
        }

        public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs)
        {
            final Path filePath = file.getFileName();
            System.out.println("Visiting file " + filePath);

            // stringObj.endsWith(String) statt file.getFileName().endsWith(other)
            if (filePath.toString().toLowerCase().endsWith(extension))
            {
                results.add(file);
            }

            // Verarbeitung fortsetzen  
            return FileVisitResult.CONTINUE;
        }

        private List<Path> getResults()
        {
            return new ArrayList<>(results);
        }
    }

    private FileVisitorExample() {
    }
}