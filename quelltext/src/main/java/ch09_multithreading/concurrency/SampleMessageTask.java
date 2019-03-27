package ch09_multithreading.concurrency;

/**
 * Beispiel für einen einfachen Task mit Konsolenausgabe
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2014 by Michael Inden 
 */
public class SampleMessageTask implements Runnable
{
    private final String message;

    SampleMessageTask(final String message)
    {
        this.message = message;
    }

    public void run()
    {
        System.out.println(message);
    }
}