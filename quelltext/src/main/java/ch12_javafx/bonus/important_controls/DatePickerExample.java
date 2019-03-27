package ch12_javafx.bonus.important_controls;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die mit JDK 8 eingefuehrte DatePicker-Komponente.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class DatePickerExample extends Application 
{
	@Override
	public void start(final Stage primaryStage) 
	{
		// DatePicker mit Date and Time API-Funktionalitaet initialisieren  
		final LocalDate localDate = LocalDate.now();
		final DatePicker datepicker = new DatePicker(localDate);

		datepicker.setOnAction((event) -> 
		{
			// Gewaehltes Datum ermitteln  
			final LocalDate selectedDate = datepicker.getValue();
			System.out.println("Selected date: " + selectedDate);
		});

		final FlowPane root = new FlowPane();
		root.getChildren().add(datepicker);

		final Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("DatePickerExample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(final String[] args) 
	{
		launch(args);
	}
}