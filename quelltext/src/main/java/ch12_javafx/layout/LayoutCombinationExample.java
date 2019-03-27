package ch12_javafx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Beispielprogramm demonstriert die Kombination verschiedener JavaFX-Layoutkomponenten.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class LayoutCombinationExample extends Application
{
    @Override
    public void start(final Stage primaryStage)
    {
        final BorderPane borderPane = new BorderPane();
        borderPane.setTop(createToolbarPane());
        borderPane.setCenter(createInputPane());
        borderPane.setLeft(createNavigationPane());

        primaryStage.setTitle(LayoutCombinationExample.class.getSimpleName());
        primaryStage.setScene(new Scene(borderPane, 300, 150));
        primaryStage.show();
    }

    private Pane createToolbarPane()
    {
        final HBox hbox = new HBox(5);
        hbox.setStyle("-fx-border-color: red; -fx-border-width: 3pt;");
        hbox.getChildren().addAll(new Text("TOP"), new Button("HBox1"), new Button("HBox2"));
        return hbox;
    }

    private Pane createNavigationPane()
    {
        final VBox vbox = new VBox(5);
        vbox.setStyle("-fx-border-color: blue; -fx-border-width: 3pt;");
        vbox.getChildren().addAll(new Text("LEFT"), new Button("VBox1"), new Button("VBox2"));
        return vbox;
    }

private Pane createInputPane()
{
    final GridPane gridPane = new GridPane();
    gridPane.add(new Label("CENTER"), 0, 0);
    gridPane.add(new Label("Label1"), 0, 1);
    gridPane.add(new TextField(), 1, 1);
    gridPane.add(new Label("Label2"), 0, 2);
    gridPane.add(new TextField(), 1, 2);
    gridPane.add(new Button("Button"), 1, 3);
    return gridPane;
}

    public static void main(final String[] args)
    {
        launch(args);
    }
}