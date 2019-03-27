package ch10_advancedjava.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Die Klasse <code>ReflectionUtils</code> ist eine Utility-Klasse, die verschiedene
 * Hilfsmethoden zur vereinfachten Handhabung von Reflection bereitstellt.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class ReflectionUtils
{
	public static Field findField(final Class<?> clazz, final String fieldName)
	{
		Objects.requireNonNull(fieldName, "fieldName must not be null");

	    // Abbruch der Rekursion
	    if (clazz == null)
	        return null;

	    try
	    {
	        return clazz.getDeclaredField(fieldName);
	    }
	    catch(final NoSuchFieldException ex)
	    {
	        // rekursive Suche in Superklasse
	        return findField(clazz.getSuperclass(), fieldName);
	    }
	}

	public static Method findMethod(final Class<?> clazz, final String methodName, 
	                                final Class<?>... parameterTypes)
	{
		Objects.requireNonNull(methodName, "methodName must not be null");
		Objects.requireNonNull(parameterTypes, "parameterTypes must not be null");
		
	    // Abbruch der Rekursion
	    if (clazz == null)
	        return null;
	    
	    try
	    {
	        return clazz.getDeclaredMethod(methodName, parameterTypes);
	    }
	    catch(final NoSuchMethodException ex)
	    {
	        // rekursive Suche in Superklasse
	        return findMethod(clazz.getSuperclass(), methodName, parameterTypes);
	    }
	}

	public static Method[] getAllMethods(final Class<?> clazz)
	{   
		Objects.requireNonNull(clazz, "class must not be null");

	    final List<Method> methods = new ArrayList<>(); 
	    methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
	    
	    if (clazz.getSuperclass() != null)
	    {
	        // rekursive Suche in Superklasse
	        methods.addAll(Arrays.asList(getAllMethods(clazz.getSuperclass())));
	    }
	        
	    return methods.toArray(new Method[0]);
	}

	public static void printCtorInfos(final Constructor<?> ctor)
	{
		Objects.requireNonNull(ctor, "ctor must not be null");
		
	    System.out.println(Modifier.toString(ctor.getModifiers()) + " " + 
	                       ctor.getName() +
	                       buildParameterTypeString(ctor.getParameterTypes()));
	    printAnnotations(ctor.getAnnotations());
	}

	public static void printMethodInfos(final Method method)
	{
		Objects.requireNonNull(method, "method must not be null");
		
	    System.out.println(Modifier.toString(method.getModifiers()) + " " + 
	                       method.getReturnType() + " " + method.getName() +
	                       buildParameterTypeString(method.getParameterTypes()));
	    printAnnotations(method.getAnnotations());
	}

	public static void printFieldInfos(final Field field)
	{
		Objects.requireNonNull(field, "method must not be null");
		
	    System.out.println(Modifier.toString(field.getModifiers()) + " " + 
	                       field.getType() + " " + field.getName());
	    printAnnotations(field.getAnnotations());
	}

	public static String buildParameterTypeString(final Class<?>[] parameterTypes)
	{
		Objects.requireNonNull(parameterTypes, "parameterTypes must not be null");
		
	    if (parameterTypes.length > 0)
	        return "(" + Arrays.toString(parameterTypes) + ")";

	    return "()";
	}

	public static void printAnnotations(final Annotation[] annotations)
	{
		Objects.requireNonNull(annotations, "annotations must not be null");
		
	    if (annotations.length > 0)
	        System.out.println("Annotations: " + Arrays.toString(annotations));
	}

    private ReflectionUtils()
    {
    }
}
