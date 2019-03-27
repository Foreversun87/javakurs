package ch13_i18n.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

/**
 * Beispielklasse zur Demonstration des Parsings von Datums mit unterschiedlichen SimpleDateFormat-Instanzen 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class MultipleDateFormatParsingExample2Jdk8
{
    private static final String     SILVESTER = "31.12.2016";

    public static void main(final String[] args)
    {
        final List<String> supportedFormats = Arrays.asList("dd.MM.yy HH:mm:ss", "dd.MM.yy HH:mm",
                                            "dd.MM.yyyy HH:mm:ss", "dd.MM.yyyy HH:mm");

        try
        {
            final LocalDateTime date = DateParseUtilsJdk8.parseDate(SILVESTER, supportedFormats);
            System.out.println("Parsed '" + SILVESTER + "' into " + date + " of type " + date.getClass());            
        }
        catch (final DateTimeParseException ex)
        {
            System.out.println(DateParseUtilsJdk8.buildErrorMessage(SILVESTER, supportedFormats));
        }
    }

    private MultipleDateFormatParsingExample2Jdk8()
    {
    }
}