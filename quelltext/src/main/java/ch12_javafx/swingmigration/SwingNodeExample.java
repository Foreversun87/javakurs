package ch12_javafx.swingmigration;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm demonstiert wie man Swing in JavaFX einbinden kann.
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class SwingNodeExample extends Application
{
    public void start(final Stage stage)
    {
        final SwingNode swingNode = new SwingNode();
        SwingUtilities.invokeLater(() ->
        {
            // Swing-Ereignisverarbeitung
            final JButton swingButton = new JButton("Click me!");
            swingButton.addActionListener(event ->
            {
                swingButton.setText(swingButton.getText() + "#");
            });

            final JPanel panel = new JPanel(new BorderLayout());
            panel.add(swingButton, BorderLayout.NORTH);
            swingNode.setContent(panel);
        });

        // JavaFX-Ereignisverarbeitung
        final Button fxButton = new Button("JavaFX Button -- Start Animation");
        JavaFXInSwingExample.initFXAnimationButton(fxButton, fxButton);

        final BorderPane pane = new BorderPane(fxButton);
        pane.setTop(swingNode);

        stage.setScene(new Scene(pane, 250, 100));
        stage.setTitle("SwingNodeExample");
        stage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}
