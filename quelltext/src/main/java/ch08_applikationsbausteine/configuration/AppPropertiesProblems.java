package ch08_applikationsbausteine.configuration;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import ch06_collections.Person;

/**
 * Beispiel für das Auslesen von Properties aus einer Konfigurationsdatei und
 * möliche unerwartete Probleme durch die Implementierungsvererbung der
 * Klasse Properties von der Klasse Hashtable
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class AppPropertiesProblems
{
    public static final void main(final String[] args) throws IOException
    {
        final Properties properties = new Properties();

        try (final InputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/AppConfig.properties")))
        {
            properties.load(in);

            // unerwartet kann man beliebige Objekte in Properties speichern     
            // Einfügen des Person-Objekts MICHA 
            properties.put("MIC", new Person("Micha", "Aachen", 39));

            // kein Zugriff auf Property mit getProperty()            
            System.out.println("getProperty()='" + properties.getProperty("MIC") + "'");

            // aber Zugriff ï¿½ber die Basisklasse mit get()    
            System.out.println("get()='" + properties.get("MIC") + "'");
        }
    }

    private AppPropertiesProblems()
    {
    }
}