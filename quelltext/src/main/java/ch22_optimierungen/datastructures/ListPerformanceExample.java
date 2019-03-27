package ch22_optimierungen.datastructures;

import static ch22_optimierungen.datastructures.ListPerformanceExample.ACTION.ADD_END;
import static ch22_optimierungen.datastructures.ListPerformanceExample.ACTION.ADD_FRONT;
import static ch22_optimierungen.datastructures.ListPerformanceExample.ACTION.ADD_MIDDLE;
import static ch22_optimierungen.datastructures.ListPerformanceExample.ACTION.GET_AT;
import static ch22_optimierungen.datastructures.ListPerformanceExample.ACTION.ITERATE;
import static ch22_optimierungen.datastructures.ListPerformanceExample.ACTION.REMOVE_END;
import static ch22_optimierungen.datastructures.ListPerformanceExample.ACTION.REMOVE_FRONT;
import static ch22_optimierungen.datastructures.ListPerformanceExample.ACTION.REMOVE_MIDDLE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import ch04_javagrundlagen.basics.EqualsUtils;
import ch22_optimierungen.introduction.PerformanceUtils;

/**
 * Beispielprogramm zur Demonstration des Einflusses von unterschiedlichen
 * Listen-Datenstrukturen und unterschiedlichen Operationen (add, remove, iterate)
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class ListPerformanceExample
{
    public static enum ACTION { ADD_FRONT, ADD_MIDDLE, ADD_END, REMOVE_FRONT, 
                                REMOVE_MIDDLE, REMOVE_END, ITERATE, GET_AT };
    
    private static final SimplePerson OBJ_TO_ADD = new SimplePerson("Test", 42);
    private static final Map<String, TreeMap<ACTION, String>> results = new TreeMap<>();
    
    public static void main(final String[] args)
    {
        performListTests("ArrayList", new ArrayList<>());
        performListTests("ArrayList IK", new ArrayList<>(100_000));
        performListTests("LinkedList", new LinkedList<>());
        performListTests("Vector", new Vector<>());

        System.out.println("\n\nList Timing Results:");
        System.out.println("====================");
        
        System.out.print("Datastructure       ");
        printValues(ACTION.values());
        results.forEach((k,v) -> { System.out.print(String.format("%1$-20s", k + ": ")); printValues(v.values()); });
    }

    private static void printValues(final Object... values)
    {
        for (Object value : values)
        {
            System.out.print(value.toString() + ", ");
        }
        System.out.println();
    }

    private static void performListTests(final String dsName, 
                                         final List<SimplePerson> list)
    {
        final long[] maxElements = { 10_000, 100_000, 1_000_000 };

        for (final long max : maxElements)
        {
            System.out.println("Element count " + max);
            results.put(dsName + " " + max, new TreeMap<>());
            
            list.clear();            
            performMeasuredAction(dsName, list, max, ADD_FRONT,
                                  () -> addPersonFront(list, max));         
            performMeasuredAction(dsName, list, max, REMOVE_FRONT,
                                  () -> removePersonFront(list, max));
            
            list.clear();
            performMeasuredAction(dsName, list, max, ADD_MIDDLE,
                                  () -> addPersonMiddle(list, max));
            performMeasuredAction(dsName, list, max, REMOVE_MIDDLE,
                                  () -> removePersonMiddle(list, max)); 

            list.clear();
            performMeasuredAction(dsName, list, max, ADD_END,
                                  () -> addPersonLast(list, max));            
            performMeasuredAction(dsName, list, max, ITERATE,
                                  () -> iterate(list));            
            performMeasuredAction(dsName, list, max, GET_AT,
                                  () -> getAt(list, max));                   
            performMeasuredAction(dsName, list, max, REMOVE_END,
                                  () -> removePersonLast(list, max));
        }
    }

    private static long performMeasuredAction(final String dsName, 
                                              final List<SimplePerson> list, 
                                              final long max,
                                              final ACTION actionName,
                                              final Runnable action)
    {
        PerformanceUtils.startMeasure(dsName + " " + actionName);
        action.run();
        final long duration = PerformanceUtils.stopMeasure(dsName + " " + actionName);
        PerformanceUtils.printTimingResult(dsName + " " + actionName);
        
        results.get(dsName + " " + max).put(actionName, duration + " ms");
        return duration;
    }

    private static void addPersonLast(final List<SimplePerson> list, final long count)
    {
        for (int i = 0; i < count; i++)
        {
            list.add(OBJ_TO_ADD);
        }
    }

    private static void addPersonMiddle(final List<SimplePerson> list, final long count)
    {
        for (int i = 0; i < count; i++)
        {
            list.add(list.size() / 2, OBJ_TO_ADD);
        }
    }

    private static void addPersonFront(final List<SimplePerson> list, final long count)
    {
        for (int i = 0; i < count; i++)
        {
            list.add(0, OBJ_TO_ADD);
        }
    }

    private static void removePersonLast(final List<SimplePerson> list, final long count)
    {
        for (int i = 0; i < count; i++)
        {
            list.remove(list.size() - 1);
        }
    }

    private static void removePersonMiddle(final List<SimplePerson> list, final long count)
    {
        for (int i = 0; i < count; i++)
        {
            list.remove(list.size() / 2);
        }
    }

    private static void removePersonFront(final List<SimplePerson> list, final long count)
    {
        for (int i = 0; i < count; i++)
        {
            list.remove(0);
        }
    }

    private static void iterate(final List<SimplePerson> list)
    {
        final Iterator<SimplePerson> it = list.iterator();
        while (it.hasNext())
        {
            // access obj to avoid hot-spot-optimization
            final SimplePerson person = it.next();
            final int age = person.age;
        }
    }

    private static void getAt(final List<SimplePerson> list, final long count)
    {
        // access obj to avoid hot-spot-optimization
        final SimplePerson person = list.get((int) count / 2 - 1);
        final int age = person.age;
    }

    private static class SimplePerson
    {
        final String name;
        final int    age;

        public SimplePerson(final String name, final int age)
        {
            this.name = name;
            this.age = age;
        }

        public boolean equals(Object other)
        {
            if (other == null) // null sicher
                return false;

            if (this == other) // reflexiv
                return true;

            if (this.getClass() != other.getClass()) // pr�fe auf gleichen Typ
                return false;

            final SimplePerson otherPerson = (SimplePerson) other;
            return equalsImpl(otherPerson);
        }

        private boolean equalsImpl(final SimplePerson otherPerson)
        {
            return this.age == otherPerson.age && EqualsUtils.nullSafeEquals(this.name, otherPerson.name);
        }
    }

    private ListPerformanceExample()
    {
    }
}