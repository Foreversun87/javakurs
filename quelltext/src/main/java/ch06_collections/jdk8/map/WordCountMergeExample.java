package ch06_collections.jdk8.map;

import static ch06_collections.jdk8.map.DemoData.createDemoData;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Beispielprogramm demonstriert verschiedene Methoden, um die Häufigkeiten von Wörtern in einem Text zu ermitteln mit merge().
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class WordCountMergeExample 
{
	public static void main(final String[] args)
	{
		final List<String> wordList = createDemoData();
		
		final Map<String, Integer> wordCounts = new TreeMap<>(); 
		for (final String word : wordList) 
		{
			wordCounts.merge(word, 1, Integer::sum); 
		}
		
		System.out.println(wordCounts);
	}
}