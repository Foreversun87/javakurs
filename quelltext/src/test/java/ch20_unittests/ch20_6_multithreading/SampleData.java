package ch20_unittests.ch20_6_multithreading;

/**
 * Konstantendefinition f�r Beispieldaten
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */ 
public final class SampleData
{
    public static final String TEXT_20  = "01234567890123456789";
    public static final String TEXT_40  = TEXT_20 + TEXT_20;
    public static final String TEXT_60  = TEXT_40 + TEXT_20;
    public static final String TEXT_80  = TEXT_40 + TEXT_40;
    public static final String TEXT_100 = TEXT_80 + TEXT_20;

    private SampleData() 
    {}
}
