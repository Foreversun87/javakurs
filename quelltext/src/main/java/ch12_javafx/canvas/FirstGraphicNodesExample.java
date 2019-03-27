package ch12_javafx.canvas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Beispielprogramm zur Demonstration einfacher grafischer Nodes.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FirstGraphicNodesExample extends Application
{
	@Override
	public void start(final Stage primaryStage) throws Exception 
	{
		// Kreisbogen mit Beleuchtung  
		final Arc arc = new Arc(10, 10, 50, 50, 45, 270);
		arc.setType(ArcType.ROUND);
		arc.setFill(Color.GREENYELLOW);
		arc.setEffect(new Lighting());
	
		// Kreis mit Reflexion  
		final Circle circle = new Circle(10, 30, 30, Color.FIREBRICK);
		circle.setEffect(new Reflection());
	
		// Linie mit Schatten  
		final Line line = new Line(10, 10, 40, 10);
		line.setEffect(new DropShadow());
	
		// Rechteck mit Beleuchtung} 
		Rectangle rectangle = new Rectangle(10, 10, 120, 120);
		rectangle.setArcWidth(20);
		rectangle.setArcHeight(20);
		rectangle.setFill(Color.DODGERBLUE);
		rectangle.setEffect(new Lighting());
		
		final FlowPane flowPane = new FlowPane();
		flowPane.getChildren().addAll(arc, circle, line, rectangle);
	
		primaryStage.setScene(new Scene(flowPane, 300, 130));
		primaryStage.setTitle(this.getClass().getSimpleName());
		primaryStage.show();
	}
	
	public static void main(final String[] args)
	{
		launch(args);
	}
}

