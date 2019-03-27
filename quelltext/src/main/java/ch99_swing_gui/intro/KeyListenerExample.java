package ch99_swing_gui.intro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Beispielklasse zur Demonstration eines KeyListeners. 
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 *         Copyright 2012 by Michael Inden
 */
public final class KeyListenerExample
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("KeyListenerExample");
        initGuiForKeyListenerExample(frame);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static void initGuiForKeyListenerExample(final JFrame frame)
    {
        final JLabel label = new JLabel("Enter some text " + "(3 or more letters):");
        final JTextField textField = new JTextField(20);
        final JButton button = new JButton("Press me!");
        button.setEnabled(false);

        // KeyListener registrieren  
        textField.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(final KeyEvent e)
            {
                button.setEnabled(TextLengthChecker.checkRequiredLength(textField, 3));
            }
        });

        // Layout gestalten  
        final JPanel inputPanel = new JPanel();
        inputPanel.add(label);
        inputPanel.add(textField);

        final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(button);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }
}
