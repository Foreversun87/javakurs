package ch09_multithreading.communication;

import java.util.LinkedList;
import java.util.List;

import ch09_multithreading.communication.ProducerConsumerExample.Producer;
import ch09_multithreading.intro.SleepUtils;

/**
 * Beispielprogramm zur Verdeutlichung des Producer-Consumer-Ansatzes,
 * Erweiterung auf 1 Producer und 3 Consumer
 * <br>
 * Kritische Bereiche werden hier üer synchronized geschützt.
 * Kommunikation geschieht über gemeinsame Datenstruktur items
 * mithilfe von wait() und notifyAll()
 * <br>
 * Producer produziert im Takt von 1000 ms
 * <br>
 * 3 Consumer schauen im Takt von 100 ms nach
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class ProducerMultiConsumerWrong2Example
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

        public void run()
        {
            while (!Thread.currentThread().isInterrupted())
            {
                synchronized (sharedItems)
                {
                    try
                    {
                        System.out.println(consumerName + " waiting ...");

                        sharedItems.wait();

                        if (sharedItems.size() > 0)
                            System.out.println(consumerName + " consuming " + sharedItems.remove(0));
                        else
                            System.out.println(consumerName + " --- item already consumed by " + "other consumer!");

                        SleepUtils.safeSleep(sleepTime);
                    }
                    catch (final InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void main(final String[] args)
    {
        final List<Item> sharedItems = new LinkedList<>();

        new Thread(new Producer(sharedItems, 1000)).start();

        new Thread(new Consumer(sharedItems, 100, "Consumer 1")).start();
        new Thread(new Consumer(sharedItems, 100, "Consumer 2")).start();
        new Thread(new Consumer(sharedItems, 100, "Consumer 3")).start();
    }
}
