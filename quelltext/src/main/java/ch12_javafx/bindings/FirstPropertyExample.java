package ch12_javafx.bindings;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Beispielprogramm zur Einfuehrung in die Grundlagen von Properties.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class FirstPropertyExample
{
    public static void main(final String[] args)
    {
        // Zugriffe 
        final StringProperty textProp = new SimpleStringProperty("MICHA");

        System.out.println("textProp:   " + textProp);
        System.out.println("getValue(): " + textProp.getValue());

        // Bindings und Lazy Evaluation
        final BooleanBinding binding = textProp.isEqualToIgnoreCase("micha");
        System.out.println("binding:    " + binding);
        System.out.println("getValue(): " + binding.getValue());

        // Berechnungen  
        final IntegerProperty intProp1 = new SimpleIntegerProperty(10);
        final IntegerProperty intProp2 = new SimpleIntegerProperty(2);

        System.out.println("subtract(): " + intProp1.add(40).subtract(intProp2));
        System.out.println("multiply(): " + intProp1.multiply(intProp2).getValue());
    }
}
