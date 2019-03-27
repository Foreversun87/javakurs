package ch99_swing_gui.advanced.jtable;

import javax.swing.RowFilter;

/**
 * Beispielklasse zur Demonstration eines eigenen RowFilter zur Filterung von JTables.
 * Dieser Filter prüft auf den Start mit einem Teilstring.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class StartsWithFilter extends RowFilter<Object, Object>
{
    private String filterValue = "";

    public StartsWithFilter(final String filterValue)
    {
        this.filterValue = filterValue.toLowerCase();
    }
    
    public boolean include(Entry<? extends Object, ? extends Object> entry)
    {
        // keine Filterung
        if (filterValue.isEmpty())
            return true;
        
        for (int i = 0; i < entry.getValueCount(); i++)
        {
            if (entry.getStringValue(i).toLowerCase().startsWith(filterValue))
                return true;
        }
        return false;
    }   

    public void setFilterValue(final String filterValue)
    {
        this.filterValue = filterValue.toLowerCase();
    }
}