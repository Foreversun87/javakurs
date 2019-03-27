package ch09_multithreading.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Beispiel zur Demonstration der Möglichkeiten von Fork-Join-Tasks
 * <br>
 * Achtung: In diesem Fall unsinnig eingesetzt, da die Fibnoacci-Zahlen
 * besser nicht rekursiv berechnet werden, da es einen linearen Alogrithmus gibt.
 * Hier nur als Beispiel der Auftrennung von Aufgaben. 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class FibonacciTask extends RecursiveTask<Integer>
{
    final int n;

    public FibonacciTask(final int n)
    {
        if (n < 0)
            throw new IllegalArgumentException("parameter n must be positive");

        this.n = n;
    }

    protected Integer compute()
    {
        // Ende des rekursiven Abstiegs  
        if (n == 0 || n == 1)
        {
            return n;
        }
        
        // Rekursiver Abstieg für fib(n-1) 
        final FibonacciTask fibTask1 = new FibonacciTask(n - 1);
        fibTask1.fork();

        // Rekursiver Abstieg fïür fib(n-2)
        final FibonacciTask fibTask2 = new FibonacciTask(n - 2);
        
        //  Zusammenfï¿½hrung fib(n-2) mit fib(n-1)
        return fibTask2.compute() + fibTask1.join();
    }

    public static void main(final String[] args)
    {
        // Definition eines Pools von Worker-Threads 
        final int WORKER_THREAD_COUNT = 4;
        final ForkJoinPool forkJoinPool = new ForkJoinPool(WORKER_THREAD_COUNT);

        // Berechnung von fib(42) 
        System.out.println(forkJoinPool.invoke(new FibonacciTask(42)));
    }
}
