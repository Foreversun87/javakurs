package ch02_profbuild;

import java.util.concurrent.TimeUnit;

/**
 * Besipiel zur Demonstration von Remote Debugging
 * 
 * @author Michael Inden
 * 
 * Copyright 2024 by Michael Inden 
 */
public class RemoteDebuggingExample
{
    public static void main(final String[] args) throws InterruptedException
    {
        for (int i = 0; i < 50; i++)
        {
            print(i);
        }
    }

    public static void print(final int i) throws InterruptedException
    {
        System.out.println("i=" + i);
        TimeUnit.SECONDS.sleep(10);
    }
}