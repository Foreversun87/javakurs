package ch12_javafx.canvas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

/**
 * Beispielprogramm zur Demonstration einfacher SVG-Zeichenbefehle in JavaFX.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class HelloSvgWorld extends Application
{
    @Override
    public void start(final Stage primaryStage)
    {
        primaryStage.setTitle("Hello SVG World!");

        // Symbolischer Kometenschweif
        final SVGPath svgFigure = new SVGPath();
        svgFigure.setContent("M30,100 c75,55 60,100 120,110 ");

        // Mond
        final SVGPath svgMond = new SVGPath();
        svgMond.setContent("M40,20 A30,30 0 0,0 70,70 M40,20 A30,30 0 1,0 70,70");
        svgMond.fillProperty().set(Color.YELLOW);
        svgMond.strokeProperty().set(Color.DARKORANGE);

        svgMond.fillRuleProperty().set(FillRule.EVEN_ODD);
        svgMond.strokeWidthProperty().set(5.0);

        final StackPane root = new StackPane();
        root.getChildren().add(svgFigure);
        root.getChildren().add(svgMond);
        primaryStage.setScene(new Scene(root, 250, 150));
        primaryStage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}