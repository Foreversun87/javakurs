package ch12_javafx.layout;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt, wie man Layouts mithilfe einer GridPane
 * gestalten kann und illustriert den Einsatz von Hilfslinien.
 *
 * @author Michael Inden
 *
 * Copyright 2014 by Michael Inden
 */
public class GridPaneExample extends Application
{
    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        final GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(7);
        gridPane.setVgap(7);

        final Label lblName = new Label("Name:");
        final TextField tfName = new TextField();

        final Label lblPassword = new Label("Password:");
        final PasswordField pfPassword = new PasswordField();

        final Button btnLogin = new Button("Login");

        final CheckBox checkBoxShowGridLines = new CheckBox("Show Gridlines");
        checkBoxShowGridLines.setOnAction(event -> gridPane.setGridLinesVisible(checkBoxShowGridLines.isSelected()));

        // Zuordnung zum Grid (Node, X-Position, Y-Position)  
        gridPane.add(lblName, 0, 0);
        gridPane.add(tfName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pfPassword, 1, 1);
        gridPane.add(btnLogin, 1, 2);
        gridPane.add(checkBoxShowGridLines, 0, 5);

        // Layoutbesonderheiten  
        GridPane.setHalignment(lblName, HPos.LEFT);
        GridPane.setHalignment(lblPassword, HPos.RIGHT);
        GridPane.setHalignment(btnLogin, HPos.RIGHT);

        primaryStage.setScene(new Scene(gridPane, 350, 150));
        primaryStage.setTitle("GridPaneExample");
        primaryStage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}
