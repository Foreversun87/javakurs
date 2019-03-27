package ch13_i18n.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch13_i18n.basics.ResourceBundleUtils;
import ch13_i18n.basics.ResourceKeys;

/**
 * Beispielklasse zur Demonstration der Verwaltung mehrerer PropertyResourceBundles
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2ß017 by Michael Inden 
 */
public final class ResourceManager
{
    private static final Logger log = LogManager.getLogger(ResourceManager.class);

    // ACHTUNG: Muss im CLASSPATH zugänglich sein!  
    private static final String BUNDLE_PATH = "ch13_i18n.PDFEditor";

    // Verwaltung und Speicherung der ResourceBundles, JDK 7: Diamond Operator
    private final Map<Locale, ResourceBundle> availableResourceBundles = new HashMap<>();

    private ResourceBundle                    currentResourceBundle    = null;
    private Locale                            currentLocale            = null;

    private ResourceManager()
    {
    }
    
    // Erzeugung einer gebrauchsfertigen Instanz  
    public static ResourceManager createInstance()
    {
        final ResourceManager resourceManager = new ResourceManager();
        resourceManager.init();
        resourceManager.activateLocale(Locale.GERMANY);
        
        return resourceManager;
    }

    private void init()
    {
        loadAndAddResourceBundle(Locale.GERMANY);
        loadAndAddResourceBundle(Locale.UK);
        loadAndAddResourceBundle(Locale.FRANCE);        
    }
    
    private void loadAndAddResourceBundle(final Locale locale)
    {
        try
        {
            final ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_PATH, locale);
            availableResourceBundles.put(locale, resourceBundle);
        }
        catch (final MissingResourceException ex)
        {
            log.warn("Missing recource '" + BUNDLE_PATH + "' for locale: '" + locale + "'", ex);
        }
    }
    
    // Zugriff auf sprachabhï¿½ngige Texte  
    public String getLangString(final ResourceKeys key)
    {
        return ResourceBundleUtils.getLangString(currentResourceBundle, key);
    }

    // Umschaltung der Sprache  
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

    // Hilfsmethoden mit selbsterklï¿½renden Namen 
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
        return new ArrayList<>(availableResourceBundles.keySet());
    }
}