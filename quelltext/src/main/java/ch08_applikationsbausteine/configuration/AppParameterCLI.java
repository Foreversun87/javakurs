package ch08_applikationsbausteine.configuration;

/**
 * Aufz�hlung, die die zu verarbeitenden Kommandozeilenparameter definiert
 * <br>
 * Variante f�r das CLI-Framework 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public enum AppParameterCLI
{
    WIDTH("w", "width", true, "set the width"), 
    HEIGHT("h", "height", true, "set the height"), 
    HELP("?", "help", false, "show help"),
    DEBUG("d", "debug", false, "activate debug mode"); 

    // Zugriff aus selben Package erm�glichen
    /*private*/ final String  shortname;
    /*private*/ final String  name;
    /*private*/ final boolean hasArgs;
    /*private*/ final String  helptext;

    AppParameterCLI(final String shortname, final String name, 
                    final boolean hasArgs, final String helptext)
    {
        this.shortname = shortname;
        this.name = name;
        this.hasArgs = hasArgs;
        this.helptext = helptext;
    }
}