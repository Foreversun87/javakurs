package ch12_javafx.observablecollections;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 

/**
 * Beispielprogramm demonstriert, wie Änderungen in einem ListView ausgefuehrt werden koennen.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015, 2017 by Michael Inden 
 */
public class EditabelListViewExample extends Application 
{
    @Override
    public void start(final Stage primaryStage) 
    {
        final String[] names = { "Micha", "Andi", "Andy", "Tom", "Matze" };
        final ObservableList<String> entries = 
                                     FXCollections.observableArrayList(names);

        final ListView<String> listView = new ListView<>(entries);
                
        final Button addButton = new Button("Add");
        final TextField textfield = new TextField();        
        final Button removeButton = new Button("Remove");
        final ToolBar toolbar = new ToolBar(addButton, textfield, 
                                            new Separator(), removeButton);
        
        final VBox vBox = new VBox();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.getChildren().addAll(toolbar, listView);

        // Action Handling 
        final SelectionModel<String> selectionModel = listView.getSelectionModel();
        addButton.setOnAction(event -> 
        {
        		entries.add(textfield.getText());
        		
        		final int lastElement = entries.size();
			listView.scrollTo(lastElement);
        });        								  
        removeButton.setOnAction(event -> 
        {
            entries.remove(selectionModel.getSelectedItem());
        });
        
        // Usability steigern: Button Disabling 
        addButton.disableProperty().bind(textfield.textProperty().isEmpty());
        removeButton.disableProperty().bind(Bindings.isNull(
                                            selectionModel.selectedItemProperty()));
            
        primaryStage.setScene(new Scene(vBox, 400, 175));
        primaryStage.setTitle("EditabelListViewExample");
        primaryStage.show();
    }
    
	public static void main(final String[] args) 
	{
		Application.launch(args);
	}
}