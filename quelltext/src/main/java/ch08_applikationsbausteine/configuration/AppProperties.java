package ch08_applikationsbausteine.configuration;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Beispiel für das Auslesen von Properties aus einer Konfigurationsdatei
 * <br>
 * Verbesserung der Unzulänglichkeiten der Klasse Properties durch
 * Definition einer eigenen Klassen AppProperties, die sich auf die
 * Klasse Properties stützt
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class AppProperties
{
    private static final String FILE_PATH = "src/main/resources/AppConfig.properties";

    private static final AppProperties INSTANCE = new AppProperties();

    private final Properties properties = new Properties();

    public static final AppProperties getInstance() 
    {
        return INSTANCE;
    }

    public synchronized void readAppProperties() throws IOException
    {
        try (final InputStream in = new BufferedInputStream(
			            new FileInputStream(FILE_PATH)))
	    {
            properties.load(in);
        }        
    }

    // ...
    public synchronized void writeAppProperties() throws IOException
    {
        try (final OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(FILE_PATH)))
        {
            properties.store(out, "");
        }
    }

    public synchronized String getProperty(final PropertyName key)
    {
        return properties.getProperty(key.propertyKey);
    }

    public synchronized void setProperty(final PropertyName key, final String value)
    {
        properties.setProperty(key.propertyKey, value);
    }

    public static String getPropertyFilePath()
    {
        return new File(FILE_PATH).getAbsolutePath();
    }

    public static final void main(final String[] args)
    {
        try
        {
            final AppProperties appProperties = AppProperties.getInstance();

            System.out.println("accessing property file '" + AppProperties.getPropertyFilePath() + "'");
            appProperties.readAppProperties();

            final String appPdfViewer = appProperties.getProperty(PropertyName.PDF_VIEWER);
            System.out.println("PdfViewer = '" + appPdfViewer + "'");

            final String dbUser = appProperties.getProperty(PropertyName.DB_USER);
            final String dbPwd = appProperties.getProperty(PropertyName.DB_PASSWORD);
            System.out.println("DB USER / PWD= '" + dbUser + "' / '" + dbPwd + "'");                      
        }
        catch (final IOException e)
        {
            System.out.println("Can't access property file '" + AppProperties.getPropertyFilePath() + "'");
        }
    }
}

enum PropertyName 
{
    PDF_VIEWER("pdf.viewer"), DB_USER("db.user"), DB_PASSWORD("db.password");

    final String propertyKey;

    PropertyName(final String propertyKey)
    {
        this.propertyKey = propertyKey;
    }
}