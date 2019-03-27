package ch06_collections.searchsortfilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration der Binärsuche 
 * (mit natürlicher Ordnung und separat angegebenem Comparator)
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class BinarySearchExample
{
    public static void main(final String[] args)
    {
        final List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13);
        final List<Integer> morePrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        
        // Suche nach 7 und 14 
        System.out.println(primes); // [2, 3, 5, 7, 11, 13]
        System.out.println(Collections.binarySearch(primes, 7)); // 3
        System.out.println(Collections.binarySearch(primes, 14)); // -7

        // Anderes Sortierkriterium anwenden, um Versagen der Suche zu provozieren 
        Collections.sort(primes, Collections.reverseOrder());
        System.out.println(primes); // [13, 11, 7, 5, 3, 2]
        System.out.println(Collections.binarySearch(primes, 7)); // 2 => Merkwürdigkeit durch Zufallstreffer
        // beim Teilen der Eingabemenge, die 7 ist genau dort, wo geteilt wird
        System.out.println(Collections.binarySearch(primes, 14)); // -7 => Einfügepos: 6
        // Sortierkriterium an binarySearch übergeben, um korrekte Suche zu erreichen 
        System.out.println(Collections.binarySearch(primes, 7, Collections.reverseOrder())); // 2
        System.out.println(Collections.binarySearch(primes, 14, Collections.reverseOrder())); // -1 => Einfügepos: 0
        
        
        // Suche nach 7 und 14 in erweiterter Menge 
        System.out.println(morePrimes); // [2, 3, 5, 7, 11, 13, 17, 19]
        System.out.println(Collections.binarySearch(morePrimes, 7)); // 3
        System.out.println(Collections.binarySearch(morePrimes, 14)); // -7
        
        // Anderes Sortierkriterium anwenden, um Versagen der Suche zu provozieren 
        Collections.sort(morePrimes, Collections.reverseOrder());
        System.out.println(morePrimes); // [19, 17, 13, 11, 7, 5, 3, 2]
        System.out.println(Collections.binarySearch(morePrimes, 7)); // -1
        System.out.println(Collections.binarySearch(morePrimes, 14)); // -9
        System.out.println(Collections.binarySearch(morePrimes, 7, Collections.reverseOrder())); // 4
        System.out.println(Collections.binarySearch(morePrimes, 14, Collections.reverseOrder())); // -3
    }

    private BinarySearchExample()
    {
    }
}
