package ch04_javagrundlagen.inner;

/**
 * Beispielprogramm für den Einsatz innerer Klassen im Kontext von Methoden
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class MethodLocalInnerClassExample
{
	public static void main(final String[] args)
	{
	    int counter = 100;
	    final int constant = 200;
	
	    // Keine Sichtbarkeitsmodifier erlaubt, public usw. => Compile-Error  
	    /* public */ class MethodLocalInnerClass     
	    {
	        public void printVar()
	        {
	            System.out.println("counter = " + counter ); // => Compile-Error 
	            System.out.println("constant = " + constant);
	        }
	    }
		// counter++;
	    new MethodLocalInnerClass().printVar();
	}
}