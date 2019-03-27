package ch09_multithreading.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Beispielprogram illustriert die Ausführung paralleler Aktion mit der Klasse CompletableFuture<T>.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstCompleteableFutureExample
{
    public static void main(final String[] args) throws InterruptedException, ExecutionException
    {
        // Schritt 1: Aufwendige Berechnung, hier nur Rückagbe von einem String 
        final Supplier<String> longRunningAction = () -> {
            System.out.println("Current thread: " + Thread.currentThread());
            return "101";
        };
        final CompletableFuture<String> step1 = CompletableFuture.supplyAsync(longRunningAction);

        // Schritt 2: Konvertierung, hier nur Abbidlung von String auf Integer
        final Function<String, Integer> complexConverter = Integer::parseInt;
        final CompletableFuture<Integer> step2 = step1.thenApply(complexConverter);

        // Schritt 3: Konvertierung, hier nur Multiplikation mit .75 
        final Function<Integer, Double> complexCalculation = value -> .75 * value;
        final CompletableFuture<Double> step3 = step2.thenApply(complexCalculation);

        // Explizites Auslesen per get()
        System.out.println(step3.get());
    }
}