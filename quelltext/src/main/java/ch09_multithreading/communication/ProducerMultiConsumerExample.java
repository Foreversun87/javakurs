package ch09_multithreading.communication;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ch09_multithreading.communication.ProducerConsumerExample.Producer;
import ch09_multithreading.intro.SleepUtils;

/**
 * Beispielprogramm zur Verdeutlichung des Producer-Consumer-Ansatzes,
 * Erweiterung auf 1 Producer und 3 Consumer
 * <br>
 * Kritische Bereiche werden hier über synchronized geschützt.
 * Kommunikation geschieht über gemeinsame Datenstruktur items
 * mithilfe von wait() und notifyAll()
 * <br>
 * Producer produziert im Takt von 1000 ms
 * <br>
 * 3 Consumer schauen im Takt von 100 ms nach
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class ProducerMultiConsumerExample
{
    public static class Consumer implements Runnable
    {
        private final List<Item> sharedItems;
        private final long       sleepTime;
        private final String     consumerName;

        public Consumer(final List<Item> items, final long sleepTime, final String consumerName)
        {
            this.sharedItems = items;
            this.sleepTime = sleepTime;
            this.consumerName = consumerName;
        }

        /** create an item every 2 seconds */
        public void run()
        {
            while (!Thread.currentThread().isInterrupted())
            {
                synchronized (sharedItems)
                {
                    try
                    {
                        System.out.println(consumerName + " waiting ...");

                        waitForItemsAvailable(sharedItems);

                        // Zugriff immer durch waitForItemsAvailable() sicher 
                        final Item item = sharedItems.remove(0);
                        System.out.println(consumerName + " consuming " + item);

                        SleepUtils.safeSleep(sleepTime);
                    }
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    private static void waitForItemsAvailable(final List<Item> items) throws InterruptedException
    {
        while (items.size() == 0)
            items.wait();
    }

    public static void main(final String[] args) throws InterruptedException
    {
        final List<Item> sharedItems = new LinkedList<>();

        final Thread producer = new Thread(new Producer(sharedItems, 1000));
        final Thread consumer1 = new Thread(new Consumer(sharedItems, 100, "Consumer 1"));
        final Thread consumer2 = new Thread(new Consumer(sharedItems, 100, "Consumer 2"));
        final Thread consumer3 = new Thread(new Consumer(sharedItems, 100, "Consumer 3"));
        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        TimeUnit.SECONDS.sleep(20);

        producer.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
        consumer3.interrupt();
    }

    private ProducerMultiConsumerExample()
    {        
    }
}
