package ch12_javafx.important_controls;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;

/**
 * Modellklasse zum Einsatz in der TreeTableView-Komponente.
 *
 * @author Michael Inden
 *
 * Copyright 2014 by Michael Inden
 */
public class Person
{
    private final String                name;

    private final Integer               age;

    private final Color                 eyecolor;

    private final SimpleIntegerProperty size = new SimpleIntegerProperty();

    public Person(final String name, final Integer age, final Color eyecolor, final Integer size)
    {
        this.name = name;
        this.age = age;
        this.eyecolor = eyecolor;
        this.size.setValue(size);
    }

    public String getName()
    {
        return name;
    }

    public Integer getAge()
    {
        return age;
    }

    public Color getEyecolor()
    {
        return eyecolor;
    }

    public Integer getSize()
    {
        return size.getValue();
    }
}
