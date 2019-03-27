package ch12_javafx.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die optische Gestaltung von zwei Buttons mithilfe von CSS. 
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstCssExample extends Application 
{
	@Override
	public void start(final Stage primaryStage) throws Exception 
	{
		final Button loginbutton = new Button("Login Button");
		loginbutton.setStyle("-fx-text-fill: silver; -fx-font-size: 18pt;" +
		                       "-fx-font-weight: bold; " +
				               "-fx-background-color: " +
				               "radial-gradient(center 25% 25%, radius 50%, " +
				               "reflect, dodgerblue, darkblue 75%, dodgerblue);");

		final Button fancyButton = new Button("Fancy Login");
		fancyButton.setStyle("-fx-font-weight: bold;"
			+ "-fx-font-family: \"Dialog\"; -fx-font-size: 36pt;"
			+ "-fx-effect: dropshadow( three-pass-box , black, 5, 0.2 , 2 , 3);"
			+ "-fx-text-fill: linear-gradient(to left, darkviolet 15%, yellow 45%, " 
			+ " red 75%, firebrick 85%); "
		    + "-fx-background-color: linear-gradient(darkblue 10%, #ABCDEF 65%, dodgerblue 90%)");
		
		final FlowPane flowPane = new FlowPane();
		flowPane.setHgap(7);
		flowPane.setVgap(7);
		flowPane.setPadding(new Insets(7,7,7,7));
		flowPane.getChildren().addAll(loginbutton, fancyButton);

		primaryStage.setScene(new Scene(flowPane, 570, 110));
		primaryStage.setTitle(this.getClass().getSimpleName());
		primaryStage.show();
	}

	public static void main(final String[] args) 
	{
		launch(args);
	}
}