package ch12_javafx.observablecollections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * Copyright 2015, 2017 by Michael Inden 
 */
public class ListFilterableExample extends Application 
{
    @Override
    public void start(final Stage primaryStage) 
    {
        final String[] names = { "Kai", "Micha", "Andi", "Andy", "Tom", 
                                 "Matze", "Mike", "Florian" };
        final ObservableList<String> entries =
                                     FXCollections.observableArrayList(names);
        
        final ListView<String> listView = new ListView<>(entries);
        listView.setPrefHeight(200);

        final TextField searchFor = new TextField();
        searchFor.setPromptText("Enter filter"); 
        searchFor.textProperty().addListener( (observable, oldValue, newValue) -> 
        {
            // Kopie notwendig, da removeIf() in der Collection löscht  
            final List<String> filteredEntries = new ArrayList<>(entries);
            
            final Predicate<String> caseInsensitiveContains = entry -> 
            {
                return entry.toUpperCase().contains(newValue.toUpperCase());
            };      
            filteredEntries.removeIf(caseInsensitiveContains.negate());
            
            listView.setItems(FXCollections.observableArrayList(filteredEntries)); 
        });
        
        final VBox vBox = new VBox();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setSpacing(10);                
        vBox.getChildren().addAll(searchFor, listView);
        
        primaryStage.setScene(new Scene(vBox, 300, 150));
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.show();
    }

	public static void main(final String[] args) 
	{
		launch(args);
	}
}