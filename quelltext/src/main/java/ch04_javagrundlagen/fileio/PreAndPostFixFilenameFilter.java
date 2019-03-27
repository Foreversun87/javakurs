package ch04_javagrundlagen.fileio;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Utility-Klasse zur Filterung von Dateien nach Dateinamen
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class PreAndPostFixFilenameFilter implements FilenameFilter
{
   private final String prefix;
   private final String postfix;
	
   public PreAndPostFixFilenameFilter(final String prefix, final String postfix)
   {
      this.prefix = prefix;
      this.postfix = postfix;
   }

   @Override
   public boolean accept(final File dir, final String name)
   {
      return name.startsWith(prefix) && name.endsWith(postfix);
   }
}
