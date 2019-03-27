package ch10_advancedjava.annotations;

import java.io.Serializable;

/**
 * Beispielklasse mit Annotations, die separat ausgelesen werden 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
@CreationInfo(author="Mike", description="Demonstration einer eigenen Annotation",
              baseclass=java.lang.Object.class,
              interfaces={java.lang.Runnable.class, java.io.Serializable.class},
              tags={"Annotation", "Definition", "Advanced Java"}) 
public class AnnotationUsage implements Runnable, Serializable
{
    @Override
    public void run()
    {
        // ...
    }
}