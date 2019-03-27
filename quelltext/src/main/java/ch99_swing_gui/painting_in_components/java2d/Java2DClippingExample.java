package ch99_swing_gui.painting_in_components.java2d;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Beispielklasse zur Demonstration einiger Mölichkeiten von Java2D, die hier noch um
 * Clipping ergänzt sind.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class Java2DClippingExample
{
    public static void main(final String[] args)
    {
        final JFrame appFrame = new JFrame("Java2DClippingExample");
        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JComponent component = new DrawingComponent();

        appFrame.add(component, BorderLayout.CENTER);
        appFrame.pack();
        appFrame.setVisible(true);
    }

    public static class DrawingComponent extends JComponent
    {
        private static final Color violetBlue = new Color(0x5533AA);
        private static final Color goldenRed = new Color(0xBB9580);

        @Override
        public void paintComponent(final Graphics g)
        {
            super.paintComponent(g);

            final Graphics2D g2d = (Graphics2D) g;

            // Kreis als Figur mit Interface Shape definieren
            final Shape shape = new Ellipse2D.Float(5, 5, 200, 200);

            // diagonaler Farbverlauf von rot nach blau
            final Paint paint = new GradientPaint(20, 20, violetBlue, 100, 110, goldenRed, true);
            g2d.setPaint(paint);

            // Figur ausfï¿½llen  
            g2d.fill(shape);

            // Zeichenstift mit Dicke 7 (=> new BasicStroke(7))
            final float[] dashes = new float[] { 15f, 5f, 5f, 5f };
            final Stroke stroke = new BasicStroke(7, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dashes, 0);
            g2d.setStroke(stroke);

            // Figur malen }$
            g2d.setColor(Color.DARK_GRAY);
            g2d.draw(shape);

            // Clipping-Bereich durch Ellipse und Rechteck bestimmen
            final Path2D.Double clipPath = new Path2D.Double();
            clipPath.append(new Ellipse2D.Double(20, 30, 70, 70), true);
            clipPath.append(new Rectangle2D.Double(90, 100, 70, 90), true);

            // Clipping-Bereich zeichnen
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(clipPath);

            // Clipping-Bereich aktivieren }$
            g2d.setClip(clipPath);

            // Farbverlauf fï¿½r die Textausgabe
            final Paint paint2 = new GradientPaint(20, 20, Color.WHITE, 120, 120, Color.DARK_GRAY);
            g2d.setPaint(paint2);

            // gedrehte Textausgabe
            g2d.setFont(new Font("Arial", Font.BOLD, 28));
            for (int i = 0; i < 3; i++)
            {
                g2d.rotate(Math.toRadians(i * 20));
                g2d.drawString("First Java 2D", 20 + i * 20, 70);
                g2d.rotate(-Math.toRadians(i * 20));
            }
        }

        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(240, 230);
        }
    }
}
