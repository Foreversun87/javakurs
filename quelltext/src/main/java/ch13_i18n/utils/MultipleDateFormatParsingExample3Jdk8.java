package ch13_i18n.utils;

import static ch13_i18n.utils.DateParseUtilsJdk8.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Beispielklasse zur Demonstration des Parsings von Datums mit unterschiedlichen SimpleDateFormat-Instanzen 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public final class MultipleDateFormatParsingExample3Jdk8
{
    public static void main(final String[] args)
    {
        final String dateFormatFileName = "DateFormat.properties";
        final InputStream dateFormatIs = MultipleDateFormatParsingExample3Jdk8.class.
                                         getResourceAsStream(dateFormatFileName);
        try
        {
            final List<String> supportedFormats = 
                               readDateFormatsFromStream(dateFormatIs);
            final String silvester = "31.12.2016 18:00";
            try
            {
                final LocalDateTime date = parseDate(silvester, supportedFormats);
                System.out.println("Parsed '" + silvester + "' into " + date);
            }
            catch (final DateTimeParseException ex)
            {
                System.out.println(buildErrorMessage(silvester, supportedFormats));
            }
        }
        catch (final IOException ex)
        {
            System.out.println("No DateFormat-File: " + dateFormatFileName);
        }
    }

    private MultipleDateFormatParsingExample3Jdk8()
    {
    }
}