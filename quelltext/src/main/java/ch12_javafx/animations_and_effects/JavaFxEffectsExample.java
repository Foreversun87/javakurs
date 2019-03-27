package ch12_javafx.animations_and_effects;

import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt verschiedene Effekte wie Schatten und Reflexion.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class JavaFxEffectsExample extends Application
{
    @Override
    public void start(final Stage stage) throws Exception
    {
        final Node labelNode = new Label("Hello Effects World!");

        final Image image = new Image(this.getClass().getResourceAsStream("example.png"));
        final Node imageView = new ImageView(image);

        final Button buttonNode = new Button("Activate effects");
        addEffectHandler(labelNode, imageView, buttonNode);

        final HBox hbox = new HBox(7);
        hbox.setPadding(new Insets(7, 7, 7, 7));

        final VBox vbox = new VBox(20);
        vbox.getChildren().addAll(labelNode, buttonNode);
        hbox.getChildren().addAll(vbox, imageView);

        stage.setScene(new Scene(hbox, 400, 300));
        stage.setTitle(JavaFxEffectsExample.class.getSimpleName());
        stage.show();
    }

    private void addEffectHandler(final Node labelNode, final Node imageView, final Button buttonNode)
    {
        buttonNode.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(final ActionEvent event)
            {
                // Schatteneffekt
                final Effect effect = new DropShadow(2, 7, 7, Color.BLACK);
                labelNode.setEffect(effect);

                // Kombination von Effekten
                final Effect dropShadoweffect = new DropShadow(5, 3, 5, Color.BLACK);
                final GaussianBlur gaussianEffect = new GaussianBlur(3);
                gaussianEffect.setInput(dropShadoweffect);
                final Reflection reflectionEffect = new Reflection();
                reflectionEffect.setInput(gaussianEffect);

                // Dynamisch zuweisen
                buttonNode.setEffect(reflectionEffect);
                imageView.setEffect(reflectionEffect);
            }
        });
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}