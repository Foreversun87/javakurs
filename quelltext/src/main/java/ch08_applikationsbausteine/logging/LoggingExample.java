package ch08_applikationsbausteine.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Einführendes Beispiel für Log-Ausgaben mithilfe von log4j2
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class LoggingExample
{
	private static Logger LOGGER = LogManager.getLogger(LoggingExample.class); 

    public static void main(final String[] args)
    {
        // Log-Meldungen ausgeben          
        LOGGER.info("Info-Meldung aus LoggingExample.");
        LOGGER.error("Error-Meldung aus LoggingExample.");
    }
}