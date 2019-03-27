package ch08_applikationsbausteine.configuration;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Beispiel für das Auslesen von Properties aus einer Konfigurationsdatei
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class AppPropertiesFirst
{
    public static final void main(final String[] args) throws IOException
    {
        final Properties properties = new Properties();

        try (final InputStream in = new BufferedInputStream(
        	 new FileInputStream("src/main/resources/AppConfig.properties")))
        {
            properties.load(in);

            final String appPdfViewer = properties.getProperty("pdf.viewer");
            System.out.println("PdfViewer = '" + appPdfViewer + "'");

            final String dbUser = properties.getProperty("db.user");
            final String dbPwd = properties.getProperty("db.password");
            System.out.println("DB-USER/PWD = '" + dbUser + "'/'" + dbPwd + "'");
        }
    }

    private AppPropertiesFirst()
    {
    }
}