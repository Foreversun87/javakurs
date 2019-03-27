package ch04_javagrundlagen.basics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import ch04_javagrundlagen.basics.SpielkarteWithEqualsExample.Spielkarte.Farbe;

/**
 * Beispielklasse zur Demonstration der Suche in Collections 
 * mit Implementierung von equals() in der eigenen Klasse
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class SpielkarteWithEqualsExample
{
    public static void main(final String[] args)
    {
        final Collection<Spielkarte> spielkarten = new ArrayList<>();

        spielkarten.add(new Spielkarte(Farbe.HERZ, 7));
        // PIK 8 einf�gen 
        spielkarten.add(new Spielkarte(Farbe.PIK, 8));
        spielkarten.add(new Spielkarte(Farbe.KARO, 9));

        // Finden wir eine PIK 8? 
        final boolean gefunden = spielkarten.contains(new Spielkarte(Farbe.PIK, 8));
        System.out.println("gefunden=" + gefunden);
    }
    
    public static final class Spielkarte
    {
        public enum Farbe 
        {
            KARO, HERZ, PIK, KREUZ
        }
        
        private final Farbe farbe;
        private final int   wert;

        public Spielkarte(final Farbe farbe, final int wert)
        {
            this.farbe = farbe;
            this.wert = wert;
        }

        @Override
        public boolean equals(Object other)
        {
            if (other == null) // Null-Akzeptanz
                return false;

            if (this == other) // Reflexivit�t 
                return true;

            if (this.getClass() != other.getClass()) // Typgleichheit sicherstellen 
                return false;

            //  Enum mit equals, int mit Wertevergleich 
            final Spielkarte karte = (Spielkarte) other;
            return this.farbe.equals(karte.farbe) && this.wert == karte.wert;
        }
        
        @Override
        public int hashCode()
        {
        		return Objects.hash(this.wert, this.farbe);
        }
    }
}
