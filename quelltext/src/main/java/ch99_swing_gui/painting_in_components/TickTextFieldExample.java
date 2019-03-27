package ch99_swing_gui.painting_in_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Beispiel der Visualiserung von Hilfslinien als Positionshinweis bei der Eingabe in
 * einem JTextField.
 * <br>
 * <b>Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class TickTextFieldExample
{
    public static class TickTextField extends JTextField
    {
        // Konstanten könnten auch konfigurierbar gemacht werden
        private static final int TICK_LENGTH = 4;
        private static final int LONG_TICK_LENGTH = 7;
        private static final int SPECIAL_MARKER_POS = 10;
        private static final int LAST_N_MARKERS = 3;

        private final int numOfColumns;

        public TickTextField(final int numOfColumns) 
        {
            super(numOfColumns);

            setFont(new Font("Courier New", Font.PLAIN, 18));
            this.numOfColumns = numOfColumns;
        }

        @Override
        public void paintComponent(final Graphics graphics)
        {
            super.paintComponent(graphics);
            drawTicks(graphics);
        }

        private void drawTicks(final Graphics graphics)
        {
            final int charWidth = calcCharWidth(graphics);

            for (int columnNr = 1; columnNr < numOfColumns + 1; columnNr++)
            {
                final int xOffset = charWidth * columnNr;
                final Pair<Color, Integer> colorAndLength = calcColorAndLength(columnNr);

                graphics.setColor(colorAndLength.getFirst());
                drawTick(graphics, xOffset, colorAndLength.getSecond());
            }
        }

        private int calcCharWidth(final Graphics graphics)
        {
            final FontMetrics fontMetrics = graphics.getFontMetrics(getFont());

            // Buchstabenbreite ermitteln, hier Buchstabe beliebig
            return fontMetrics.charWidth('a');
        }

        private Pair<Color, Integer> calcColorAndLength(final int columnNr)
        {
            // Farbe und Lï¿½nge aus dem Standard festlegen
            Color tickColor = Color.BLACK;
            int currentTickLength = TICK_LENGTH;

            // Nachfolgend werden nur die vom Standard abweichenden Fälle
            // geprüft, daher finden sich hier keine else-Anweisungen
            if (columnNr % SPECIAL_MARKER_POS == 0)
            {
                tickColor = Color.BLUE;
                currentTickLength = LONG_TICK_LENGTH;
            }
            if (columnNr > numOfColumns - LAST_N_MARKERS)
            {
                tickColor = Color.RED;
            }
            if (columnNr == numOfColumns)
            {
                tickColor = Color.RED;
                currentTickLength = getSize().height / 2;
            }

            return new Pair<Color, Integer>(tickColor, currentTickLength);
        }

        private void drawTick(final Graphics graphics, final int xOffset, final int tickLength)
        {
            final Insets insets = getInsets();
            final Dimension dimension = getSize();
            dimension.width -= (insets.left + insets.right);

            final int xPos = insets.left + xOffset;
            final int yPosUpperTick = insets.top;
            final int yPosLowerTick = dimension.height - insets.bottom - 1;

            graphics.drawLine(xPos, yPosUpperTick, xPos, yPosUpperTick + tickLength);
            graphics.drawLine(xPos, yPosLowerTick, xPos, yPosLowerTick - tickLength);
        }
    }

    public static void main(final String[] args)
    {
        final JFrame appFrame = new JFrame("TickTextFieldExample");
        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final int NUM_OF_COLUMNS = 40;
        appFrame.add(new TickTextField(NUM_OF_COLUMNS));
        appFrame.setSize(650, 70);
        appFrame.setVisible(true);
    }
    
    private TickTextFieldExample()
    {        
    }
}