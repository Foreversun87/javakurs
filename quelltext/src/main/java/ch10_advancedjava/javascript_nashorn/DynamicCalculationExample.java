package ch10_advancedjava.javascript_nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Beispielprogramm zeigt, wie man dynamische Berechnungen mit JavaScript ausfuehren kann
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class DynamicCalculationExample 
{
	public static void main(final String[] args) throws Exception 
	{
		final ScriptEngineManager manager = new ScriptEngineManager();
		final ScriptEngine engine = manager.getEngineByName("js");
	
		final String calculation = "7 * (x * x) + (3 - x) * (x + 3) / 10";
		System.out.println("f(x) = " + calculation);
	
		for (int x = -10; x <= 10; x++)
		{
			engine.put("x", x);
	
			final Object calculationResult = engine.eval(calculation);
			System.out.println("x = " + x + "\t / f(x) = " + calculationResult);
		}
	}
}