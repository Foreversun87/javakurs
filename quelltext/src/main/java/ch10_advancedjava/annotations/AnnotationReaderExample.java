package ch10_advancedjava.annotations;

import java.util.Arrays;

/**
 * Beispielklasse zum Auslesen von Annotations bzw. den dort hinterlegten Werten 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class AnnotationReaderExample
{
    public static void main(final String[] args) throws Exception
    {
        // Auslesen des selbst definierten Annontationstyps CreationInfo
        final CreationInfo creationInfo = AnnotationUsage.class.
                                              getAnnotation(CreationInfo.class);
        
        if (creationInfo != null)
        {     	        	
            printCreationInfo(creationInfo);
        }
        else
        {
            System.out.println("No " + CreationInfo.class.getSimpleName() + 
                               " annotation present!");
        }
    }

    private static void printCreationInfo(final CreationInfo creationInfo)
    {
        System.out.println("author():      " + creationInfo.author());
        System.out.println("description(): " + creationInfo.description());
        System.out.println("baseclass():   " + creationInfo.baseclass());
        System.out.println("interfaces():  " + Arrays.toString(creationInfo.interfaces()));
        System.out.println("tags():        " + Arrays.toString(creationInfo.tags()));
    }
}
