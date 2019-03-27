package ch12_javafx.observablecollections;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * Beispielprogramm zur Demonstration der ObservableList.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015, 2017 by Michael Inden 
 */
public class ObservableListExample
{
	public static void main(final String[] args) 
	{
		final String[] values = { "Orig1", "Orig2" };
		final ObservableList<String> content = 
		                             FXCollections.observableArrayList(values);
		
		final ListChangeListener<String> changeReporter = 
		                                 change -> reportChanges(change);
		                                 
		content.addListener(changeReporter);
		
		System.out.println("modifications");
		performChanges(content);

		System.out.println("rotate()");
		FXCollections.rotate(content, 2);
		
		System.out.println("shuffle()");
		FXCollections.shuffle(content);
	}

	private static void performChanges(final ObservableList<String> content)
	{
		content.addAll("A", "B", "C");
		content.removeAll("Orig1", "Orig2");
		content.add("1");
		content.add("2");
	}

	static void reportChanges(ListChangeListener.Change<? extends String> change) 
	{
		System.out.println("Changed to: " + change.getList());
	}
}