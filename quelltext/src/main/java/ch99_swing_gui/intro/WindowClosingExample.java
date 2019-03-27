package ch99_swing_gui.intro;

import javax.swing.JFrame;

/**
 * Dieses Beispiel demonstiert einen WindowListener, der Rückfrage hält,
 * ob das Programm beendet werden soll.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class WindowClosingExample
{
    public static void main(final String[] args) 
    {
        final JFrame frame = new JFrame("WindowClosingExample");

        // ExitListener registrieren         
        frame.addWindowListener(new ExitListener(frame));
        
        // Wichtig, um Standardfunktionalität auszuschalten 
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}