package ch18_entwurfsmuster.structural;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 * The classes/objects participating in adapter pattern:
 * <ul>
 * <li> Target - defines the domain-specific interface that Client uses.
 * <li> Adapter - adapts the interface Adaptee to the Target interface. 
 * <li> Adaptee - defines an existing interface that needs adapting. 
 * <li> Client - collaborates with objects conforming to the Target interface.
 */
// Client = main / JList
// Adapter = ListToAbstractListModelAdapter
// Adaptee = List
// Target = ListModel
/**
 * Demonstration vom Adapter-MMuster.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public class SimpleAdapterExample
{
    public static void main(String[] args)
    {
        final List<String> names = Arrays.asList("Mike", "Andy", "Tim", "Tom");

        // List -> ListModel
        final ListModel<String> requiredIF = new ListToAbstractListModelAdapter(names);
        final JList<String> namesList = new JList<>(requiredIF);

        final JFrame frame = new JFrame("AdapterDemo");
        frame.setContentPane(namesList);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Adapter extends or implements desired IF
    private static final class ListToAbstractListModelAdapter extends AbstractListModel<String>
    {
        private final List<String> content = new ArrayList<>();

        public ListToAbstractListModelAdapter(final List<String> content)
        {
            this.content.addAll(content);
        }

        @Override
        public int getSize()
        {
            return content.size();
        }

        @Override
        public String getElementAt(int index)
        {
            return content.get(index);
        }
    }
}
