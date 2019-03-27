package ch12_javafx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt ein einfaches Layout mit der Containerkomponente HBox.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstHBoxExample extends Application 
{
	@Override
	public void start(final Stage primaryStage) 
	{
		final Label label = new Label("Label");
		final TextField textfield = new TextField();
		final Button button = new Button("Button");
		button.setFont(Font.font(24));

		final HBox root = new HBox();
		root.getChildren().addAll(label, textfield, button);
		
		primaryStage.setTitle(FirstHBoxExample.class.getSimpleName());
		primaryStage.setScene(new Scene(root, 350, 70));
		primaryStage.show();
	}

	public static void main(final String[] args) 
	{
		launch(args);
	}
}