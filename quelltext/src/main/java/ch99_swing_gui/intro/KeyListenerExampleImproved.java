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
 * Copyright 2012 by Michael Inden
 */
public final class KeyListenerExampleImproved
{
    public static void main(final String[] args)
    {
        final JFrame frame = new JFrame("KeyListenerExampleImproved");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initGuiForKeyListenerExample(frame);

        frame.pack();
        frame.setVisible(true);
    }

    private static void initGuiForKeyListenerExample(final JFrame frame)
    {
        final JLabel label = new JLabel("Enter some text " + "(3 or more letters):");
        final JTextField textField = new JTextField(20);
        final JButton button = new JButton("Press me!");
        button.setEnabled(false);

        // Mit dem dahinterliegenden Textfeld verknüpfen,
        // 't' als Aktivierung, 2tes 't' unterstreichen
        label.setLabelFor(textField);
        label.setDisplayedMnemonic('t');
        // Achtung: gibt die Position an, Gefahr von Inkonsistenzen!
        label.setDisplayedMnemonicIndex(11);

        // KeyListener registrieren
        textField.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(final KeyEvent e)
            {
                final boolean hasEnoughText = textField.getText() != null && textField.getText().length() >= 3;
                button.setEnabled(hasEnoughText);
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
