package ch10_advancedjava.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Beispielprogramm zeigt einige Neuerungen im Bereich von Reflection.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ReflectionParameterNamesExample
{
    public static void main(final String[] args)
    {
        inspectClass(ReflectionParameterNamesExample.class);
    }

    public static void inspectClass(final Class<?> clazz)
    {
        System.out.println("Untersuchte Klasse: " + clazz.getCanonicalName());
        System.out.println();

        // Zugriff und Ausgabe aller öffentlichen Methoden  
        final Method methods[] = clazz.getDeclaredMethods();
        System.out.println("Methoden: ");
        for (final Method method : methods)
        {
            // Neu in JDK 8
            final Parameter[] paramters = method.getParameters();

            final String methodAsString = Modifier.toString(method.getModifiers()) + " "
                                          +
                                          // zeigt auch Generics
                                          method.getGenericReturnType().getTypeName() + " " + method.getName()
                                          + buildParameterString(paramters);

            System.out.println(methodAsString);
        }
    }

    public static String buildParameterString(final Parameter[] parameters)
    {
        final StringBuilder sb = new StringBuilder("(");

        for (final Parameter param : parameters)
        {
            sb.append(Modifier.toString(param.getModifiers()));
            sb.append(" ");
            // zeigt auch Generics
            sb.append(param.getParameterizedType().getTypeName());
            sb.append(" ");
            sb.append(param.getName());
        }

        return sb.append(")").toString();
    }
}
