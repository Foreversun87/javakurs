package ch12_javafx.basics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm demonstriert das Action Handling in JavaFX.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class JavaFxActionHandlingExample extends Application 
{
	@Override
	public void start(final Stage stage) 
	{
		final Button btn = new Button();
		btn.setText("Add 'Hello World' Label");

		final FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(7,7,7,7));
		
		pane.getChildren().add(btn);

		// ActionHandler registrieren  
		btn.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				pane.getChildren().add(new Label("- Hello World! -"));
			}
		});

		stage.setScene(new Scene(pane, 400, 150));
		stage.setTitle("JavaFxActionHandlingExample");		
		stage.setResizable(true);
		stage.centerOnScreen();
		stage.show();
	}

	
	public static void main(final String[] args) 
	{
		launch(args);
	}
}