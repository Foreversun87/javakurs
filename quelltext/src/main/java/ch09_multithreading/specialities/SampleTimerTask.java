package ch09_multithreading.specialities;

import java.util.TimerTask;

/**
 * Beispiel für einen einfachen TimerTask mit Konsolenausgabe
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class SampleTimerTask extends TimerTask
{
    private final String message;

    SampleTimerTask(final String message)
    {
        this.message = message;
    }

    public void run()
    {
        System.out.println(message);
    }
}
