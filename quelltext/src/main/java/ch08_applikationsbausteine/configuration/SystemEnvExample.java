package ch08_applikationsbausteine.configuration;

import java.util.Map;

/**
 * Beispiel für das Auslesen von System-Umgebungsvariablen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class SystemEnvExample
{
    public static void main(final String[] args)
    {
        final Map<String, String> systemEnv = System.getenv();

        for (final Map.Entry<String, String> entry : systemEnv.entrySet())
        {
            System.out.println("Key = " + entry.getKey() +
                    " / Value = " + entry.getValue());
        }
    }
    
    private SystemEnvExample()
    {        
    }
}
