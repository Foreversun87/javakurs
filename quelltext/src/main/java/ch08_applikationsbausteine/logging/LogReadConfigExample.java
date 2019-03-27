package ch08_applikationsbausteine.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Beispiel für das Einlesen und Überwachen der log4j2-Konfiguration
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class LogReadConfigExample
{
    private static final Logger LOGGER    = LogManager.getLogger(LogReadConfigExample.class);

    private static final long   TWO_SECS  = 2000;
    
    public static void main(final String[] args) throws InterruptedException
    {
        LOGGER.info("LogReadConfigExample started");

        while (true)
        {
            // Logge in alle Abstufungen; Filterung durch Anpassung
            // der Datei log4j.properties 
        		LOGGER.trace("TRACE");
            LOGGER.debug("DEBUG");
            LOGGER.info("INFO");
            LOGGER.warn("WARN");
            LOGGER.error("ERROR");
            LOGGER.fatal("FATAL");

            Thread.sleep(TWO_SECS);
        }
    }
    

    private LogReadConfigExample()
    {
    }
}