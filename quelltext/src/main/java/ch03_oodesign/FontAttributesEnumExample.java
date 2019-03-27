package ch03_oodesign;
 
import static ch03_oodesign.FontAttributesEnum.BOLD;
import static ch03_oodesign.FontAttributesEnum.ITALIC;
import static ch03_oodesign.FontAttributesEnum.UNDERLINE;

import java.util.EnumSet;

/**
 * Beispiel der Nutzung einer einfachen Aufzählung als enum und deren Kombination mit EnumSet
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public class FontAttributesEnumExample
{      
    public static void main(final String args[])
    {
        final EnumSet<FontAttributesEnum> fontStyles = EnumSet.of(BOLD, ITALIC);

        final boolean isUnderline = fontStyles.contains(UNDERLINE);
        final boolean isBold = fontStyles.contains(BOLD);

        System.out.println("isUnderline? " + isUnderline);
        System.out.println("isBold?      " + isBold);        

        // nützliche weitere Methoden 
        System.out.println("All  " + EnumSet.allOf(FontAttributesEnum.class));
        System.out.println("None " + EnumSet.noneOf(FontAttributesEnum.class));        
    }
}