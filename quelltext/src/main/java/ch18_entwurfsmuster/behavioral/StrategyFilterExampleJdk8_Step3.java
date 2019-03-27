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
 * erfïällt.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public final class StrategyFilterExampleJdk8_Step3
{
	// Step 1: Anpassung auf Streams und Predicate
	// Step 2: Umstellung auf Predicate<Integer>
    public static List<Integer> filterAll(final List<Integer> inputs, 
									      final Predicate<Integer> filterStrategy)
    {
    		return inputs.stream().
    		              filter(filterStrategy).
    		              collect(Collectors.toList());
    }

    // Step 3: EigenstÃ¤ndige Lmabdas definieren
    public static void main(final String[] args)
    {
        final List<Integer> inputs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("Filtering values for Intervall 2-7");
        final Predicate<Integer> closedInterval = FilterStrategies_Jdk8.closedInterval(2, 7);
        System.out.println("Using " + closedInterval + " " + filterAll(inputs, closedInterval));
        final Predicate<Integer> openInterval = FilterStrategies_Jdk8.openInterval(2, 7);
        System.out.println("Using " + openInterval + " " + filterAll(inputs, openInterval));
    }
}
