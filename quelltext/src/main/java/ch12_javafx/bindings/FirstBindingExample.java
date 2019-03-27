package ch12_javafx.bindings;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Beispielprogramm zur Einfuehrung in das Binding von Properties.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class FirstBindingExample
{
    public static void main(final String[] args) 
    {   
        final IntegerProperty intProp = new SimpleIntegerProperty(11);
        final IntegerProperty result = new SimpleIntegerProperty(0);
        
        // Bidirektional: Property <-> Property  
        performBiDiChanges(intProp, result);

        // Binding aufheben }$
        intProp.unbindBidirectional(result); // result.unbindBidirectional(intProp); 
        
        // Keine Änderung am result  
        System.out.println("\nno bindings:");
        intProp.set(123);
        print("intProp -> 123:           ", intProp, result);
        result.set(456);
        print("result -> 456:            ", intProp, result);
        
        // Unidirektional: Property -> ObservableValue  
        performUniDiChanges(intProp, result);
    }

    private static void print(final String info,
                              final IntegerProperty intProp, 
                              final IntegerProperty result)
    {
        System.out.println(info + "intProp = " + intProp.getValue() + 
                           " / result = " + result.getValue());  
    }
    
    private static void performBiDiChanges(final IntegerProperty intProp, 
                                           final IntegerProperty result)
    {
        System.out.println("bidirectional:");

        result.bindBidirectional(intProp);  
        print("result <-> intProp:       ", intProp, result);

        intProp.set(444);
        print("intProp -> 444:           ", intProp, result);
        
        result.setValue(7777);
        print("result -> 7777:           ", intProp, result);
    }
    
    private static void performUniDiChanges(final IntegerProperty intProp, 
                                            final IntegerProperty result)
    {
        System.out.println("\nunidirectional:");
        
        result.bind(intProp);     
        print("result <- intProp:        ", intProp, result);
        
        intProp.set(321);
        print("intProp -> 321:           ", intProp, result);
        
        result.bind(intProp.add(4000));     
        print("result <- intProp + 4000: ", intProp, result);   
        
        result.set(0); // $\mbox{\bfseries Exception }$
    }
}
