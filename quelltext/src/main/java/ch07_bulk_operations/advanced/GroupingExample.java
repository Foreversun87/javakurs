package ch07_bulk_operations.advanced;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm zur Demonstration der Gruppierung
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class GroupingExample
{
	public static void main(final String[] args)
	{
	   final String[] names = { "Tom", "Tim", "Mike", "Kay", "Micha", "Kai" };
	    
	   System.out.println(groupBy(Stream.of(names), GroupingExample::toFirstChar));
	}
	
	public static <T> Map<T, List<T>> groupBy(final Stream<T> stream,
	                                          final Function<T, T> groupFunction)
	{
	    return stream.collect(Collectors.groupingBy(groupFunction));
	}
	
	private static String toFirstChar(final String name) 
	{
	    return name.substring(0, 1).toUpperCase();
	} 
}
