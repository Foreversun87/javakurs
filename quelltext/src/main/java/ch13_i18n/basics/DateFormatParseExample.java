package ch13_i18n.basics;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Beispielklasse zur Demonstration des Parsing von Datumswerten mit einem DateFormat 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class DateFormatParseExample
{
    public static void main(final String[] args)
    {
        final String dateString = "32.12.2008 20:14:55 GMT+7";

        final DateFormat format = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        format.setLenient(true);

        try
        {
            final Date date = format.parse(dateString);
            System.out.println("Original string:       " + dateString);
            System.out.println("Formatted parsed date: " + format.format(date));
            System.out.println("Parsed date:           " + date);
        }
        catch (final ParseException ex)
        {
            System.out.println("ERROR: could not parse date '" + dateString + "'");
        }
    }

    private DateFormatParseExample()
    {
    }
}