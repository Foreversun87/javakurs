package ch06_collections.jdk8.map;

import static ch06_collections.jdk8.map.DemoData.createDemoData;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Beispielprogramm demonstriert verschiedene Methoden, um die Häufigkeiten von Wörtern in einem Text zu ermitteln zunächst ohne JDK 8.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class WordCountPreJDK8Example 
{
	public static void main(final String[] args)
	{
		final List<String> wordList = createDemoData();
		
		final Map<String, Integer> wordCounts = new TreeMap<>(); 
		
		for (final String word : wordList) 
		{
			if (wordCounts.containsKey(word))
			{
				final Integer oldValue = wordCounts.get(word);			 
				wordCounts.put(word,  oldValue + 1);
			}
			else
			{
				wordCounts.put(word, 1);
			}
		}
		
		System.out.println(wordCounts);
	}
}