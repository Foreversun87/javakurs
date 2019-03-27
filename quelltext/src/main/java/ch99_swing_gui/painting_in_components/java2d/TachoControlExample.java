package ch99_swing_gui.painting_in_components.java2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Beispielprogramm zur Demonstration des Zeichnens von schicken Bedienelementen
 * mit Java 2D. Hier wird ein Bedienelement gezeichnet, das sich an einem
 * Tachometer eines Autos orientiert. <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 *         Copyright 2012 by Michael Inden
 */
public final class TachoControlExample
{
    public static class TachoControl extends JComponent implements ChangeListener
    {
        private static final int TICK_LENGTH = 6;
        private static final Font TICK_FONT = new Font("Arial", Font.PLAIN, 12);
        private static final int LONG_TICK_LENGTH = 14;
        private static final Font LONG_TICK_FONT = new Font("Arial", Font.BOLD, 18);

        // Stretch-Faktor, damit die Zahlen nicht so nah beieinander stehen
        private static final double adjustment = -35;
        private static final double stretch = 1.25;

        private final int innerRadius = 150;
        private final int innerStart = 20;
        private final int outerRadius = innerRadius + innerStart;
        private final int indicatorLength = innerRadius - 40;

        private final BoundedRangeModel model;

        TachoControl(final BoundedRangeModel model) {
            this.model = model;
            this.model.addChangeListener(this);
        }

        @Override
        public void stateChanged(final ChangeEvent event)
        {
            repaint();
        }

        @Override
        public void paintComponent(final Graphics graphics)
        {
            super.paintComponent(graphics);
            final Graphics2D graphics2D = (Graphics2D) graphics;

            // Aktivierung von Antialiasing
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            final Point2D center = new Point2D.Float(outerRadius, outerRadius);
            drawBackground(graphics2D, center);
            drawAnchor(graphics2D, center);
            drawTicksAndValueTexts(graphics2D, center);
            drawIndicator(graphics2D, center);
        }

        public void drawBackground(final Graphics2D graphics2D, final Point2D center)
        {
            // Au�enring: Farben sowie Abst�nde
            final float[] dist = { 0.90f, 0.95f, 1.0f };
            final Color[] colors = { Color.DARK_GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY };

            // Kreisf�rmiger Gradient
            final RadialGradientPaint paint = new RadialGradientPaint(center, outerRadius, dist, colors);
            graphics2D.setPaint(paint);

            // Gezeichnet wird zwar vom Mittelpunkt aus, aber es wird nur im
            // �u�eren Bereich der Farbverlauf gezeichnet
            final Ellipse2D outerEllipse = new Ellipse2D.Double(0, 0, outerRadius * 2, outerRadius * 2);
            graphics2D.fill(outerEllipse);

            // Hintergrund mit Farbverlauf nach dem Au�enring malen
            final GradientPaint gradient = new GradientPaint(innerStart, innerStart, Color.DARK_GRAY, 0, innerRadius * 2, Color.LIGHT_GRAY);
            graphics2D.setPaint(gradient);
            final Ellipse2D ellipse = new Ellipse2D.Double(innerStart, innerStart, innerRadius * 2, innerRadius * 2);
            graphics2D.fill(ellipse);
        }

