package ch09_multithreading.intro;

/**
 * Utility-Klasse für die Ausgabe der laufenden Threads 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public class ThreadUtils
{
    public static void dumpThreads()
    {
        final ThreadGroup group = Thread.currentThread().getThreadGroup();
        final int activeCount = group.activeCount();
        final Thread[] threads = new Thread[activeCount];
        group.enumerate(threads);

        System.out.println("Thread-Group " + group + " contains " + activeCount + " threads");
        for (final Thread thread : threads)
        {
            System.out.println("Thread " + thread);
        }
    }

    public static void dumpThreadsAndGroups()
    {
        final ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        dumpThreadsAndGroups(currentGroup);
    }

    public static void dumpThreadsAndGroups(final ThreadGroup group)
    {
        final int activeCount = group.activeCount();
        final Thread[] threads = new Thread[activeCount];
        group.enumerate(threads);

        System.out.println("Thread-Group " + group + " contains " + activeCount + " threads");
        for (final Thread thread : threads)
        {
            System.out.println("Thread " + thread);
        }

        final ThreadGroup[] threadGroups = new ThreadGroup[group.activeGroupCount()];
        group.enumerate(threadGroups, false);

        for (final ThreadGroup threadGroup : threadGroups)
        {
            System.out.println("ThreadGroup " + threadGroup);
            dumpThreadsAndGroups(threadGroup);
        }
    }

    public static void main(final String[] args)
    {
        dumpThreads();
        dumpThreadsAndGroups();
    }
}
