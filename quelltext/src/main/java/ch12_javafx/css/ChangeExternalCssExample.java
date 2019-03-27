package ch12_javafx.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm demonstriert, dass verschiedene Stylings auch dynamisch verï¿½ndert werden kï¿½nnen.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class ChangeExternalCssExample extends Application
{
    static int     index        = 0;

    final String[] cssFileNames = { "buttons.css", "buttons2.css", "buttons3.css" };

    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        final Button changeButton = new Button("Change CSS");
        final Button button2 = new Button("Login Button");
        final Button buttonFancy = new Button("Fancy Login");

        // Verknüpfung mit CSS über ID bzw. dene CSS-Selektor ".button"
        button2.getStyleClass().add("customloginbutton");
        buttonFancy.setId("fancybutton");

        final FlowPane flowPane = new FlowPane();
        flowPane.setHgap(7);
        flowPane.setVgap(7);
        flowPane.setPadding(new Insets(7, 7, 7, 7));
        flowPane.getChildren().addAll(changeButton, button2, buttonFancy);

        primaryStage.setScene(new Scene(flowPane, 410, 160));

        // Verknüpfung Scene und CSS		
        primaryStage.getScene().getStylesheets()
                        .add(this.getClass().getResource(cssFileNames[index++]).toExternalForm());

        changeButton.setOnAction(event -> {
            primaryStage.getScene().getStylesheets().remove(0);
            primaryStage.getScene()
                            .getStylesheets()
                            .add(this.getClass().getResource(cssFileNames[index++ % cssFileNames.length])
                                                 .toExternalForm());
        });

        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}