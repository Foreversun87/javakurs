package ch13_i18n.utils;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import ch08_applikationsbausteine.ranges.RangeCheckUtils;

/**
 * Utility-Klasse zur Vereinfachung des Parsings von Datumswerten 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public final class DateParseUtilsJdk8
{
    /**
    * tries to parse a given date input string with the passed date formats
    
    * @param dateAndTime  the string containing the date and time information, e.g. "7.2.71 15:21"
    * @param supportedDateFormats  an array of supported date formats as strings
    * 
    * @return   the parsed date
    * @throws   ParseException if the given string could not be parsed 
    * @throws   IllegalArgumentException if the given string or date format array is null or empty
    */
    public static LocalDateTime parseDate(final String dateAndTime, final List<String> supportedDateFormats)
                    throws DateTimeParseException
    {
        final List<DateTimeFormatter> formats = supportedDateFormats.stream().
                        map(pattern -> DateTimeFormatter.ofPattern(pattern)).
                        collect(Collectors.toList());

        return parseDate(dateAndTime, formats.toArray(new DateTimeFormatter[formats.size()]));
    }

    /**
    * tries to parse a given date input string with the passed date formats
    
    * @param dateAndTime  the string containing the date and time information, e.g. "7.2.71 15:21"
    * @param supportedDateFormats  an array of supported date formats 
    * 
    * @return   the parsed date
    * @throws   ParseException if the given string could not be parsed 
    * @throws   IllegalArgumentException if the given string or date format array is null or empty
    */
    public static LocalDateTime parseDate(final String dateAndTime, final DateTimeFormatter... supportedDateFormats)
                    throws DateTimeParseException
    {
        RangeCheckUtils.assertStringParamNotNullOrEmpty("dateAndTime", dateAndTime);
        RangeCheckUtils.assertArrayParamNotNullOrEmpty("supportedDateFormats", supportedDateFormats);

        for (final DateTimeFormatter currentFormat : supportedDateFormats)
        {
            try
            {
                return LocalDateTime.parse(dateAndTime, currentFormat);
            }
            catch (final DateTimeParseException e)
            {
                // Ignorieren und mit nächstem Format versuchen  
            }
        }

        // Kein Format erlaubt eine Umwandlung 
        throw new DateTimeParseException("unparsable input", dateAndTime, 0);
    }

    public static String buildErrorMessage(final String dateAndTime, 
                                           final List<String> supportedDateFormats)
    {
        final List<String> formats = supportedDateFormats.stream().
                        map(pattern -> "'" + pattern + "'").
                        collect(Collectors.toList());
        
        return "Parsing error: value='" + dateAndTime + 
               "'\nSupported formats: " + formats;
    }
    
    public static List<String> readDateFormatsFromStream(final InputStream resIs)
                    throws IOException, FileNotFoundException
    {
        try (final InputStream is = new BufferedInputStream(resIs))
        {
            final Properties dateFormatProperties = new Properties();
            dateFormatProperties.load(is);
    
            return dateFormatProperties.values().stream().
                                                 map(obj -> (String)obj).
                                                 collect(Collectors.toList());
        }
    }

    private DateParseUtilsJdk8()
    {
    }
}