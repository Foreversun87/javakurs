package ch06_collections.utility;

import java.util.List;

/**
 * Auf das Wesentliche gekürzte, ältere Utility-Klasse 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class OldStyleUtilityClass
{   
    public static final void addSampleModelElement(final List elements)
    {
        elements.add("Unexpected element of wrong string type!");
    }
    
    public static void printListElements(final String title, 
                                         final List elements)
    {
        System.out.println(title);
        for (int i = 0; i < elements.size(); i++)
        {
            System.out.println(i + ": " + elements.get(i));
        }
    }
    
    // ...
}
