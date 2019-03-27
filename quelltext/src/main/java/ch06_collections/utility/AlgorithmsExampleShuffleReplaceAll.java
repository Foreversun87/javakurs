package ch06_collections.utility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration der Methoden shuffle() und replaceAll()
 *
 * @author Michael Inden
 *
 * Copyright 2011, 2014, 2017 by Michael Inden
 */
public final class AlgorithmsExampleShuffleReplaceAll
{
    public static void main(final String[] args)
    {
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Ersetzungen
        Collections.replaceAll(numbers, 2, 7);
        Collections.replaceAll(numbers, 3, 7);
        System.out.println("All numbers after replace: " + numbers);

        // Umordnen
        Collections.shuffle(numbers);
        System.out.println("All numbers after shuffle: " + numbers);
        System.out.println("#7: " + Collections.frequency(numbers, 7));
    }

    private AlgorithmsExampleShuffleReplaceAll()
    {
    }
}
