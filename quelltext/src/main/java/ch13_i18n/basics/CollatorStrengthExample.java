package ch13_i18n.basics;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * Diese Klasse demonstriert die Auswirkungen verschiedener "Strenge"-Werte
 * fï¿½r den Vergleich mit der Klasse Collator. Dazu wird ein String-Array
 * mit passenden Werten initialisiert, die ideal geeignet sind, die
 * Auswirkungen beobachten zu kï¿½nnen.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class CollatorStrengthExample
{
    // Diese Werte werden verglichen, inkl. spezieller Unicode-Zeichen }$
    private static final String[] EXAMPLE_VALUES = { "\u0001BC", "\u0002BC", 
                                                     "ABC", "ÄBC", "abc",
                                                     "Maße", "Masse" };

    enum CollatorStrength 
    {
        PRIMARY(Collator.PRIMARY), SECONDARY(Collator.SECONDARY), 
        TERTIARY(Collator.TERTIARY), IDENTICAL(Collator.IDENTICAL);

        final int collatorStrengthValue;

        CollatorStrength(final int collatorStrengthValue)
        {
            this.collatorStrengthValue = collatorStrengthValue;
        }
    }
    
    public static void main(final String[] args)
    {
        System.out.println("CollatorStrengthExample");
        System.out.println("Values: " + Arrays.toString(EXAMPLE_VALUES) + "\n");

        final Collator collator = Collator.getInstance(Locale.GERMANY);

        for (final CollatorStrength strength : CollatorStrength.values())
        {
            // Achtung: Kopie des Arrays ist wichtig, da der sort-Befehl  
            // ansonsten das Ausgangsarray ï¿½ndern wï¿½rde! 
            sortByCollator(collator, strength, EXAMPLE_VALUES.clone());
        }
    }

    private static void sortByCollator(final Collator collator,
                                       final CollatorStrength collatorStrength, 
                                       final String[] exampleValues)
    {
        // Gemï¿½ï¿½ Strenge sortieren und ausgeben  
        collator.setStrength(collatorStrength.collatorStrengthValue);
        Arrays.sort(exampleValues, collator);
        System.out.println("Collator-Strength: " + collatorStrength + " => "
                + Arrays.toString(exampleValues));

        // Aufbereiten der Vergleichsordnung  
        final String orderingInfo = buildOrderingInfo(collator, exampleValues);
        System.out.println("Using ordering: [" + orderingInfo + "]" + "\n");
    }

    // ...
    
    private static String buildOrderingInfo(final Collator collator, final String[] exampleValues)
    {
        String orderingInfo = "";
        for (int i = 0; i < exampleValues.length-1; i++)
        {
            orderingInfo += buildComparatorInfo(collator, exampleValues[i], exampleValues[i + 1]);
            // add ", " for all but not last entry
            if (i < exampleValues.length - 2)
                orderingInfo += ", ";
        }
        return orderingInfo;
    }

    private static <T> String buildComparatorInfo(final Comparator<T> comparator, final T obj1, final T obj2)
    {
        final String order;
        if (comparator.compare(obj1, obj2) < 0)
            order = " < ";
        else if (comparator.compare(obj1, obj2) > 0)
            order = " > ";
        else
            order = " = ";

        return "'" + obj1 + "'" + order + "'" + obj2 + "'";
    }

    private CollatorStrengthExample()
    {
    }
}