        private void drawAnchor(final Graphics2D graphics2D, final Point2D center)
        {
            final float radius = 10;
            
            // Gewichtung und Farben f�r den kreisf�rmigen Gradienten
            final float[] dist = { 0.05f, 0.2f, 0.4f, 0.5f };
            final Color[] colors = { Color.WHITE, Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY };
            
            // Kreisf�rmiger Gradient mit vierstufigem Verlauf
            final RadialGradientPaint paint = new RadialGradientPaint(center, radius * 2, dist, colors);
            graphics2D.setPaint(paint);
            
            // Befestigungskugel malen
            final Ellipse2D ellipse = new Ellipse2D.Double(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
            graphics2D.fill(ellipse);
        }

        private void drawIndicator(final Graphics2D graphics2D, final Point2D center)
        {
            // Ursprung verschieben
            graphics2D.translate(center.getX(), center.getY());
            
            // Koordinatensystem drehen
            final double rotation = model.getValue();
            graphics2D.rotate(Math.toRadians(adjustment + -180 + rotation * stretch));
            
            // Den Zeiger malen
            graphics2D.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawLine(0, 0, indicatorLength, 0);
            
            // Transformation zur�cknehmen
            graphics2D.rotate(-Math.toRadians(adjustment + -180 + rotation * stretch));
            graphics2D.translate(-center.getX(), -center.getY());
        }

        private void drawTicksAndValueTexts(final Graphics2D graphics2D, final Point2D center)
        {
            graphics2D.translate(center.getX(), center.getY());
            
            // Radius basierend auf dem des Zeigers
            final int radius = indicatorLength + 15;
            final double valueRange = model.getMaximum() - model.getMinimum();
            final int extend = model.getExtent();
            final int numOfTicks = (int) valueRange / extend;
            for (int i = 0; i < numOfTicks; i++)
            {
                graphics2D.rotate(Math.toRadians(adjustment + stretch * i * extend));
            
                // Markierungslinie zeichnen
                final int tickLength = drawTick(graphics2D, radius, i, numOfTicks);
                
                // Geschwindigkeitsangabe zeichnen
                drawValueText(graphics2D, radius, i, tickLength);
                graphics2D.rotate(-Math.toRadians(adjustment + stretch * i * extend));
            }
            graphics2D.translate(-center.getX(), -center.getY());
        }

        private int drawTick(final Graphics2D graphics2D, final int tickRadius, final int value, final int numOfTicks)
        {
            final int tickLength = calcTickLength(value);
            prepareGraphicsForTick(graphics2D, value, numOfTicks);
            graphics2D.drawLine(-tickRadius, 0, -tickRadius + tickLength, 0);
            return tickLength;
        }

        private void drawValueText(final Graphics2D graphics2D, final int tickRadius, final int value, final int tickLength)
        {
            final int tickTextGap = calcTickTextGap(value);
            prepareGraphicsForValueText(graphics2D, value);
            
            // Wert mittig �ber Trennlinie schreiben
            final String strValue = Integer.toString(value * model.getExtent());
            final FontMetrics fm = graphics2D.getFontMetrics(getFont());
            final Rectangle2D stringBounds = fm.getStringBounds(strValue, graphics2D);
            final int textYPos = tickLength + tickTextGap;
            
            // Text 90 Grad zu Linien drehen
            graphics2D.translate(-tickRadius + tickLength, 0);
            graphics2D.rotate(Math.toRadians(270));
            graphics2D.drawString(strValue, -(int) stringBounds.getWidth() / 2, -textYPos);
            graphics2D.rotate(-Math.toRadians(270));
            graphics2D.translate(+tickRadius - tickLength, 0);
        }

        private void prepareGraphicsForTick(final Graphics2D graphics2D, final int value, final int numOfTicks)
        {
            BasicStroke tickStroke = new BasicStroke(2);
            if (value % 2 == 0)
            {
                tickStroke = new BasicStroke(4);
            }
            graphics2D.setColor(getTickColor(value, numOfTicks));
            graphics2D.setStroke(tickStroke);
        }

        private void prepareGraphicsForValueText(final Graphics2D graphics2D, final int value)
        {
            Font font = TICK_FONT;
            Color fontColor = Color.LIGHT_GRAY;
            if (value % 2 == 0)
            {
                font = LONG_TICK_FONT;
                fontColor = Color.WHITE;
            }
            graphics2D.setFont(font);
            graphics2D.setColor(fontColor);
        }

        private int calcTickLength(final int value)
        {
            if (value % 2 == 0)
                return LONG_TICK_LENGTH;
            return TICK_LENGTH;
        }

        private int calcTickTextGap(final int value)
        {
            if (value % 2 == 0)
                return 7;
            return 4;
        }

        private Color getTickColor(int i, final int maxNumOfTicks)
        {
            if (i < (maxNumOfTicks * 0.5))
                return Color.lightGray;
            if (i < (maxNumOfTicks * 0.7))
                return Color.green;
            if (i < (maxNumOfTicks * 0.85))
                return Color.yellow;

            return Color.red;
        }
        
        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(outerRadius * 2 + 20, outerRadius * 2 + 20);
        }
    }

    public static void main(final String[] args) throws InterruptedException
    {
        final JFrame frame = new JFrame("TachoControlExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final BoundedRangeModel model = new DefaultBoundedRangeModel(0, 10, 0, 210);
        final TachoControl tachoControl = new TachoControl(model);
        frame.add(tachoControl);
        frame.pack();
        frame.setVisible(true);

        // nun verschiedene Werte simulieren
        for (int i = 0; i <= 200; i += 1)
        {
            model.setValue(i);
            Thread.sleep(100);
        }
    }
}
