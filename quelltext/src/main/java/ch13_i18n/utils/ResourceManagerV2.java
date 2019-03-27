package ch13_i18n.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch08_applikationsbausteine.old.FileUtils;
import ch13_i18n.basics.ResourceBundleUtils;
import ch13_i18n.basics.ResourceKeys;

/**
 * Beispielklasse zur Demonstration der Verwaltung mehrerer PropertyResourceBundles
 * <br>
 * Erweiterung: Automatisches Einlesen der ResourceBundle aus einem Verzeichnis
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class ResourceManagerV2
{
    private static final Logger               log                      = LogManager.getLogger(ResourceManagerV2.class);
    private static final String               BUNDLE_PATH              = "PDFEditor";

    // Verwaltung und Speicherung der ResourceBundles, JDK 7 Diamond Operator
    private final Map<Locale, ResourceBundle> availableResourceBundles = new HashMap<>();

    private ResourceBundle                    currentResourceBundle    = null;

    private Locale                            currentLocale            = null;

    private ResourceManagerV2()
    {
    }

    // Erzeugung einer gebrauchfertigen Instanz 
    public static ResourceManagerV2 createInstance()
    {
        final ResourceManagerV2 resourceManager = new ResourceManagerV2();
        resourceManager.init();
        resourceManager.activateLocale(Locale.GERMANY);

        return resourceManager;
    }

    private void init()
    {
        final File bundleDir = new File("src/main/resources/ch13_i18n");
        final FileFilter fileFilter = ResourceBundleUtils.createResourceBundleFileFilter("PDFEditor");
        final File[] propertyFiles = FileUtils.getAllMatchingFiles(bundleDir, 
                                                                   fileFilter);

        for (final File propertyFile : propertyFiles)
        {
            try (final InputStream is = new BufferedInputStream(new FileInputStream(propertyFile)))
            {
                final PropertyResourceBundle resourceBundle = new PropertyResourceBundle(is);

                final Locale locale = ResourceBundleUtils.createLocaleFromBundleName(propertyFile.getName());
                availableResourceBundles.put(locale, resourceBundle);
            }
            catch (final IOException ex)
            {
                log.warn("Failed to load resource from file '" + propertyFile.getAbsolutePath() + "'", ex);
            }
        }
    }

    public String getLangString(final ResourceKeys key)
    {
        return ResourceBundleUtils.getLangString(currentResourceBundle, key);
    }

    public boolean activateLocale(final Locale locale)
    {
        if (supportsLocale(locale))
        {
            currentResourceBundle = availableResourceBundles.get(locale);
            currentLocale = locale;
            return true;
        }

        return false;
    }

    public boolean supportsLocale(final Locale locale)
    {
        return availableResourceBundles.containsKey(locale);
    }

    public Locale getCurrentLocale()
    {
        return currentLocale;
    }

    public List<Locale> getAvailableLocales()
    {
        return new ArrayList<Locale>(availableResourceBundles.keySet());
    }
}