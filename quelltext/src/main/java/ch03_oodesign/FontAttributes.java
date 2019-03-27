package ch03_oodesign;

/**
 * Beispiel einer einfachen Aufzählung mit int-Konstanten und deren Kombination
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class FontAttributes
{
    public static final int NORMAL    = 0;
    public static final int BOLD      = 1;
    public static final int ITALIC    = 2;
    public static final int UNDERLINE = 4;

    private FontAttributes()
    {
        // avoid construction of this class
    }
}
