package ch12_javafx.canvas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * Beispielprogramm zur Demonstration einfacher Zeichenbefehle im JavaFX Canvas.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstCanvasExample extends Application 
{
	@Override
	public void start(final Stage primaryStage) throws Exception 
	{
		final Canvas canvas = new Canvas(300, 200);
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		gc.setStroke(Color.DARKGOLDENROD);
		gc.setLineWidth(4);
		gc.strokeOval(10, 20, 40, 40);

		gc.setFill(Color.BLUE);
		gc.fillRoundRect(60, 20, 40, 40, 10, 10);

		gc.setStroke(Color.FIREBRICK);
		gc.beginPath();
		gc.moveTo(110, 30);
		gc.lineTo(170, 20);
		gc.bezierCurveTo(150, 110, 130, 30, 110, 40);
		gc.closePath();
		// Pfad malen
		gc.stroke();

		gc.setFill(Color.web("dodgerblue"));
		gc.fillArc(180, 30, 30, 30, 45, 270, ArcType.ROUND);

		final FlowPane flowPane = new FlowPane();
		flowPane.getChildren().addAll(canvas);

		primaryStage.setScene(new Scene(flowPane, 250, 100));
		primaryStage.setTitle(this.getClass().getSimpleName());
		primaryStage.show();
	}

	public static void main(final String[] args) 
	{
		launch(args);
	}
}