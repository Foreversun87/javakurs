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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Beispielklasse zur Demonstration einiger Möglichkeiten von Java2D, die hier noch um
 * Druck-Funktionalität erweitert wird.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class Java2DPrintingExample
{
    public static void main(final String[] args)
    {
        final JFrame appFrame = new JFrame("Java2DPrintingExample");
        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final DrawingComponent component = new DrawingComponent();
        final JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent event)
            {
                final PrinterJob printerJob = PrinterJob.getPrinterJob();
                printerJob.setPrintable(component);
                if (printerJob.printDialog())
                {
                    try
                    {
                        printerJob.print();
                    }
                    catch (final PrinterException ex)
                    {
                        JOptionPane.showMessageDialog(appFrame, "Printing failed! Reason: " + ex.getLocalizedMessage());
                    }
                }
            }
        });

        appFrame.add(component, BorderLayout.CENTER);
        appFrame.add(printButton, BorderLayout.SOUTH);
        appFrame.pack();
        appFrame.setVisible(true);
    }

    public static class DrawingComponent extends JComponent implements Printable
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

            // Figur malen
            g2d.setColor(Color.DARK_GRAY);
            g2d.draw(shape);

            // Farbverlauf fï¿½r die Textausgabe
            final Paint paint2 = new GradientPaint(20, 20, Color.WHITE, 120, 120, Color.DARK_GRAY);

            // gedrehte Textausgabe
            g2d.setFont(new Font("Arial", Font.BOLD, 28));
            for (int i = 0; i < 3; i++)
            {
                g2d.rotate(Math.toRadians(i * 20));
                g2d.setPaint(paint2);
                g2d.drawString("First Java 2D", 20 + i * 20, 70);
                g2d.rotate(-Math.toRadians(i * 20));
            }
        }

        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(240, 230);
        }

        @Override
        public int print(final Graphics graphics, final PageFormat pageFormat, final int pageIndex) throws PrinterException
        {
            if (pageIndex > 0)
                return NO_SUCH_PAGE;

            // Verschiebe die Grafik, um den Offset des druckbaren Bereich
            graphics.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            paintComponent(graphics);
            graphics.setColor(Color.BLACK);
            graphics.drawString("Java printing is easy!", 20, 240);

            return PAGE_EXISTS;
        }
    }
}
