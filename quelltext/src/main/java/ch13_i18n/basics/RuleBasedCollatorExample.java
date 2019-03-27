package ch13_i18n.basics;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Arrays;
import java.util.Locale;

/**
 * Diese Klasse demonstriert die Auswirkungen verschiedener Regeln
 * für den Vergleich mit der Klasse Collator. 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class RuleBasedCollatorExample
{
    private static final String[] INPUT_DATA = { "a", "ä", "A", "Ä", 
                                                 "b", "B", "c", "C", 
                                                 "aaa", "abc", "BBB", "bbb", "ccc", "CCC" };

    public static void main(final String[] args) throws ParseException
    {
        // Natural ordering -> Sonderbuchstaben alle hinter normalem Alphabet
        String[] exampleValues = INPUT_DATA.clone();
        Arrays.sort(exampleValues);
        System.out.println("Natural:\n" + Arrays.toString(exampleValues) + "\n");

        final Collator collator = Collator.getInstance(Locale.GERMANY);
        exampleValues = INPUT_DATA.clone();
        Arrays.sort(exampleValues, collator);
        System.out.println("GERMANY:\n" + Arrays.toString(exampleValues) + "\n");

        // erst komplett alle Kleinbuchstaben, dann Großbuchstaben
        final String rules = "< a < b < c < A < B < C";
        sortRuleBased(rules, INPUT_DATA.clone());

        // Alphabetisch; erst Kleinbuchstabe, dann Großbuchstabe
        final String rules2 = "< a < A < b < B < c < C";
        sortRuleBased(rules2, INPUT_DATA.clone());

        // Alphabetische Sortierung mit Besonderheit für A und C:
        // erst Kleinbuchstabe, dann Großbuchstabe, für B andersherum
        final String rules3 = "< A, a < b, B < C, c";
        sortRuleBased(rules3, INPUT_DATA.clone());
    }

    private static void sortRuleBased(final String rules, final String[] exampleValues) throws ParseException
    {
        final Collator collator = new RuleBasedCollator(rules);
        Arrays.sort(exampleValues, collator);
        System.out.println("Rules '" + rules + "' order:\n" + Arrays.toString(exampleValues) + "\n");
    }

}
