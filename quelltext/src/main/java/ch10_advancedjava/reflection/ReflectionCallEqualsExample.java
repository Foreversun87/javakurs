package ch10_advancedjava.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * Die Klasse <code>ReflectionCallEqualsExample</code> zeigt den Aufruf
 * der Methode <code>equals()</code> f�r zwei Objekte vom Typ Person.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class ReflectionCallEqualsExample
{   
    public static void main(final String[] args) throws Exception
    {
        final Person max = new Person("Max", new Date(), "Aachen");
        final Person moritz = new Person("Moritz", new Date(), "Aachen");

        System.out.println("max.equals(max) " + callEquals(max, max));
        System.out.println("max.equals(moritz) " + callEquals(max, moritz));
    }
   
    private static boolean callEquals(final Person person, final Object otherObject)
    {      
    	final String methodName = "equals";
    	final Class<?>[] parameterTypes = new Class<?>[] { Object.class };
    	final String methodInfo = createMethodInfo(methodName, parameterTypes);
    			
        // Schritt 1: Ermitteln der Klasseninformation  
        final Class<?> clazz = person.getClass();

    	try
        {
            // Schritt 2: Ermitteln der Methode        
            final Method equalsMethod = clazz.getMethod(methodName, parameterTypes);

            // Schritt 3: Aufruf der Methode  
            final Object[] parameters = new Object[] { otherObject };
            final Object result = equalsMethod.invoke(person, parameters);
            return Boolean.valueOf(result.toString());
        }
        // Schritt 4: Behandlung s�mtlicher durch Reflection m�glicher Exceptions  
        catch (final NoSuchMethodException e)
        {
            // Es gibt keine solche Methode  
            throw new IllegalStateException(clazz.getName() + " does not support " + methodInfo);
        }
        catch (final SecurityException e)
        {
            // Keine Erlaubnis, auf die Methode zuzugreifen  
            throw new IllegalStateException(clazz.getName() + " insufficent " + " security rights to access "
            		                        + methodInfo);
        }
        catch (final IllegalAccessException e)
        {
            // Kein Zugriff auf die Definition der Methode (im .class-File)
            throw new IllegalStateException(clazz.getName() + " can't access " + 
                                            methodInfo);
        }
        catch (final IllegalArgumentException e)
        {
            // Ung�ltige Parameter beim Aufruf  
            throw new IllegalStateException(clazz.getName() + " invalid parameters " + 
                                            methodInfo);
        }
        catch (final InvocationTargetException e)
        {
            // Methode wirft Exception 
            throw new IllegalStateException(clazz.getName() + " exception in " + 
                                            methodInfo);
        }
    }

    private static String createMethodInfo(final String methodName, final Class<?>[] parameterTypes)
    {
        return "method: " + methodName + "(" + Arrays.toString(parameterTypes) + ")";
    }

    private ReflectionCallEqualsExample()
    {
    }
}
