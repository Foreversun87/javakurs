package ch12_javafx.basics;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm zur Einf�hrung der grundlegenden Elemente von JavaFX.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstJavaFxExample extends Application
{
    @Override
    public void start(final Stage stage) throws Exception
    {
        final StackPane stackPane = new StackPane();

        // Label erzeugen und hinzuf�gen  
        final Node labelNode = new Label("Hello JavaFX World!");
        stackPane.getChildren().add(labelNode);

        // Stage und Scene verbinden }$ 
        stage.setScene(new Scene(stackPane, 250, 75));
        // Titel und Resizable-Eigenschaft setzen 
        stage.setTitle("FirstJavaFxExample");
        stage.setResizable(true);
        // Positionierung und Sichtbarkeit  
        stage.centerOnScreen();
        stage.show();
    }

    // ...

    public static void main(final String[] args)
    {
        launch(args);
    }
}