package ch06_collections.utility;

import java.util.Collections;
import java.util.List;

/**
 * Beispielprogramm zur Demonstration von m�glichen Problemen beim Mix von Generics 
 * und �lterem untypisierten Collections 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class CheckedCollectionsExample
{
    public static void main(final String[] args)
    {
        final DataModel dataModel = new DataModel();
        final List<ModelElement> elements = dataModel.getAllElements();
        elements.add(new ModelElement("Modelelement"));

        // Hinzuf�gen auf typisierter Liste -> String wird gespeichert !!         
        System.out.println("Adding string to List<ModelElement>");
        OldStyleUtilityClass.addSampleModelElement(elements);
        OldStyleUtilityClass.printListElements("UNCHECKED", elements);

        // Erzeugen einer dynamisch typsicheren Sicht auf die Liste 
        final List<ModelElement> checkedElements = Collections.checkedList(elements, ModelElement.class);

        // Hinzuf�gen auf typisierter Liste -> Exception !! 
        System.out.println("Adding string to Checked List");
        OldStyleUtilityClass.addSampleModelElement(checkedElements);
        OldStyleUtilityClass.printListElements("TYPE-CHECKED", checkedElements);
    }
}
