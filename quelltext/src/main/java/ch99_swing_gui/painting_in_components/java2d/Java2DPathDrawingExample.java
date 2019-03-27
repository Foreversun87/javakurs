package ch99_swing_gui.painting_in_components.java2d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Beispielprogramm zur Demonstration des Zeichnens von Pfaden mit Java 2D.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class Java2DPathDrawingExample
{
    public static void main(final String[] args)
    {
        final JFrame appFrame = new JFrame("Java2DPathDrawingExample");
        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        appFrame.add(new PathDrawingComponent(), BorderLayout.CENTER);
        appFrame.setSize(350, 200);
        appFrame.setVisible(true);
    }

    public static class PathDrawingComponent extends JComponent
    {
        @Override
        public void paintComponent(final Graphics g)
        {
            super.paintComponent(g);

            final Graphics2D g2d = (Graphics2D) g;
            final Path2D.Float path = createDemoPath();

            // Nur Figur skalieren, Linie bleibt schmal
            final AffineTransform transform = AffineTransform.getScaleInstance(45, 35);
            final Shape shape = path.createTransformedShape(transform);
            g2d.setColor(Color.BLUE);
            g2d.draw(shape);

            // Koordinatensystem skalieren => Linien werden dicker
            g2d.scale(10, 10);
            g2d.setColor(Color.GREEN);
            g2d.draw(path);
        }

        public Path2D.Float createDemoPath()
        {
            final Path2D.Float demoPath = new GeneralPath();

            demoPath.moveTo(2f, 2f);
            demoPath.lineTo(6f, 1f);
            demoPath.quadTo(8f, 2.5f, 6f, 4f);
            demoPath.curveTo(4f, 1f, 3f, 6f, 2f, 2f);

            return demoPath;
        }
    }
}
