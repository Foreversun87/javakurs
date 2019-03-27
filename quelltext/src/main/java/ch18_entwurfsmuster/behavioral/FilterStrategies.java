package ch18_entwurfsmuster.behavioral;

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
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class FilterStrategies
{
	/** Mathematisch: [lower,upper] --> lower <= value <= upper */
	public static class ClosedInterval implements FilterStrategy
	{
	    private final int lowerBound;
	    private final int upperBound;
	
	    public ClosedInterval(final int lowerBound, final int upperBound)
	    {
	    	if (upperBound < lowerBound)
	    		throw new IllegalArgumentException("lowerBound must be <= upperBound");
	    	
	        this.lowerBound = lowerBound;
	        this.upperBound = upperBound;
	    }
	
	    @Override
	    public boolean acceptValue(final int value)
	    {
	        return lowerBound <= value && value <= upperBound;
	    }
	
	    @Override
	    public String toString()
	    {
	        return "ClosedInterval [" + lowerBound + ", " + upperBound + "]";
	    }
	}

    /** Mathematisch: ]lower, upper[ --> lower < value < upper */
    public static class OpenInterval implements FilterStrategy
    {
        private final int lowerBound;
        private final int upperBound;

        public OpenInterval(final int lowerBound, final int upperBound)
        {
        	if (upperBound < lowerBound)
        		throw new IllegalArgumentException("lowerBound must be <= upperBound");

        	this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        @Override
        public boolean acceptValue(final int value)
        {
            return lowerBound < value && value < upperBound;
        }

        @Override
        public String toString()
        {
            return "OpenInterval ]" + lowerBound + ", " + upperBound + "[";
        }
    }

    /** Filter auf gerade Zahlen */
    public static class EvenFilter implements FilterStrategy
    {
        @Override
        public boolean acceptValue(final int value)
        {
            return value % 2 == 0;
        }

        @Override
        public String toString()
        {
            return "EvenFilter";
        }
    }
}