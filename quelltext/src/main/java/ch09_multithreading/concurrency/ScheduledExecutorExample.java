package ch09_multithreading.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Beispiel für die Nutzung eines ScheduledExecutorService zur
 * zeitgesteuerten Ausführung von Aufgaben
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class ScheduledExecutorExample
{
    public static void main(String[] args) throws InterruptedException
    {
        final int POOL_SIZE = 3;
        final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(POOL_SIZE);

        // Sofortige Ausführung
        executorService.schedule(new SampleMessageTask("OnceImmediately"), 0, TimeUnit.SECONDS);

        // Ausführung nach fünf Sekunden 
        executorService.schedule(new SampleMessageTask("OnceAfter5s"), 5, TimeUnit.SECONDS);

        // Ausführung nach einer Minute 
        executorService.schedule(new SampleMessageTask("OnceAfter1min"), 1, TimeUnit.MINUTES);

		TimeUnit.SECONDS.sleep(65); // Thread.sleep(65 * 1000);

		executorService.shutdown();
	}

    private ScheduledExecutorExample()
    {
    }
}
