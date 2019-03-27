package ch12_javafx.fxml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Beispielprogramm nutzt FXML, aber setzt den Controller erst später im Programm.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FXMLExampleWithSpecialController extends Application 
{
	@Override
	public void start(final Stage stage) throws Exception {
	
		final URL fxmlUrl = getClass().getResource("fxml_example_no_controller.fxml");
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
		fxmlLoader.setController(new FXMLExampleSpecialController());
		final Parent root = fxmlLoader.load();
		
		// Fehler: würde den Controller wieder überschrieben
		//final Parent root = FXMLLoader.load(getClass().getResource("fxml_example_no_controller.fxml"));
		
		stage.setScene(new Scene(root, 450, 175));		
		stage.setTitle("FXMLExampleWithSpecialController");
		stage.show();
	}

	public static void main(final String[] args) 
	{
		launch(args);
	}
}