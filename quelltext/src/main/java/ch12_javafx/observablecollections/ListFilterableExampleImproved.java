package ch12_javafx.observablecollections;

import java.util.function.Predicate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Beispielprogramm demonstriert, wie man in einem ListView filtert.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class ListFilterableExampleImproved extends Application 
{
    @Override
    public void start(final Stage primaryStage) {

        final String[] names = { "Kai", "Micha", "Andi", "Andy", "Tom", 
                                 "Matze", "Mike", "Florian" };
        final ObservableList<String> entries = 
                                     FXCollections.observableArrayList(names);

        final FilteredList<String> filteredEntries = new FilteredList<>(entries);
        final ListView<String> listView = new ListView<>(filteredEntries);
        listView.setPrefHeight(200);

        final TextField searchFor = new TextField();
        searchFor.setPromptText("Enter filter"); 
        searchFor.textProperty().addListener( (observable, oldValue, newValue) -> 
        {
            final Predicate<String> caseInsensitiveContains = entry -> 
            {
                return entry.toUpperCase().contains(newValue.toUpperCase());
            };
            
            filteredEntries.setPredicate(caseInsensitiveContains); 
        });
        
        final VBox vBox = new VBox();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setSpacing(10);
        vBox.getChildren().addAll(searchFor, listView);
        
        primaryStage.setScene(new Scene(vBox, 300, 250));
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.show();
    }

	public static void main(String[] args) {
		launch(args);
	}
}