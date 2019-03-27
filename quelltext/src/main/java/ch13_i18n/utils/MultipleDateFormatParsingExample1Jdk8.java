package ch13_i18n.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Beispielklasse zur Demonstration des Parsings von Datums mit unterschiedlichen SimpleDateFormat-Instanzen 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class MultipleDateFormatParsingExample1Jdk8
{
    private static final DateTimeFormatter df1       = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss");
    private static final DateTimeFormatter df2       = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
    private static final DateTimeFormatter df3       = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter df4       = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private static final String            SILVESTER = "31.12.2016";

    public static void main(final String[] args)
    {
        final DateTimeFormatter[] supportedFormats = { df1, df2, df3, df4 };

        try
        {
            final LocalDateTime date = DateParseUtilsJdk8.parseDate(SILVESTER, supportedFormats);
            System.out.println("Parsed '" + SILVESTER + "' into " + date + " of type " + date.getClass());
        }
        catch (final DateTimeParseException ex)
        {
            System.out.println("Parsing failed: value='" + SILVESTER + "'");
        }
    }

    private MultipleDateFormatParsingExample1Jdk8()
    {
    }
}