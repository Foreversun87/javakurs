package ch99_swing_gui.intro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Beispielklasse eines WindowListeners. Es wird eine WindowAdapter genutzt,
 * um Rückfrage beim Schliessen eines Fensters ztu halten.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class ExitListener extends WindowAdapter
{
    private final JFrame parentFrame;

    public ExitListener(final JFrame parentFrame)
    {
        this.parentFrame = parentFrame;
    }

    public void windowClosing(final WindowEvent event)
    {
        final int answer = JOptionPane.showConfirmDialog(parentFrame, "Wollen Sie das Programm beenden?");
        if (answer == JOptionPane.YES_OPTION)
        {
            // Fenster unsichtbar machen und (bei Bedarf) Ressourcen freigeben         
            parentFrame.setVisible(false);
            parentFrame.dispose();

            // Programmende forcieren     
            System.exit(0);
        }
    }
}