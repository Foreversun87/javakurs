package ch22_optimierungen.cpubound;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm zur Demonstration des Einflusses von Auto-Boxing auf die Performance
 * <br>
 * Dazu werden jeweils 1.000.000 Objekte der Klassen Person bzw. PersonOptimzedEquals erzeugt und
 * in einer Liste gespeichert. Ein weiteres zu suchendes Objekt wird am Ende der Liste eingefügt.
 * Zum Ermitteln der Laufzeit erfolgt eine Suche in der Liste. Diese wird 1 Mal, 10 Mal und
 * 1.000 Mal durchgeführt, um aussagekräftige Werte zu erhalten. 
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class CpuBoundOptimizationExample 
{
	public static void main(final String[] args) 
	{
		// Achtung: erstmal int-Konstanten, im long-Wertebereich explizit zu long-Konstanten machen
		final long[] loopCounts = { 1_000_000, 10_000_000, 100_000_000,  
						            1_000_000_000L, 10_000_000_000L, 100_000_000_000L };
	
		for (final long loopCount : loopCounts)
		{
			System.out.println("LoopCount: " + NumberFormat.getIntegerInstance().format(loopCount));
			System.out.println("-----------------------------------------");
	
			final long start1 = System.nanoTime();
	
			long sumAsPrimitive = 0;
			for (long i = 0; i < loopCount; i++)
			{
				sumAsPrimitive += 1;
			}
	
			final long end1 = System.nanoTime();
			System.out.println("Primitive sum took: " + 
			                   TimeUnit.NANOSECONDS.toMillis(end1 - start1));
			// Zugriff auf die Variable, um Optimierung zu vermeiden
			System.out.println("Primitive sum is: " + sumAsPrimitive);  
	
			final long start2 = System.nanoTime();
	
			Long sumAsWrapper = 0L;
			for (long i = 0; i < loopCount; i++)
			{
				// Hier kommt es zu Auto-Boxing und Auto-Unboxing
				sumAsWrapper += 1;
			}
	
			final long end2 = System.nanoTime();
			System.out.println("Wrapper/Auto-/(Un-)Boxing sum took: " + 
			                   TimeUnit.NANOSECONDS.toMillis(end2 - start2));
			// Zugriff auf die Variable, um Optimierung zu vermeiden
			System.out.println("Wrapper sum is: " + sumAsWrapper);  
	
			System.out.println("-----------------------------------------");
			
			final double factor = (end2 - start2) / (double) (end1 - start1);
			System.out.println(String.format("Factor %.2f", factor));
			System.out.println("-----------------------------------------");
		}
	}
}