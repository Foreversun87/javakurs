package ch08_applikationsbausteine.logging;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch08_applikationsbausteine.old.ByteUtils;

/**
 * Beispiel für den Einsatz mehrerer Log-Kategorien
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class LogCategoryExample
{
    private static final Logger LOGGER      = LogManager.getLogger(LogCategoryExample.class);

    private static final Logger audioInLog  = LogManager.getLogger("AudioIn");
    private static final Logger audioOutLog = LogManager.getLogger("AudioOut");

    LogCategoryExample()
    {
        LOGGER.info("LogCategoryExample created");
    }

    private void send(final byte[] msg)
    {
        LOGGER.debug("send()");
        audioOutLog.info("Sending " + ByteUtils.byteArrayToString(msg));
    }

    private byte[] receive(final InputStream inStream)
    {
        LOGGER.debug("receive()");
        
        final byte[] msg = getMsgFromStream(inStream); 
        audioInLog.info("Receiving " + ByteUtils.byteArrayToString(msg));
        return msg;
    }

    public static void main(final String[] args)
    {
        final LogCategoryExample logExample = new LogCategoryExample();
        logExample.send("Hello".getBytes());
    }    
    // ...

    private byte[] getMsgFromStream(final InputStream inStream)
    {
        return "Good Bye".getBytes();
    }
}