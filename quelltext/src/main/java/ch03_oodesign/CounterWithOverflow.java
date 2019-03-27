package ch03_oodesign;

/**
 * Beispiel eines Zählers - der bei einem bestimmten Stand einen Überlauf
 * verursacht und die Zählung wieder von 0 beginnt
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden
 */
public class CounterWithOverflow extends Counter
{
    private static final int COUNTER_MAX   = 100;

    private final Counter    overflowCount = new Counter();

    public int overflowCount()
    {
        return overflowCount.currentValue();
    }

    public void reset()
    {
        super.reset();
        overflowCount.reset();
    }

    public void increment()
    {
        if (currentValue() == COUNTER_MAX - 1)
        {
            super.reset();
            overflowCount.increment();
        }
        else
        {
            super.increment();
        }
    }
}