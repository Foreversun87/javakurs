package ch18_entwurfsmuster.structural;

import java.util.List;

import ch18_entwurfsmuster.creational.AbstractGraphicsElement;

/**
 * Observer-Mechanismus, um Änderungen im Modell darzustellen
 *   
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public interface IModelListener
{
    public void imageElementsChanged(final List<AbstractGraphicsElement> images);
    public void pdfElementsChanged(final List<AbstractGraphicsElement> pdfs);
    public void nameChanged(final String newName);
}