package ch12_javafx.important_controls.comboboxandlist;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die ComboBox- und ListView-Komponente mit eigenem Renderer
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class ComboBoxListViewExample2 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        final String[] names = { "red", "green", "yellow", "blue", "black", "gray", "brown", "orange" };
        final ObservableList<String> entries = FXCollections.observableArrayList(names);
    
        final ComboBox<String> comboBox = new ComboBox<>(entries);
        final ListView<String> listView = new ListView<>(entries);
    
        comboBox.setCellFactory(i -> new ColorRectCell());
        comboBox.setButtonCell(new ColorRectCell());
        listView.setCellFactory(list -> new ColorRectCell());
    
        final VBox vBox = new VBox(10, comboBox, listView);
        vBox.setPadding(new Insets(7));
    
        primaryStage.setScene(new Scene(vBox, 300, 240));
        primaryStage.setTitle("ComboxBoxListViewExample2");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    // "Renderer"
    static class ColorRectCell extends ListCell<String>
    {
        @Override
        public void updateItem(String item, boolean empty)
        {
            super.updateItem(item, empty);
            if (item != null)
            {
                final Rectangle rect = new Rectangle(30, 30);
                rect.setFill(Color.web(item));
                setGraphic(rect);
    
                setText(item.toUpperCase());
            }
        }
    }
}
