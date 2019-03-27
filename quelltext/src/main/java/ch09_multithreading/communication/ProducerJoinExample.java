package ch09_multithreading.communication;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ch09_multithreading.communication.ProducerConsumerExample.Producer;
import ch09_multithreading.intro.SleepUtils;

/**
 * Beispielprogramm zur Verdeutlichung der Abstimmung von Threads
 * <br>
 * Es wird ein Producer gestartet und im main()-Thread
 * über join() zeitbeschränkt auf dessen Ende gewartet.

 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class ProducerJoinExample
{
    public static void main(final String[] args) throws InterruptedException
    {
        final List<Item> items = new LinkedList<>();
        final Thread producerThread = new Thread(new Producer(items, 1000));
        producerThread.start();

        // Aktueller Thread wird für 5 Sekunden angehalten
        producerThread.join(TimeUnit.SECONDS.toMillis(5));
        System.out.println("after join(): producer is alive? " + producerThread.isAlive());
        // 1000 ms Produktionszeit und 5000 ms Wartezeit => ca. 5 Items
        System.out.println("Item-Count after join(): " + items.size());
        // Der Producer arbeitet noch 2 Sekunden weiter ...
        SleepUtils.safeSleep(TimeUnit.SECONDS, 2);

        // Der Producer wird aufgefordert, nun anzuhalten ... 
        producerThread.interrupt();

        // 1000 ms Produktionszeit und 7 s Wartezeit => ca. 7 Items 
        System.out.println("Item-Count after interrupt(): " + items.size());
        System.out.println("after interrupt(): producer is alive? " + producerThread.isAlive());
    }

    private ProducerJoinExample()
    {
    }
}
