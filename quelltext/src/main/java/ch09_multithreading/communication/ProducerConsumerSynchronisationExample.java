package ch09_multithreading.communication;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ch09_multithreading.intro.SleepUtils;

/**
 * Beispielprogramm zur Verdeutlichung des Producer-Consumer-Ansatzes
 * <br>
 * Kritische Bereiche werden hier über synchronized geschïützt.
 * Kommunikation geschieht über Pooling auf gemeinsame Datenstruktur items
 * <br>
 * Producer produziert im Takt von 1 Sekunde
 * <br>
 * Consumer schaut im Takt von 500 ms nach
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden
 */
public final class ProducerConsumerSynchronisationExample
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
                // Ereugen eines Items 
                final Item newItem = new Item("Item " + counter);
                System.out.println("Producing ... " + newItem);

                SleepUtils.safeSleep(sleepTime);

                // Lock akquirieren, dann exklusiv zugreifen und hinzufï¿½gen 
                synchronized (sharedItems)
                {
                    sharedItems.add(newItem);
                    System.out.println("Produced " + newItem);
                }
                // Lock wird automatisch freigeben

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

        public void run()
        {
            while (!Thread.currentThread().isInterrupted())
            {
                // Status-Flag ist als lokale Variable immer Thread-sicher 
                boolean noItems = true;
                while (noItems)
                {
                    // Lock akquirieren, dann exklusiv zugreifen und auslesen 
                    synchronized (sharedItems)
                    {
                        noItems = (sharedItems.size() == 0);
                        if (noItems)
                        {
                           System.out.println("Consumer waiting for items ...");
                        }
                        else
                        {
                           System.out.println("Consuming " + sharedItems.remove(0));
                        }
                    }
                    // Lock wird automatisch freigeben

                    // sleep() nicht in synchronized aufrufen, Lock wird 
                    // nicht freigegeben => Producer kï¿½nnte so niemals            
                    // wï¿½hrend der Wartezeit Items erzeugen und ablegen 
                    SleepUtils.safeSleep(sleepTime);
                }
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
