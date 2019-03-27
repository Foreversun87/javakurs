package ch06_collections.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Beispielprogramm zur Demonstration der Immutabilty von Listen
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class UnmodifiableUnexpectedExample 
{   
    public static void main(final String[] arguments) 
    {
        final List<String> originalStrings = new ArrayList<>();
        originalStrings.add("Tim");
        originalStrings.add("Tom");
        originalStrings.add("Peter");
    
        final List<String> unmodifiables = Collections.unmodifiableList(originalStrings);
        final ImmutableList<String> immutables = ImmutableList.copyOf(originalStrings);
        System.out.println("Initial List of Strings:      " + unmodifiables);
        
        // Peter im Original entfernen ... indirekt auch in unmodifiableList()
        originalStrings.remove("Peter");
        
        System.out.println("Original List of Strings:     " + originalStrings);
        System.out.println("Unmodifiable List of Strings: " + unmodifiables);
        System.out.println("Immutable List of Strings:    " + immutables);
        
        // Entfernen nicht erlaubt
        unmodifiables.remove("Tom"); // java.lang.UnsupportedOperationException
    }
}