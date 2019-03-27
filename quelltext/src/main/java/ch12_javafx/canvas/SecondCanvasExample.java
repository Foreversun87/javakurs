package ch12_javafx.canvas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

/**
 * Beispielprogramm zur Demonstration einfacher Zeichenbefehle und Beleuchtung im Canvas in JavaFX.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2015 by Michael Inden 
 */
public class SecondCanvasExample extends Application
{
    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        final Canvas canvas = new Canvas(550, 260);
        createGraphics(canvas);

        final CheckBox applyLightning = new CheckBox("Apply Lightning");
        // Beleuchtung  
        applyLightning.setOnAction(event -> applyLightning(canvas, applyLightning));

        // Reflexionen gehen nur auf Ebene der Node's  
        final Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        canvas.setEffect(reflection);

        final FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(5));
        flowPane.getChildren().addAll(applyLightning, canvas);

        primaryStage.setScene(new Scene(flowPane, 550, 500));
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }

    private GraphicsContext createGraphics(final Canvas canvas)
    {
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.save();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.scale(3, 4);

        drawOval(gc);
        fillRoundRectSpecialRadialGradient(gc);
        fillPathWithLinearGradient(gc);

        gc.restore();
        return gc;
    }

    private void drawOval(final GraphicsContext gc)
    {
        gc.setStroke(Color.BLUEVIOLET);
        gc.setLineWidth(7);
        gc.strokeOval(10, 10, 40, 40);
    }

    private void fillRoundRectSpecialRadialGradient(final GraphicsContext gc)
    {
        gc.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.1, true, CycleMethod.REFLECT, new Stop(0.0, Color.LIGHTBLUE),
                                      new Stop(0.5, Color.BLUE), new Stop(1.0, Color.DODGERBLUE)));
        gc.fillRoundRect(60, 10, 40, 40, 10, 10);
        gc.applyEffect(new DropShadow(20, 5, 5, Color.BLACK));
    }

    private void fillPathWithLinearGradient(final GraphicsContext gc)
    {
        gc.setStroke(Color.FIREBRICK);
        gc.beginPath();
        gc.moveTo(110, 20);
        gc.lineTo(170, 10);
        gc.bezierCurveTo(150, 110, 130, 20, 110, 30);
        gc.closePath();
        // Pfad malen
        gc.stroke();
        gc.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.GOLD),
                                      new Stop(0.6, Color.RED), new Stop(.85, Color.FIREBRICK)));
        gc.fill();
    }

    private void applyLightning(final Canvas canvas, final CheckBox applyLightning)
    {
        if (applyLightning.isSelected())
        {
            // $\mbox{\bfseries Reflexionen gehen nur auf Ebene der Node's }$
            final Light.Distant light = new Light.Distant();
            final Lighting lighting = new Lighting();
            lighting.setLight(light);
            lighting.setSurfaceScale(10.0);

            // $\mbox{\bfseries Beleuchtungseffekt anwenden }$
            final GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.applyEffect(lighting);
        }
        else
        {
            // $\mbox{\bfseries Beleuchtungseffekt zur�cksetzen => Grafik neu erzeugen }$
            createGraphics(canvas);
        }
    }
}
