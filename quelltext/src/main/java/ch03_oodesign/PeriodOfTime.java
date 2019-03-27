package ch03_oodesign;

import java.util.Date;
import java.util.Objects;

/**
 * Beispielklasse zur Demonstration der Technik Immutable-Klasse
 * mit referenzierten anderen Klassen
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public final class PeriodOfTime 
{  
	private final Date start;  
	private final Date end;  

	public PeriodOfTime(final Date start, final Date end) 
	{  
		Objects.requireNonNull(start, "start must not be null");
		Objects.requireNonNull(end, "end must not be null");
		
		if (start.after(end))  
			throw new IllegalArgumentException(start + " must be <= " + end);  

		this.start = start;  
		this.end = end;  
	}  

	public Date getStart()   {	return start;	}  
	public Date getEnd()     {	return end;		}  
}  
