package ch03_oodesign;

import static ch03_oodesign.FontAttributes.BOLD;
import static ch03_oodesign.FontAttributes.ITALIC;
import static ch03_oodesign.FontAttributes.UNDERLINE;

/**
 * Beispiel einer einfachen Aufzählung mit int-Konstanten und deren Kombination
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class FontAttributesExample
{
    private FontAttributesExample()
    {
        // avoid construction of this class
    }

    public static void main(final String args[])
    {
        final int fontStyles = BOLD | ITALIC;

        // Variante 1: Prüfe Attribut und zeige Implementierungsdetails 
        final boolean isUnderline = (fontStyles & UNDERLINE) == UNDERLINE; // V1
        
        // Variante 2+3: Prüfe Attribute, Abstraktion von Implementierungsdetails 
        final boolean isBold = isBold(fontStyles); // V2               
        final boolean isItalic = isAttributeEnabled(fontStyles, ITALIC); // V3 

        System.out.println("isUnderline? " + isUnderline);
        System.out.println("isBold?      " + isBold);   
        System.out.println("isItalic?    " + isItalic);
    }

    // Variante 2 
    private static boolean isBold(final int fontStyles)
    {
        return (fontStyles & BOLD) == BOLD;
    }

    // Variante 3
    private static boolean isAttributeEnabled(final int fontStyles, final int attibuteValue)
    {
        return (fontStyles & attibuteValue) == attibuteValue;
    }
}
