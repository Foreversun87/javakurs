package ch08_applikationsbausteine.configuration;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

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
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class ReadHighscoresFromCsvExample
{
    private static final Logger LOGGER         = LogManager.getLogger(ReadHighscoresFromCsvExample.class);

    private static final int    POS_NAME    = 0;
    private static final int    POS_POINTS  = 1;
    private static final int    POS_LEVEL   = 2;
    private static final int    POS_DATE    = 3;
    
    public static final void main(final String[] args)
    {
        final String filePath = "src/main/resources/Highscores.csv";    
        final List<Highscore> highscores = 
        		              HighscoresFromCsvImporter.readHighscoresFromCsv(filePath);
    
        new AppFrame(highscores).setVisible(true);        
    }

    
    public static class AppFrame extends JFrame
    {
        AppFrame(final List<Highscore> highscores)
        {
            super("Highscores");
            setSize(700, 200);

            final AbstractTableModel highscroeTableModel = new AbstractTableModel()
            {
                @Override
                public int getColumnCount()
                {
                    return 4;
                }

                @Override
                public int getRowCount()
                {
                    return highscores.size();
                }

                @Override
                public String getColumnName(int column)
                {
                    switch (column)
                    {
                        case POS_NAME:
                            return "Name";
                        case POS_POINTS:
                            return "Punkte";
                        case POS_LEVEL:
                            return "Level";
                        case POS_DATE:
                            return "Datum";
                    }
                    return "n/a";
                }

                @Override
                public Class<?> getColumnClass(int columnIndex)
                {
                    switch (columnIndex)
                    {
                        case POS_NAME:
                            return String.class;
                        case POS_POINTS:
                            return Integer.class;
                        case POS_LEVEL:
                            return Integer.class;
                        case POS_DATE:
                            return LocalDate.class;
                    }
                    return Object.class;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex)
                {
                    final Highscore highscore = highscores.get(rowIndex);
                    switch (columnIndex)
                    {
                        case POS_NAME:
                            return highscore.getName();
                        case POS_POINTS:
                            return highscore.getPoints();
                        case POS_LEVEL:
                            return highscore.getLevel();
                        case POS_DATE:
                            return highscore.getDay();
                    }
                    return null;
                }
            };

            final JTable table = new JTable(highscroeTableModel);
            final JScrollPane scollpane = new JScrollPane(table);
            add(scollpane);

            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }
}
