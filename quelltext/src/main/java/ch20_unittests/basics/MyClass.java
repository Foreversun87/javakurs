package ch20_unittests.basics;

import java.util.List;
import java.util.Objects;

/**
 * Beispiel einer Rabattberechnung: Verbesserte zweite Variante
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class MyClass 
{
	/* private */ static final int BASE = 10_000;
	private final int value;

	public MyClass(final int offset)
	{
		this.value = BASE + offset;
	}
 
	public int getValue()
	{
		return value;
	}
	
	public int calc(final List<Integer> values)
	{
		//Preconditions.checkNotNull(elements, "parameter 'elements' must not be null");
		//Preconditions.checkArgument(elements != null, "parameter 'elements' must not be null");
		Objects.requireNonNull(values, "parameter 'values' must not be null");
		
		return values.stream().mapToInt(i -> i).sum();
	}
}