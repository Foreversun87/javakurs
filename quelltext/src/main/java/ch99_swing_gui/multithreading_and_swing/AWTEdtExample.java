package ch99_swing_gui.multithreading_and_swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import ch09_multithreading.intro.SleepUtils;

/**
 * Beispielprogramm zur Demonstration der Abarbeitung
 * von Aufgaben synchron im AWT-Event-Thread 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public final class AWTEdtExample
{
    private static final JTextField resultTextfield = new JTextField("?");

    public static void main(String[] args) throws IOException
    {
        final JFrame jframe = new JFrame("AWTEdtExample");
        final JMenuBar menubar = new JMenuBar();

        createAndAddMenus(menubar);

        jframe.getContentPane().setLayout(new BorderLayout());
        jframe.getContentPane().add(menubar, BorderLayout.NORTH);
        jframe.getContentPane().add(resultTextfield);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jframe.setSize(300, 150);
        // realize
        jframe.setVisible(true);
    }

    private static void createAndAddMenus(final JMenuBar menubar)
    {
        final JMenu fileMenu = new JMenu("File");
        fileMenu.add(new LongRunningMenuAction("Start LongRunningAction"));

        menubar.add(fileMenu);
    }

    public static final class LongRunningMenuAction extends AbstractAction
    {
        public LongRunningMenuAction(final String resourceKey)
        {
            super(resourceKey);
        }

        public void actionPerformed(ActionEvent e)
        {
            resultTextfield.setText("Computation started");

            for (int i = 1; i < 4; i++)
            {
                // R�ckmeldung ausgeben => wirkt nicht  
                resultTextfield.setText("Computation " + i);
                // Verz�gerung (stellvertretend f�r aufwendige Berechnung)  
                SleepUtils.safeSleep(1000);
            }
            
            resultTextfield.setText("Computation finished");
        }
    }
}
