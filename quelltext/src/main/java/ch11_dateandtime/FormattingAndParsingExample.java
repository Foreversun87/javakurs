package ch11_dateandtime;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.time.format.DateTimeFormatter.ofLocalizedDateTime;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.format.FormatStyle.SHORT;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Beispielprogramm zur Demonstration der Möglichkeiten zur Formatierung und zum Parsing.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FormattingAndParsingExample
{
    public static void main(final String[] args) 
    {      
        // Definition einiger spezieller Formatter 
        final DateTimeFormatter ddMMyyyyFormat = ofPattern("dd.MM.yyyy");    
        final DateTimeFormatter italian_dMMMMyy = ofPattern("d.MMMM y", 
                                                            Locale.ITALIAN);                                                                                                               
        final DateTimeFormatter shortGerman = ofLocalizedDateTime(SHORT).
                                              withLocale(Locale.GERMAN);
    
        // Achtung: Die textuellen Teile sind in Hochkomma einzuschließen 
        final String customPattern = "'Der 'dd'. Tag im 'MMMM' im Jahr 'yy'.'";
        final DateTimeFormatter customFormat = ofPattern(customPattern);
    
    	    // Mapping für verschiedene Formate definieren  
        final Map<String, DateTimeFormatter> formatters = new LinkedHashMap<>();
        formatters.put("BASIC_ISO_DATE", BASIC_ISO_DATE);  
        formatters.put("ISO_DATE_TIME", ISO_DATE_TIME);    
        formatters.put("dd.MM.yyyy", ddMMyyyyFormat);
        formatters.put("d.MMMM y (it)", italian_dMMMMyy);
        formatters.put("SHORT_GERMAN", shortGerman);	
        formatters.put("CUSTOM_FORMAT", customFormat);
    
        System.out.println("Formatting:\n");
        applyFormatters(LocalDateTime.of(2014, Month.MAY, 28, 1, 2, 3), formatters);   
    
        	// Parsen von Datumswerten  
        	System.out.println("\nParsing:\n");
        	
        	final LocalDate fromIsoDate = LocalDate.parse("1971-02-07");
        	final LocalDate fromCustomPattern = LocalDate.parse("18.03.2014", 
        	                                                    ddMMyyyyFormat);
        	final LocalDateTime fromShortGerman = LocalDateTime.parse("18.03.14 11:12", 
        	                                                 shortGerman);
        
        	System.out.println("From ISO Date:       " + fromIsoDate);
        	System.out.println("From custom pattern: " + fromCustomPattern);
        	System.out.println("From short german:   " + fromShortGerman);
    }
    
    private static void applyFormatters(final LocalDateTime base,
                             final Map<String, DateTimeFormatter> formatters)
    {
        System.out.println("Starting on: " + base);
        formatters.forEach((name, formatter) ->
        {
            System.out.println("applying '" + name + "': " + 
                                              base.format(formatter));       
        });
    }
}

