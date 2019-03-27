package ch12_javafx.observablecollections;

import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

/**
 * Beispielprogramm demonstriert Fallstricke beim Einsatz von SortedList.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class SortingProblemsExample
{
    public static void main(final String[] args)
    {
        final String[] names = { "Kai", "Micha", "Andi", "Andy", "Tom", "Matze", "Mike", "Florian" };

        final ObservableList<String> entries = FXCollections.observableArrayList(names);
        final SortedList<String> entriesSorted1 = new SortedList<>(entries, Comparator.naturalOrder());
        final SortedList<String> entriesSorted2 = entries.sorted(Comparator.naturalOrder());

        System.out.println(entriesSorted1);
        System.out.println(entriesSorted2);
    }
}
