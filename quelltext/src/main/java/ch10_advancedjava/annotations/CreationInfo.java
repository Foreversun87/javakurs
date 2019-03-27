package ch10_advancedjava.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Definition einer eigenen Annotation 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */

// Meta-Annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

// Annotation-Definition  
public @interface CreationInfo {
    
    String author () default "Michael Inden";
    String description();   
    Class<?>  baseclass() default java.lang.Object.class;
    Class<?>[] interfaces() default {};
    String[] tags() default {}; // Syntax-Error: new String[]{};
    
}
