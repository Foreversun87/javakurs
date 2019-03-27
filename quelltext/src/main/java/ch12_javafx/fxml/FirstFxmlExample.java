package ch12_javafx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Beispielprogramm nutzt FXML zur Definition eines einfachen Layouts.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstFxmlExample extends Application 
{
	@Override
	public void start(final Stage stage) throws Exception 
	{
		final Parent root = FXMLLoader.load(getClass().getResource("fxml_example.fxml"));

		stage.setScene(new Scene(root, 300, 120));
		stage.setTitle("FirstFxmlExample");
		stage.show();
	}

	public static void main(final String[] args) 
	{
		launch(args);
	}
}