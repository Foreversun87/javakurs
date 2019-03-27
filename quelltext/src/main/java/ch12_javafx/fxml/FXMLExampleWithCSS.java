package ch12_javafx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Beispielprogramm nutzt FXML zur Definition eines einfachen Layouts
 * und nutzt CSS zur optischen Gestaltung.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FXMLExampleWithCSS extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        final Parent root = FXMLLoader.load(getClass().getResource("fxml_example.fxml"));

        stage.setScene(new Scene(root, 450, 175));

        // Verknüpfung mit CSS
        stage.getScene().getStylesheets().add(getClass().getResource("login.css").toExternalForm());

        stage.setTitle("FXMLExampleWithCSS");
        stage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}