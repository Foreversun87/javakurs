package ch06_collections.basics;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Beispielprogramm zur Demonstration der grundsätzlichen Funktionalität von Mengen und dem Interface Set
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstSetExample
{
    public static void main(final String[] args)
    {
        fillAndExploreHashSet();
        fillAndExploreTreeSet();
    }

    private static void fillAndExploreHashSet()
    {
        final Set<String> hashSet = new HashSet<>();
        addStringDemoData(hashSet);
        System.out.println(hashSet);

        // StringBuilder definiert selbst weder hashCode() noch equals()
        final Set<StringBuilder> hashSetSurprise = new HashSet<>();
        addStringBuilderDemoData(hashSetSurprise);
        System.out.println(hashSetSurprise);
    }

    private static void fillAndExploreTreeSet()
    {
        final Set<String> treeSet = new TreeSet<>();
        addStringDemoData(treeSet);
        System.out.println(treeSet);

        // StringBuilder implementiert nicht Comparable => 
        // Exception in thread "main" java.lang.ClassCastException: 
        // java.lang.StringBuilder cannot be cast to java.lang.Comparable
        final Set<StringBuilder> treeSetSurprise = new TreeSet<>();
        addStringBuilderDemoData(treeSetSurprise);
        System.out.println(treeSetSurprise);
    }

    private static void addStringDemoData(final Set<String> set)
    {
        set.add("Hallo");
        set.add("Welt");
        set.add("Welt");
    }

    private static void addStringBuilderDemoData(final Set<StringBuilder> set)
    {
        set.add(new StringBuilder("Hallo"));
        set.add(new StringBuilder("Welt"));
        set.add(new StringBuilder("Welt"));
    }
}