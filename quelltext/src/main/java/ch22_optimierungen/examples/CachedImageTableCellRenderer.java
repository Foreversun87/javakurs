package ch22_optimierungen.examples;

import javax.swing.ImageIcon;

/**
 * TableCellRenderer, der die Bilder bei einmalig zu Beginn aus dem Dateisystem lädt
 * und diese dann zwischenspeichert. Folgende Aufrufe werden aus diesem Cache
 * bedient.  
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class CachedImageTableCellRenderer extends SimpleImageTableCellRenderer
{
    private final ImageIcon[] tileIcons;

    public CachedImageTableCellRenderer()
    {
        final int numOfBackgrounds = getNumOfTiles();
        tileIcons = new ImageIcon[numOfBackgrounds];

        for (int i = 0; i < numOfBackgrounds; i++)
            tileIcons[i] = loadTileImage(i);        
    }

    public ImageIcon getTileImage(final int i)
    {
        final int index = i % getNumOfTiles();
        return tileIcons[index];
    }
}