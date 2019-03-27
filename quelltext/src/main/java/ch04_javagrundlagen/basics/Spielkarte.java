package ch04_javagrundlagen.basics;

import java.util.Objects;

/**
 * Beispielklasse zur Demonstration der Implementierung von equals()
 * 
 * @author Michael Inden
 * 
 * Copyright 2011,2014 by Michael Inden 
 */
public final class Spielkarte
{
    enum Farbe { KARO, HERZ, PIK, KREUZ }
    
    private final Farbe farbe;
    private final int   wert;

    public Spielkarte(final Farbe farbe, final int wert)
    {
        this.farbe = Objects.requireNonNull(farbe, "farbe must not be null");
        this.wert = wert;
    }
}
