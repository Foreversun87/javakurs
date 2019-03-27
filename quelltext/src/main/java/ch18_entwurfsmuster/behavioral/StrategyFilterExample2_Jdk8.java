package ch18_entwurfsmuster.behavioral;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Beispielprogramm zur Filterung mithilfe des Strategie-Musters
 * <br>
 * Die Klasse <code>StrategyFilterExample2</code> zeigt eine Filterung
 * von einer Liste von Integer-Werten.
 * Es wird hier die Kombination verschiedener Filterkriterien demonstriert.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class StrategyFilterExample2_Jdk8
{
    public static List<Integer> filterAll(final List<Integer> inputs, 
		      final Predicate<Integer> filterStrategy)
    {
    		return inputs.stream().
    					filter(filterStrategy).
    					collect(Collectors.toList());
    }

    public static void main(final String[] args)
    {
        final List<Integer> inputs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // EvenFilter und OddFilter (InverseEvenFilter)  
        // lässt sich direkt ausdrüken, da direkt auf Wert berechenbar
        // final FilterStrategy evenFilter = new EvenFilter();
        final Predicate<Integer> evenFilter = value -> value % 2 == 0;
        System.out.println(evenFilter + ": " + filterAll(inputs, evenFilter));

        // InverseFilter wird nicht mehr benötigt => negate()
        // final FilterStrategy oddFilter = new InverseFilter(evenFilter);
        final Predicate<Integer> oddFilter = evenFilter.negate();
        System.out.println(oddFilter + ": " + filterAll(inputs, oddFilter));

        // PrimeFilter und InversePrimeFilter
        // Trick Nutzung der bisherigen Implementierung
        final Predicate<Integer> primeFilter = value -> new PrimeFilter().acceptValue(value);
        System.out.println(primeFilter + ": " + filterAll(inputs, primeFilter));

        final Predicate<Integer> inversePrimeFilter = primeFilter.negate();
        System.out.println(inversePrimeFilter + ": " + filterAll(inputs, inversePrimeFilter));
    }
}
		