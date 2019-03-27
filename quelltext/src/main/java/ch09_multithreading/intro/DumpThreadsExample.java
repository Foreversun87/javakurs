package ch09_multithreading.intro;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import ch03_oodesign.Counter;

/**
 * Beispiel für die Ausgabe der laufenden Threads mithilfe der selbsterstellen 
 * Utility-Klasse ThreadUtils. 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class DumpThreadsExample
{
public static void main(final String[] args) throws InterruptedException
{
    final Thread derivedThread = new CountingThread();
    derivedThread.setName("CountingThread");
    derivedThread.start();

    final Thread threadWithRunnable = new Thread(new DatePrinter());
    // threadWithRunnable.setName("DatePrinter");
    threadWithRunnable.start();
    
    ThreadUtils.dumpThreads();
    
    Thread.sleep(7_000);
    threadWithRunnable.interrupt();
    derivedThread.interrupt();
}

    public static class CountingThread extends Thread
    {
        final Counter counter = new Counter();

        public void run()
        {
            while (!Thread.currentThread().isInterrupted() &&
            	   counter.currentValue() < 50)
            {
                System.out.println(counter.currentValue());
                counter.increment();
                SleepUtils.safeSleep(TimeUnit.SECONDS, 1);
            }
        }
    }

    public static class DatePrinter implements Runnable
    {
        public void run()
        {
            for (int i = 0; i < 10 && !Thread.currentThread().isInterrupted(); i++)
            {
                System.out.println(new Date());
                SleepUtils.safeSleep(TimeUnit.SECONDS, 5);
            }
        }
    }
}