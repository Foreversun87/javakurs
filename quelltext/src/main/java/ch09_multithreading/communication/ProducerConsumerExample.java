package ch09_multithreading.communication;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ch09_multithreading.intro.SleepUtils;

/**
 * Beispielprogramm zur Verdeutlichung des Producer-Consumer-Ansatzes
 * <br>
 * Kritische Bereiche werden hier über synchronized geschützt.
 * Kommunikation geschieht über gemeinsame Datenstruktur items
 * mithilfe von wait() und notifyAll()
 * <br>
 * Producer produziert im Takt von 1000 ms
 * <br>
 * Consumer schaut im Takt von 500 ms nach
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class ProducerConsumerExample
{
    public static class Producer implements Runnable
    {
        private final List<Item> sharedItems;
        private final long       sleepTime;

        public Producer(final List<Item> items, final long sleepTime)
        {
            this.sharedItems = items;
            this.sleepTime = sleepTime;
        }

        public void run()
        {
            int counter = 0;

            while (!Thread.currentThread().isInterrupted())
            {
                final Item newItem = new Item("Item " + counter);
                System.out.println("Producing ... " + newItem);

                SleepUtils.safeSleep(sleepTime);

                synchronized (sharedItems)
                {
                    sharedItems.add(newItem);
                    System.out.println("Produced " + newItem);
                    // Informiere wartende Threads
                    sharedItems.notifyAll();
                }

                counter++;
            }
        }
    }

    public static class Consumer implements Runnable
    {
        private final List<Item> sharedItems;
        private final long       sleepTime;

        public Consumer(final List<Item> items, final long sleepTime)
        {
            this.sharedItems = items;
            this.sleepTime = sleepTime;
        }

        // ACHTUNG: Problematische Realisierung !!!         
        public void run()
        {
            while (!Thread.currentThread().isInterrupted())
            {
                synchronized (sharedItems)
                {
                    try
                    {
                        System.out.println("Consumer waiting ...");
                        sharedItems.wait();
                        // ACHTUNG: Unsicherer Zugriff 
                        System.out.println("Consuming " + sharedItems.remove(0));
                    }
                    catch (final InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                }

                SleepUtils.safeSleep(sleepTime);
            }
        }
    }

    public static void main(final String[] args) throws InterruptedException
    {
        final List<Item> sharedItems = new LinkedList<>();

        final Thread producer = new Thread(new Producer(sharedItems, 1000));
        final Thread consumer = new Thread(new Consumer(sharedItems, 500));
        producer.start();
        consumer.start();

        TimeUnit.SECONDS.sleep(20);

        producer.interrupt();
        consumer.interrupt();
    }
}
