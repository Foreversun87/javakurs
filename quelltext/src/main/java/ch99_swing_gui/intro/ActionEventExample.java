package ch99_swing_gui.intro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Beispielklasse zu ActionListenern: Ein Klick auf den JButton fügt ein '!'
 * an den dortigen Text an.
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden
 */
public final class ActionEventExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("ActionEventExample");
        final JButton button = new JButton("Button -- Press Me!");
        frame.add(button);
     
        // Event Listener registrieren
        button.addActionListener(new ActionListener()
        {
             @Override
             public void actionPerformed(final ActionEvent e)
             {
                 button.setText(button.getText()+"!");
             }    	   
        });
    
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private ActionEventExample()
    {        
    }
}

