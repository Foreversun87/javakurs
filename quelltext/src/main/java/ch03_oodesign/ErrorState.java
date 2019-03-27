package ch03_oodesign;

/**
 * Beispiel einer einfachen Aufzählung gemäß dem Enum-Muster
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class ErrorState
{
    public static final ErrorState OK          = new ErrorState(0, "Ok");

    public static final ErrorState INVALID_POS = new ErrorState(3, "Ungültige Positionsangabe");

    public static final ErrorState BUFFER_FULL = new ErrorState(8, "Empfangspuffer voll");

    private final int              value;

    private final String           description;

    private ErrorState(final int value, final String description)
    {
        this.value = value;
        this.description = description;
    }

    public int getValue()
    {
        return value;
    }

    public String getDescription()
    {
        return description;
    }
}