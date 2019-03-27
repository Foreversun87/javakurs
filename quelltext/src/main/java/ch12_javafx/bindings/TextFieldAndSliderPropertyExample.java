package ch12_javafx.bindings;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 * Beispielprogramm zur Verknüpfung von Properties und Bedeinelementen.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class TextFieldAndSliderPropertyExample extends Application
{
    final ChangeListener<Number> changeReporter = (observableValue, oldValue, newValue) -> System.out
                                                                .println("Value changed: " + oldValue + " -> "
                                                                         + newValue);

    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        final Slider slider = new Slider(10, 100, 71);
        slider.valueProperty().addListener(changeReporter);
        slider.showTickMarksProperty().set(true);
        slider.showTickLabelsProperty().set(true);
        
        final TextField textField = new TextField();

        textField.textProperty().bindBidirectional(slider.valueProperty(), new NumberStringConverter());

        final VBox vBox = new VBox(textField, slider);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setSpacing(10);

        primaryStage.setScene(new Scene(vBox, 300, 100));
        primaryStage.setTitle("TextFieldAndSliderPropertyExample");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
