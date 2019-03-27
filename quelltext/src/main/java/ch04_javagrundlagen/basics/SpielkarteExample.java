package ch04_javagrundlagen.basics;

import java.util.ArrayList;
import java.util.Collection;

import ch04_javagrundlagen.basics.Spielkarte.Farbe;

/**
 * Beispielklasse zur Demonstration der Suche in Collections ohne 
 * Implementierung von equals() in der eigenen Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class SpielkarteExample
{
    public static void main(final String[] args)
    {
    	// JDK 7: Diamond Operator: ArrayList<> statt ArrayList<Spielkarte>
        final Collection<Spielkarte> spielkarten = new ArrayList<>();

        spielkarten.add(new Spielkarte(Farbe.HERZ, 7));
        // PIK 8 einfügen 
        spielkarten.add(new Spielkarte(Farbe.PIK, 8));
        spielkarten.add(new Spielkarte(Farbe.KARO, 9));

        // Finden wir eine PIK 8? 
        final boolean gefunden = spielkarten.contains(new Spielkarte(Farbe.PIK, 8));
        System.out.println("gefunden=" + gefunden);
    }
}
