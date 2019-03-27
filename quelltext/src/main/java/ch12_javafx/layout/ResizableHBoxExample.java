package ch12_javafx.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Beispielprogramm illustriert, wie Bedienelemente auf Größenveränderung reagieren und
 * demonstriert den Einsatz einer eigenen Ellipsis.
 *
 * @author Michael Inden
 *
 * Copyright 2014 by Michael Inden
 */
public class ResizableHBoxExample extends Application
{
    @Override
    public void start(final Stage primaryStage)
    {
        final Label label = new Label("Label");
        label.setTextOverrun(OverrunStyle.ELLIPSIS); // Standard
        final TextField textfield = new TextField();

        final Button button = new Button("This is a button");
        button.setFont(Font.font(24));

        // setzen des Strings für die Ellipsis ... Abkürzung
        button.setEllipsisString("##~##");
        button.setTextOverrun(OverrunStyle.CENTER_ELLIPSIS);

        final HBox root = new HBox(10);
        root.setPadding(new Insets(7, 7, 7, 7));
        root.setAlignment(Pos.BASELINE_LEFT);
        root.getChildren().addAll(label, textfield, button);

        // Größenveränderung
        HBox.setHgrow(textfield, Priority.ALWAYS);

        primaryStage.setTitle(ResizableHBoxExample.class.getSimpleName());
        primaryStage.setScene(new Scene(root, 410, 75));
        primaryStage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}
