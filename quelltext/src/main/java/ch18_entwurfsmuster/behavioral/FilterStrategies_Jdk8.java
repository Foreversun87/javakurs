package ch18_entwurfsmuster.behavioral;

import java.util.function.Predicate;

/**
 * Utility-Klasse zur Filterung mithilfe des Strategie-Musters
 * <br>
 * Die Klasse <code>FilterStrategies</code> enth�lt einige
 * Implementierungen von Filterstrategien, die das Interface <code>FilterStrategy</code>
 * erf�llen. Hier sind die Realisierungen <code>ClosedInterval</code> und <code>OpenInterval</code>
 * sowie <code>EvenFilter</code>. Dar�ber lassen sich offene und geschlossene Intervalle sowie
 * gerade Zahlen filtern.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class FilterStrategies_Jdk8
{
	/** Mathematisch: [lower,upper] --> lower <= value <= upper */
    // Umwandlung in Lambda nicht direkt möglich: lowerBound cannot be resolved to a variable	
    //final Predicate<Integer> closedInterval = value -> lowerBound <= value && value <= upperBound;
    
    // Abhilfe: Konstruktionsmethode
    static Predicate<Integer> closedInterval(final int lowerBound, final int upperBound)
    {
	    	if (upperBound < lowerBound)
	    		throw new IllegalArgumentException("lowerBound must be >= upperBound");
	    	
	    	return value -> lowerBound <= value && value <= upperBound;
    }

    /** Mathematisch: ]lower, upper[ --> lower < value < upper */
    static Predicate<Integer> openInterval(final int lowerBound, final int upperBound)
    {
	    	if (upperBound < lowerBound)
	    		throw new IllegalArgumentException("lowerBound must be >= upperBound");
	    	
	    	return value -> lowerBound < value && value < upperBound;
    }

    /** Mathematisch: ]lower, upper[ --> lower < value < upper */
    static Predicate<Integer> isPrime(final int lowerBound, final int upperBound)
    {
	    	if (upperBound < lowerBound)
	    		throw new IllegalArgumentException("lowerBound must be >= upperBound");
	    	
	    	return value -> lowerBound < value && value < upperBound;
    }
}