package ch12_javafx.animations_and_effects;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Beispielprogramm zeigt eine Animation eines Texts mit Gr��enver�nderung und Rotation.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class AnimationExample extends Application
{
    public void start(final Stage stage)
    {
        final Button buttonNode = new Button("Start Animations");

        final VBox vbox = new VBox(10);
        vbox.getChildren().addAll(buttonNode);

        addAnimation(buttonNode, vbox);

        stage.setScene(new Scene(vbox, 300, 250));
        stage.setTitle(AnimationExample.class.getSimpleName());
        stage.show();
    }

    private static void addAnimation(final Button buttonNode, final VBox vbox)
    {
        buttonNode.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(final ActionEvent event)
            {
                final Node labelNode = new Label("Hello JavaFX World!");
                vbox.getChildren().addAll(labelNode);

                // Schatteneffekt
                final Effect effect = new DropShadow(2, 7, 7, Color.BLACK);
                labelNode.setEffect(effect);

                // Gr�ssen�nderung
                final ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(3000), labelNode);
                scaleTransition.setByX(4);
                scaleTransition.setByY(6);
                scaleTransition.setCycleCount(10);
                scaleTransition.setAutoReverse(true);

                final RotateTransition rotateTransition = new RotateTransition(Duration.millis(1500), labelNode);
                rotateTransition.setByAngle(270);
                rotateTransition.setCycleCount(20);
                rotateTransition.setAutoReverse(true);

                final ParallelTransition parallelTransition = new ParallelTransition(labelNode, scaleTransition,
                                                                                     rotateTransition);
                parallelTransition.play();
            }
        });
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}