package ch12_javafx.observablecollections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

/**
 * Beispielprogramm demonstriert den korrekten Einsatz von SortedList.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class SortingProblemsSolvedExample
{
    public static void main(final String[] args)
    {
        final String[] names = { "Kai", "Micha", "Andi", "Andy", "Tom", "Matze", "Mike", "Florian" };

        final ObservableList<String> entries = FXCollections.observableArrayList(names);
        final SortedList<String> entriesSorted1 = new SortedList<>(entries);
        final SortedList<String> entriesSorted2 = entries.sorted();

        System.out.println(entriesSorted1);
        System.out.println(entriesSorted2);
    }
}
