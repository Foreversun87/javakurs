package ch09_multithreading.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogram illustriert die Ausf�hrung paralleler Aktion mit der Klasse CompletableFuture<T> am Beispiel des Wortz�hlens.
 *
 * @author Michael Inden
 *
 * Copyright 2014 by Michael Inden
 */
public class CompleteableFutureExample
{
    public static void main(final String[] args) throws IOException, InterruptedException, ExecutionException
    {
        final Path exampleFile = Paths.get("src/main/resources/ch09_multithreading/"+
                                           "concurrency/Example.txt");

        // M�glicherweise l�ngerdauernde Aktion
        final CompletableFuture<List<String>> contents = CompletableFuture
                        .supplyAsync(extractWordsFromFile(exampleFile));
        contents.thenAccept(text -> System.out.println("Initial: " + text));

        // Filterungen parallel ausf�hren
        final CompletableFuture<List<String>> filtered1 = contents.thenApplyAsync(removeIgnorableWords());
        final CompletableFuture<List<String>> filtered2 = contents.thenApplyAsync(removeShortWords());

        // Verbinde die Ergebnisse
        final CompletableFuture<List<String>> result = filtered1.thenCombine(filtered2, calcIntersection());

        // keine Ausgabe ohne diese Zeile!? => erst Terminal Operation st�sst Berechnung an
        System.out.println("result: " + result.get());
    }

    private static Supplier<List<String>> extractWordsFromFile(final Path exampleFile)
    {
        return () -> {
            try
            {
                final List<String> lines = Files.readAllLines(exampleFile);

                final Stream<String> words = lines.stream().flatMap(line -> Stream.of(line.split(" ")));

                final Stream<String> mapped = words.map(removePunctationMarks());
                final Stream<String> sorted = mapped.sorted(String.CASE_INSENSITIVE_ORDER);

                return sorted.collect(Collectors.toList());
            }
            catch (final IOException e)
            {
                return Collections.emptyList();
            }
        };
    }

    private static Function<String, String> removePunctationMarks()
    {
        final Function<String, String> removePunctationMarks = str -> {
            if (str.endsWith(".") || str.endsWith(":") || str.endsWith("!"))
            {
                return str.substring(0, str.length() - 1);
            }
            else
            {
                return str;
            }
        };
        return removePunctationMarks;
    }

    private static Function<List<String>, List<String>> removeIgnorableWords()
    {
        final List<String> ignoreableWords = Arrays.asList("this", "This", "line", "text");
        final Predicate<String> isIgnorableWord = word -> ignoreableWords.contains(word);

        return input -> {
            return input.stream().filter(isIgnorableWord.negate()).collect(Collectors.toList());
        };
    }

    private static Function<List<String>, List<String>> removeShortWords()
    {
        final Predicate<String> isShortWord = word -> word.length() <= 3;
        final Predicate<String> notIsShortWord = isShortWord.negate();

        return input -> {
            return input.stream().filter(notIsShortWord).collect(Collectors.toList());
        };
    }

    private static BiFunction<? super List<String>, ? super List<String>, ? extends List<String>> calcIntersection()
    {
        return (list1, list2) -> {
            list1.retainAll(list2);
            return list1;
        };
    }
}
