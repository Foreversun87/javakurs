package ch09_multithreading.communication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import ch09_multithreading.intro.SleepUtils;

/**
 * Beispielprogramm zur Verdeutlichung des Producer-Consumer-Ansatzes,
 * Erweiterung auf 1 Producer und 3 Consumer und eine blockierende Datenstruktur
 * (BlockingQueue)
 * <br>
 * Kommunikation wird in der gemeinsamen Datenstruktur items gekapselt
 * <br>
 * Producer produziert im Takt von 100 ms
 * <br>
 * 3 Consumer schauen im Takt von 1000 ms nach
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden
 */
public final class ProducerConsumerBlockingQueueExample
{
    public static class Producer implements Runnable
    {
        private final BlockingQueue<Item> sharedItems;

        private final long                sleepTime;

        public Producer(final BlockingQueue<Item> items, final long sleepTime)
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

                try
                {
                    sharedItems.put(newItem);                    

                    System.out.println("Produced " + newItem);

                    counter++;
                }
                catch (final InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static class Consumer implements Runnable
    {
        private final BlockingQueue<Item> sharedItems;

        private final long                sleepTime;

        private final String              consumerName;

        public Consumer(final BlockingQueue<Item> items, final long sleepTime, final String consumerName)
        {
            this.sharedItems = items;
            this.sleepTime = sleepTime;
            this.consumerName = consumerName;
        }

        public void run()
        {
            while (!Thread.currentThread().isInterrupted())
            {
                System.out.println("Consumer waiting ...");
                SleepUtils.safeSleep(sleepTime);

                try
                {
                    final Item item = sharedItems.take();
                    System.out.println(consumerName + " consuming " + item);
                }
                catch (final InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(final String[] args) throws InterruptedException
    {
        final int MAX_QUEUE_SIZE = 7;
        final BlockingQueue<Item> items = new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);

        final Thread producer = new Thread(new Producer(items, 100));
        producer.start();

        // warte 2 Sekunden, dadurch sieht man die Gr��enbeschr�nkung
        SleepUtils.safeSleep(TimeUnit.SECONDS, 2);

        final Thread consumer1 = new Thread(new Consumer(items, 1000, "Consumer 1"));
        final Thread consumer2 = new Thread(new Consumer(items, 1000, "Consumer 2"));
        consumer1.start();
        consumer2.start();

        TimeUnit.SECONDS.sleep(20);

        producer.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
    }
}
