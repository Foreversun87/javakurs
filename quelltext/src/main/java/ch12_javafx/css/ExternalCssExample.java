package ch12_javafx.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die optische Gestaltung von Buttons mithilfe von CSS,
 * wobei die CSS-Informationen aus einer Datei stammen. Zeigt Styling mit
 * CSS-Selektor und ID  
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ExternalCssExample extends Application
{
    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        final Button plainButton = new Button("Plain Red Text Button");
        final Button loginButton = new Button("Login Button");
        final Button fancyButton = new Button("Fancy Login");

        // Verknüpfung mit CSS über ID bzw. dene CSS-Selektor ".button"
        loginButton.getStyleClass().add("customloginbutton");
        fancyButton.setId("fancybutton");

        final FlowPane flowPane = new FlowPane();
        flowPane.setHgap(7);
        flowPane.setVgap(7);
        flowPane.setPadding(new Insets(7, 7, 7, 7));
        flowPane.getChildren().addAll(plainButton, loginButton, fancyButton);

        primaryStage.setScene(new Scene(flowPane, 450, 170));

        // Verknüpfung Scene und CSS
        primaryStage.getScene().getStylesheets().add(this.getClass().getResource("buttons.css").toExternalForm());

        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}