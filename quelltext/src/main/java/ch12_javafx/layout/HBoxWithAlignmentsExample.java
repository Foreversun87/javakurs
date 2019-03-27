package ch12_javafx.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die M�glichkeiten zur Ausrichtung mit einer HBox.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class HBoxWithAlignmentsExample extends Application
{
    @Override
    public void start(final Stage primaryStage)
    {
        final Label label = new Label("Label");
        final TextField textfield = new TextField();
        final Button button = new Button("Button");
        button.setFont(Font.font(24));

        // Besonderheit 1: Abstand 10 Pixel zwischen Bedienelementen
        final HBox root = new HBox(10);
        //  Besonderheit 1: Abstand vom Rand
        root.setPadding(new Insets(7, 7, 7, 7));
        // Besonderheit 2: Ausrichtug Baseline
        root.setAlignment(Pos.BASELINE_LEFT);

        root.getChildren().addAll(label, textfield, button);

        primaryStage.setTitle(HBoxWithAlignmentsExample.class.getSimpleName());
        primaryStage.setScene(new Scene(root, 320, 70));
        primaryStage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}