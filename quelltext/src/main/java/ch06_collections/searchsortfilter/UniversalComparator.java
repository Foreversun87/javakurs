package ch06_collections.searchsortfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Beispielklasse Komparator für Objekte, der sich aus verschiedenen Komparatoren zusammensetzen kann
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2016 by Michael Inden 
 */
public final class UniversalComparator<T> implements Comparator<T>
{
    private final List<Comparator<T>> comparators = new ArrayList<>();

    public UniversalComparator(final Comparator<T>... comparators)
    {
        this.comparators.addAll(Arrays.asList(comparators));
    }

    public int compare(final T obj1, final T obj2)
    {
        int ret = 0;

        for (final Comparator<T> comparator : comparators)
        {
            ret = comparator.compare(obj1, obj2);
            if (ret != 0)
                break;
        }

        return ret;
    }
}