package ch10_advancedjava.reflection;

import java.lang.reflect.Field;

/**
 * Die Klasse <code>AttributeAcccessExample</code> zeigt den Zugriff auf Attribute
 * mithilfe von Reflection.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class AttributeAccessExample
{
    public static long  instanceCounter = 0;
    @Deprecated
    public volatile int value;
    private String      description     = "Hello World";

    public static void main(final String[] args)
    {
        try
        {
            final AttributeAccessExample obj = new AttributeAccessExample();
            final Class<?> clazz = obj.getClass();
            
            // Zugriff auf das Attribut 'value'              
            final Field field = clazz.getField("value");
                       
            // Zugriff auf den Wert des Attributs 'value'             
            final Object attributeValue = field.get(obj);
            System.out.println("value = " + attributeValue);
            
            // Zugriff auf die Annotation des Attributs 'value'
            ReflectionUtils.printAnnotations(field.getAnnotations());
            
            // Zugriff auf das statische Attribut 'instanceCounter'           
            final Field staticfield = clazz.getField("instanceCounter");
            
            // Zugriff auf den Wert des statischen Attributs 'instanceCounter' 
            final Object staticvalue = staticfield.get(null);
            System.out.println("instanceCounter = " + staticvalue);

            // Zugriff auf das private Attribut 'description'   
            final Field field2 = clazz.getDeclaredField("description");
            
            // Zugriff erm�glichen, finalen Wert �ndern(!) und auslesen
            field2.setAccessible(true);              
            field2.set(obj, "Changed FINAL attribute");
            final Object attributeValue2 = field2.get(obj);
            System.out.println("description = " + attributeValue2);
        }
        // Behandlung s�mtlicher durch Reflection m�glicher Exceptions 
        catch (final ReflectiveOperationException e)
        {
            // Zugriffsprobleme auf das Attribut
            throw new IllegalStateException("can't access field!", e);
        }
        catch (final SecurityException e)
        {
            // Keine Erlaubnis, auf das Attribut zuzugreifen 
            throw new IllegalStateException("insufficent security rights to access field!", e); 
        }
   }
}