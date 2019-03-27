package ch09_multithreading.communication;

/**
 * Dummy-Klasse zur Modellierung eines beliebigen Gegenstands der
 * Producer-Consumer-Ansatz verarbeitet wird
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class Item
{
    private final String name;

    public Item(final String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "[Item] " + name;
    }
}