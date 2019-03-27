package ch06_collections.jdk8.map;

import java.util.Arrays;
import java.util.List;

/**
 * Hilfsklasse zur Definition von Eingabedaten
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class DemoData
{
    public static List<String> createDemoData()
    {
        final List<String> wordList = Arrays.asList("Dies", "ist", "eine", "Liste", "eine", "Liste", "kann", "Worte",
                                                    "enthalten", "Dies", "ist", "das", "Ende", "der", "Liste");
        return wordList;
    }
}