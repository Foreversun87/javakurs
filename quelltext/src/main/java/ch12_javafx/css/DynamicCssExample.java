package ch12_javafx.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die optische Gestaltung von Buttons mithilfe von CSS,
 * wobei die CSS-Informationen dynamisch wirken, also etwa auf Selektion usw.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class DynamicCssExample extends Application
{
    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        final Button changeButton = new Button("Plain Red Text Button");
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

        primaryStage.setScene(new Scene(flowPane, 500, 210));

        // Verknüpfung Scene und CSS		
        primaryStage.getScene().getStylesheets()
                        .add(this.getClass().getResource("buttons-dynamics.css").toExternalForm());

        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}