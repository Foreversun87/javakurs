package ch99_swing_gui.painting_in_components;

/**
 * Beispielklasse zur Modellierung eines Paares von zwei Werten zweier (unterschiedlicher) Typen T1 und T2. 
 * <br>
 * <b>Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class Pair<T1, T2>
{
    private final T1 first;
    private final T2 second;

    public Pair(final T1 first, final T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst()
    {
        return first;
    }

    public T2 getSecond()
    {
        return second;
    }
}
