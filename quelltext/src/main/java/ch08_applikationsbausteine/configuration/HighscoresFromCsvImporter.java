package ch08_applikationsbausteine.configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Beispiel zur Verarbeitung von CVS-Dateien
 * <br>
 * Lese aus einer speziellen csv-Datei alle Werte ein und mache daraus eine Liste 
 * von Highscore-Objekten. Dabei sollte jede Zeile der Datei den folgenden Aufbau 
 * haben: "<code>Name , Punkte , Level , Datum</code>"
 * @author Michael Inden
 * 
 * Copyright 2016 by Michael Inden 
 */
public final class HighscoresFromCsvImporter
{
    private static final Logger LOGGER         = LogManager.getLogger("HighscoresFromCsvImporter");

    private static final int    POS_NAME    = 0;
    private static final int    POS_POINTS  = 1;
    private static final int    POS_LEVEL   = 2;
    private static final int    POS_DATE    = 3;

    private static final int    VALUE_COUNT = 4;

    public static List<Highscore> readHighscoresFromCsv(final String fileName)
    {
        final List<Highscore> highscores = new ArrayList<>();

        try
        {
        	    // JDK 8: readAllLines(), forEach() & Lambda
	        final List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.ISO_8859_1);
	        lines.forEach(line ->
            {
            	    // JDK 8: Optional & Lambda
                final Optional<Highscore> optionalHighscore = extractHighscoreFromLine(line);
                optionalHighscore.ifPresent(highscore -> highscores.add(highscore));
            });
	    }
        catch (final IOException e)
        {
            LOGGER.warn("processing of file '" + fileName + "' incomplete!" + e);
        }

        return highscores;
    }

    private static Optional<Highscore> extractHighscoreFromLine(final String line)
    {
        // Spalte die Eingabe mit ';' oder ',' auf           
        final String[] values = line.split(";|,");

        // Behandlung von Leerzeilen und Kommentaren            
        if (isEmptyLineOrComment(values))
        {
            return Optional.empty();
        }
        // Ignoriere fehlertoleranterweise unvollst�ndige Eintr�ge      
        if (values.length != VALUE_COUNT)
        {
            LOGGER.warn("Wrong number of values: " + values.length + " expected: " + VALUE_COUNT + "! Skipping invalid value '" + line + "'");
            return Optional.empty();
        }

        try
        {
            // Auslesen der Werte als String + Typpr�fung + Konvertierung 
            final String name = values[POS_NAME].trim();
            final int points = Integer.parseInt(values[POS_POINTS].trim());
            final int level = Integer.parseInt(values[POS_LEVEL].trim());
            final String dateAsString = values[POS_DATE].trim();
            
            final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            final LocalDate day = LocalDate.parse(dateAsString, dateTimeFormatter);

            return Optional.of(new Highscore(name, points, level, day));
        }
        catch (final NumberFormatException e)
        {
            LOGGER.warn("Skipping invalid point or level value '" + line + "'");
        }
        catch (final DateTimeParseException e)
        {
            LOGGER.warn("Skipping invalid date value '" + line + "'");
        }
        return Optional.empty();
    }

    private static boolean isEmptyLineOrComment(final String[] values)
    {
        return (values.length == 1 && (values[0].trim().length() == 0) || 
			   // Ignoriere Kommentare, die auch ',' oder ';' enthalten
			   (values.length >= 1 && values[0].trim().startsWith("#")));
    }    
}
