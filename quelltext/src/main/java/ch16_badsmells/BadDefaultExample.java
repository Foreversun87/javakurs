package ch16_badsmells;

/**
 * Beispiel für Falölthrough und default mitten in case-Anweisungen
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public final class BadDefaultExample
{
    public static void main(final String[] args)
    {
        int value =  (int) (6 * Math.random());
        switch (value)
        {
            case 0:
            case 2:
            case 4:
                System.out.println(value + " accepted even value [0 - 4]");
            default:
                System.out.println(value + " performing default action");
                break;
            case 1:    
            case 3:
                System.out.println(value + " is odd");
        }
    }

    private BadDefaultExample()
    {
    }
}
