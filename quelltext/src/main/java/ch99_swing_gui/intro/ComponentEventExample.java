package ch99_swing_gui.intro;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

/**
 * Beispielklasse zum ComponentListener. Durch Einsatz eines ComponentAdapter
 * wird auf Größenänderungen reagiert.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class ComponentEventExample
{
    public static void main(final String[] args)
    {
        final JFrame resizeFrame = new JFrame("Resize me");
        resizeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resizeFrame.addComponentListener(new ResizeEventListener(200, 100));
        resizeFrame.setSize(300, 200);
        resizeFrame.setVisible(true);
    }

    public static final class ResizeEventListener extends ComponentAdapter
    {
        private int minWidth = -1;
        private int minHeight = -1;

        ResizeEventListener(final int minWidth, final int minHeight)
        {
            this.minWidth = minWidth;
            this.minHeight = minHeight;
        }

        @Override
        public void componentResized(final ComponentEvent event)
        {
            final JFrame frame = (JFrame) event.getComponent();
            final Dimension dimension = frame.getSize();
            final int adjustedWidth = Math.max(dimension.width, minWidth);
            final int adjustedHeight = Math.max(dimension.height, minHeight);
            frame.setSize(adjustedWidth, adjustedHeight);
        }
    }
}