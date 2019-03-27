package ch07_bulk_operations.terminal;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Beispielprogram zeigt die Abbildung von Objekten mithilfe der Methode flatMap() --
 * hier zur Extraktion von Worten aus Zeilens.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FlatMapAndGroupingExample
{
    public static void main(final String[] args) throws IOException
    {
        final Path exampleFile = Paths.get("src/main/resources/ch07_bulk_operations/Example.txt");

        // Datei einlesen neu in JDK 8: Siehe dazu Kapitel 6  
        final List<String> contents = Files.readAllLines(exampleFile);

        // Daraus einen Stream von Worten machen  
        final Stream<String> words = contents.stream().flatMap(line -> Stream.of(line.split(" ")));

        // Prädikate für kurze Worte  
        final Predicate<String> isShortWord = word -> word.length() <= 3;
        final Predicate<String> notIsShortWord = isShortWord.negate();

        // Prädikate für spezielle und zu ignorierende Worte  
        final List<String> ignoreableWords = Arrays.asList("this", "these", "them");
        final Predicate<String> isIgnorableWord = word -> {
            return ignoreableWords.contains(word.toLowerCase());
        };
        final Predicate<String> isSignificantWord = isIgnorableWord.negate();

        // Filterung basierend auf den Prädikaten  
        final Stream<String> filteredContents = words.map(String::trim).filter(notIsShortWord)
                        .filter(isSignificantWord);

        // Mappings zum Satzzeichen entfernen  
        final Function<String, String> removePunctationMarks = str -> {
            if (str.endsWith(".") || str.endsWith(":") || str.endsWith("!"))
            {
                return str.substring(0, str.length() - 1);
            }
            return str;
        };

        final Stream<String> mapped = filteredContents.map(removePunctationMarks);

        //Gruppierung  
        Function<String, String> classifier = Function.identity(); // str -> str;
        Map<String, Long> grouped = mapped.collect(groupingBy(classifier, counting()));

        // Sortierung der Schlüssel mithilfe einer TreeMap<K,V>)  
        Map<String, Long> sorted = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sorted.putAll(grouped);

        System.out.println(sorted);
    }
}