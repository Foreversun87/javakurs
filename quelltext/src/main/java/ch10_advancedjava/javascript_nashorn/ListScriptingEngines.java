package ch10_advancedjava.javascript_nashorn;

import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

/**
 * Beispielprogramm, um verfuegbare Scripting Engines aufzulisten.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ListScriptingEngines
{
    public static void main(final String args[])
    {
        final ScriptEngineManager manager = new ScriptEngineManager();

        final List<ScriptEngineFactory> factories = manager.getEngineFactories();

        for (final ScriptEngineFactory factory : factories)
        {
            System.out.println(factory.getEngineName());
            System.out.println(factory.getEngineVersion());
            System.out.println(factory.getLanguageName());
            System.out.println(factory.getLanguageVersion());
            System.out.println(factory.getExtensions());
            System.out.println(factory.getMimeTypes());
            System.out.println(factory.getNames());
            System.out.println();
        }
    }
}