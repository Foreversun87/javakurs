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
 * Beispiel der Visualiserung eines Warnungsindikators für Längenüberschreitungen der Eingabe in
 * einem JTextField.
 * <br>
 * <b>Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class TextfieldLengthWarningIndicatorExample
{
    private static final int NUM_OF_COLUMNS = 40;

    public static class TickTextFieldWithLengthWarningIndicator extends JTextField
    {
        // Kï¿½nnten auch konfigurierbar gemacht werden
        private static final int TICK_LENGTH = 4;
        private static final int LONG_TICK_LENGTH = 7;

        private static final int SPECIAL_MARKER_POS = 10;
        private static final int LAST_N_MARKERS = 3;

        private final int numOfColumns;

        public TickTextFieldWithLengthWarningIndicator(final int numOfColumns) {
            super(numOfColumns);

            setFont(new Font("Courier New", Font.PLAIN, 18));
            this.numOfColumns = numOfColumns;
        }

        @Override
        public void paintComponent(final Graphics graphics)
        {
            super.paintComponent(graphics);

            drawTicks(graphics, TICK_LENGTH, LONG_TICK_LENGTH);

            if (isNearEnd())
                drawWarningCross(graphics);
        }

        private void drawWarningCross(final Graphics graphics)
        {
            final int radius = 12;
            final Insets insets = getInsets();
            final Dimension dim = getSize();
            final int x = dim.width - insets.right - radius;
            final int y = insets.top;

            graphics.setColor(getWarningColor());
            graphics.fillOval(x, y, radius, radius);
            graphics.setColor(Color.WHITE);
            graphics.drawLine(x + 2, y + 2, x + radius - 2, y + radius - 2);
            graphics.drawLine(x + 2, y + radius - 2, x + radius - 2, y + 2);
        }

        private Color getWarningColor()
        {
            if (isNearEnd() && !isOverEnd())
                return Color.ORANGE;

            return Color.RED;
        }

        private boolean isNearEnd()
        {
            return getText().length() > (numOfColumns - 2);
        }

        private boolean isOverEnd()
        {
            return getText().length() > (numOfColumns);
        }

        private void drawTicks(final Graphics graphics, final int tickLength, final int longTickLength)
        {
            final FontMetrics fontMetrics = graphics.getFontMetrics(getFont());

            final int charWidth = fontMetrics.charWidth('a');
            for (int i = 1; i < numOfColumns + 1; i++)
            {
                final int xOffset = charWidth * i;

                // Farbe und Länge aus den Standard festlegen
                Color tickColor = Color.BLACK;
                int currentTickLength = tickLength;

                // Nachfolgend werden nur die vom Standard abweichenden Fälle geprüft,
                // daher finden sich hier keine else-Anweisungen
                if (i % SPECIAL_MARKER_POS == 0)
                {
                    tickColor = Color.BLUE;
                    currentTickLength = longTickLength;
                }
                if (i > numOfColumns - LAST_N_MARKERS)
                {
                    tickColor = Color.RED;
                    currentTickLength = tickLength;
                }
                if (i == numOfColumns)
                {
                    tickColor = Color.RED;
                    currentTickLength = getSize().height / 2;
                }

                drawTick(graphics, xOffset, tickColor, currentTickLength);
            }
        }

        private void drawTick(final Graphics graphics, final int xOffset, final Color tickColor, final int tickLength)
        {
            final Insets insets = getInsets();
            final Dimension dimension = getSize();
            dimension.width -= (insets.left + insets.right);

            final int xPos = insets.left + xOffset;
            final int yPosUpperTick = insets.top;
            final int yPosLowerTick = dimension.height - insets.bottom - 1;

            graphics.setColor(tickColor);
            graphics.drawLine(xPos, yPosUpperTick, xPos, yPosUpperTick + tickLength);
            graphics.drawLine(xPos, yPosLowerTick, xPos, yPosLowerTick - tickLength);
        }
    }

    public static void main(final String[] args)
    {
        final JFrame appFrame = new JFrame("TextfieldLengthWarningIndicatorExample");
        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        appFrame.add(new TickTextFieldWithLengthWarningIndicator(NUM_OF_COLUMNS));
        appFrame.setSize(500, 70);
        appFrame.setVisible(true);
    }
    
    private TextfieldLengthWarningIndicatorExample()
    {        
    }
}