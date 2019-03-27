package ch08_applikationsbausteine.logging;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Beispiel für Logging von Exception mit Stacktrace
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class ExceptionLoggingImproved
{
    private static final Logger LOGGER = LogManager.getLogger("ExceptionLoggingImproved");

    public static void main(final String[] args)
    {
        try
        {
            methodThrowingException();
        }
        catch (final IOException e)
        {
            // String-Info MIT Stacktrace       
            LOGGER.error("An I/O error occurred!", e);            
        }
    }

    // just to provide a call stack
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