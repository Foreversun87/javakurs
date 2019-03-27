package ch09_multithreading.specialities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Beispiel für die Protokollierung von Exceptions 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class LoggingUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
{
	private static final Logger log = LogManager.getLogger("UncaughtExceptions");

    @Override
    public void uncaughtException(final Thread thread, final Throwable throwable)
    {
        log.error("Unexpected exception occured: ", throwable);
    }

    public static void main(final String[] args) throws InterruptedException
    {
        // Unbehandelte Exeptions auf Logger umleiten
        Thread.setDefaultUncaughtExceptionHandler(new LoggingUncaughtExceptionHandler());

        ExceptionInThreadsExample.exceptionInMethod();
        throw new IllegalStateException("execute main() failed");
    }
}
