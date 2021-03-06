package ch06_collections.basics;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 * Eigene typsichere Implementierung einer Art HashMap unter Nutzung von Aggregation und Delegation.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class NameToImageMapUsingDelegation
{
    // JDK 7: Diamond Operator
    private final Map<String, Image> nameToImage = new HashMap<>();

    public NameToImageMapUsingDelegation()
    {
    }

    public void put(final String imageName, final Image image)
    {
        final String key = imageName != null ? imageName.toUpperCase() : null;
        nameToImage.put(key, image);
    }

    public Image get(final String imageName)
    {
        final String key = imageName != null ? imageName.toUpperCase() : null;
        return nameToImage.get(key);
    }

    public void clear()
    {
        nameToImage.clear();
    }
}