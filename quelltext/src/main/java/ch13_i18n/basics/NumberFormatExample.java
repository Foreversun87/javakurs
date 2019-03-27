package ch13_i18n.basics;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Beispielklasse zur Demonstration der Formatierung von Zahlen mit unterschiedlichen Typen von
 * NumberFormat-Instanzen 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class NumberFormatExample
{
    public static void main(final String[] args)
    {
        final double value = 12345.67890;

        NumberFormat numFormat = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println("getInstance de DE\t\t" + numFormat.format(value));

        numFormat = NumberFormat.getNumberInstance(Locale.US);
        System.out.println("getNumberInstance en US\t\t" + numFormat.format(value));

        numFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println("getCurrencyInstance de DE\t" + numFormat.format(value));

        numFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("getCurrencyInstance en US\t" + numFormat.format(value));

        numFormat = NumberFormat.getCurrencyInstance(Locale.ITALY);
        System.out.println("getCurrencyInstance it IT\t" + numFormat.format(value));

        numFormat = NumberFormat.getCurrencyInstance(LocaleExample.LOCALE_ITALIAN_SWISS);
        System.out.println("getCurrencyInstance it CH\t" + numFormat.format(value));

        numFormat = NumberFormat.getCurrencyInstance(new Locale("zh", "HK"));
        System.out.println("getCurrencyInstance zh HK\t" + numFormat.format(value));

        // Zahlenformat stammt aus Sprache, Währungszeichen sprachabhängig aus Land
        numFormat = NumberFormat.getCurrencyInstance(new Locale("de", "HK"));
        System.out.println("getCurrencyInstance de HK\t" + numFormat.format(value));
    }

    private NumberFormatExample()
    {
    }
}
