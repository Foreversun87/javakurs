package ch18_entwurfsmuster.behavioral;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ch18_entwurfsmuster.behavioral.FilterStrategies.ClosedInterval;
import ch18_entwurfsmuster.behavioral.FilterStrategies.OpenInterval;

/**
 * Beispielprogramm zur Filterung mithilfe des Strategie-Musters
 * <br>
 * Die Klasse <code>StrategyFilterExample</code> zeigt eine Filterung
 * von einer Liste von Integer-Werten und zwei Filter-Kriterien
 * (offenes und geschlossenes Intervall).
 * Als Erweiterung zum einfï¿½hrenden Beispiel  <code>StrategyFilterBaseExample</code>
 * wird die Filterung hier nicht in der Methode <code>filterAll()</code> ausprogrammiert,
 * sondern stattdessen an eine <code>FilterStrategy</code> delegiert. Dieses Interface
 * wird hier von den beiden Realisierungen <code>ClosedInterval</code> und <code>OpenInterval</code>
 * erfällt.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public final class StrategyFilterExampleJdk8_Step1
{
	// Anpassung auf Streams und Predicate
    public static List<Integer> filterAll(final List<Integer> inputs, 
									      final FilterStrategy filterStrategy)
    {
    		final Predicate<Integer> predicate = value -> filterStrategy.acceptValue(value);
    		return inputs.stream().
    		              filter(predicate).
    		              collect(Collectors.toList());
    }

    public static void main(final String[] args)
    {
        final List<Integer> inputs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("Filtering values for Intervall 2-7");
        final FilterStrategy closedInterval = new ClosedInterval(2, 7);
        System.out.println("Using " + closedInterval + " " + filterAll(inputs, closedInterval));
        final FilterStrategy openInterval = new OpenInterval(2, 7);
        System.out.println("Using " + openInterval + " " + filterAll(inputs, openInterval));
    }
}
