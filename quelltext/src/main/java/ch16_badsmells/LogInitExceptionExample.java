package ch16_badsmells;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Beispiel f�r die falsche Initialisierungsreihenfolge
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class LogInitExceptionExample
{
    private static final long   test_fail = init();
    private static final Logger log       = LogManager.getLogger(LogInitExceptionExample.class);

    private static long init()
    {
        log.info("init()");

        return 4712;
    }

    public static void main(final String[] args)
    {
        System.out.println("LogInitExceptionExample");
    }
}
