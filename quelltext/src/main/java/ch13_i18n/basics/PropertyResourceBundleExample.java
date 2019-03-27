package ch13_i18n.basics;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Beispielklasse zur Demonstration verschiedener ResourceBundles
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class PropertyResourceBundleExample
{
    public static void main(final String[] args) throws MissingResourceException
    {
    	final String BUNDLE_BASENAME = "ch13_i18n.PDFEditor";
    	
        showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.GERMANY));
        showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.UK));
    }

    private static void showTexts(final ResourceBundle resourceBundle)
    {
        final String txt_file = ResourceBundleUtils.getLangString(resourceBundle, ResourceKeys.txt_file);
        final String txt_open = ResourceBundleUtils.getLangString(resourceBundle, ResourceKeys.txt_open);

        System.out.println("txt_file='" + txt_file + "' / " + "txt_open='" + txt_open + "'");
    }

    private PropertyResourceBundleExample()
    {
    }
}