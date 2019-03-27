package ch10_advancedjava.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Die Klasse <code>TypeErasureAndTypeInfoExample</code> zeigt das trotz Type Eraaure
 * gewisse Typinformation mithilfe von Reflection ausgelesen werden k�nnen.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class TypeErasureAndTypeInfoExample<A, B, C> 
{
    private final String[] infoArray = {"Reflection", "and", "generic", "types"};
    protected List<String> info = Arrays.asList(infoArray);
    protected Set<SimplePerson> persons = Collections.singleton(new SimplePerson("Tim"));
    
    // Parameter nur zur Demonstration
    public List<String> getInfo(final Map<Integer, SimplePerson> mapping) 
    {
        return this.info;
    }
   
    // Parameter nur zur Demonstration
    public Set<SimplePerson> getPersons(final List<Long> values)
    {
        return this.persons;
    }
   
    public static void main(final String[] args)
    {
    	final Class<?> clazz = TypeErasureAndTypeInfoExample.class;
        System.out.println("getTypeParameters():  " + Arrays.asList(clazz.getTypeParameters()));
        System.out.println();
        
        System.out.println("Fields:");
        final Field[] fields = clazz.getDeclaredFields();
        for (final Field field : fields)
        {
            System.out.println("getName():        " + field.getName());       
            System.out.println("getType():        " + field.getType());
            System.out.println("getGenericType(): " + field.getGenericType());
            System.out.println();
        }
        
        System.out.println("Methods:");
        final Method[] methods = clazz.getDeclaredMethods();       
        for (final Method method : methods)
        {
            System.out.println("getName():                  " + 
                               method.getName());       
            System.out.println("getReturnType():            " + 
                               method.getReturnType());
            System.out.println("getGenericReturnType():     " + 
                               method.getGenericReturnType());
            System.out.println("getParameterTypes():        " + 
                               Arrays.asList(method.getParameterTypes()));
            System.out.println("getGenericParameterTypes(): " + 
                               Arrays.asList(method.getGenericParameterTypes()));
            System.out.println();
        }
    }
}
