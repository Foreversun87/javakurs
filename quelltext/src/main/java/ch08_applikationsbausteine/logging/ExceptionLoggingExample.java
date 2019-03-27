package ch08_applikationsbausteine.logging;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Beispiel für wenig informatives Logging von Exceptions
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class ExceptionLoggingExample
{
    private static final Logger LOGGER = LogManager.getLogger("ExceptionLoggingExample");
    
    public static void main(final String[] args)
    {
        try
        {
            methodThrowingException();
        }
        catch (final IOException e)
        {
            // SCHLECHT: nur String-Info ohne Stacktrace!          
            LOGGER.error("An I/O error occurred! " + e);
            LOGGER.error("An I/O error occurred! " + e.getMessage());
        }
    }

    private static void methodThrowingException() throws IOException
    {
        first();
    }

    // just to provide a call stack
    private static void first() throws IOException
    {
        second();
    }

    private static void second() throws IOException
    {
        throw new IOException("Text");
    }
}