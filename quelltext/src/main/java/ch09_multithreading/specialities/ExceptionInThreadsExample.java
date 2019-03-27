package ch09_multithreading.specialities;

/**
 * Beispiel für das Auftreten einer Exception bei der Abarbeitung eines Threads
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class ExceptionInThreadsExample
{
    // Achtung: Nur zur Demonstration des Exception Handlings    
    public static void main(final String[] args) throws InterruptedException
    {
    	exceptionInMethod();
    }

    static void exceptionInMethod() throws InterruptedException
    {
        final Thread exceptional = new Thread()
        {
            public void run()
            {
                throw new IllegalStateException("run() failed");
            }
        };

        exceptional.start();
        Thread.sleep(1000);
    }

    private ExceptionInThreadsExample()
    {
    }
}
