package ch04_javagrundlagen.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm zeigt die Klasse Files und einige Erweiterungen in Java 8.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class FilesJdk8Example 
{
	public static void main(final String[] args) throws IOException 
	{	
		final String tempDirPath = System.getProperty("java.io.tmpdir");
		final Path destinationFile = Paths.get(tempDirPath + "/WriteText.txt");
		final List<String> content = Arrays.asList("This", "is", "the", "content");
		
		// Datei schreiben  
		final Path resultFile = Files.write(destinationFile, content, 
	                                        StandardOpenOption.CREATE, 		 
	                                        StandardOpenOption.APPEND);
		
		// Zeilenweise als Stream<String> einlesen  
		final Stream<String> contentAsStream = Files.lines(resultFile);
		
		// $\mbox{\bfseries Filtern und Gruppieren 
		final Map<Integer, List<String>> filterdAndGrouped = contentAsStream.
	                              filter(word -> word.length() > 3).
	                              collect(Collectors.groupingBy(String::length));
		System.out.println(filterdAndGrouped);		
	
		// Verzeichnis als Stream<Path> einlesen  
		final Stream<Path> tmpDirContent = Files.list(Paths.get(tempDirPath));
	
		// Fallstrick: endsWith arbeitet auf Path-Komponenten, nicht auf Dateinamen! 
		tmpDirContent.filter(path -> path.toString().endsWith(".txt")).
		                                             forEach(System.out::println);
	}
}

