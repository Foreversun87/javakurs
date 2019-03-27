package ch12_javafx.bonus.important_controls;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die mit Java FX 8 Update 40 eingeführte Spinner-Komponente.
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class SpinnerExample extends Application
{
    @Override
    public void start(final Stage stage)
    {
        final String[] styles = {
                        "spinner", // Spinner.DEFAULT_STYLE_CLASS // kein Zugriff
                        Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL,
                        Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL,
                        Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL,
                        Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL,
                        Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL };

        final List<Spinner<Integer>> intSpinners = new ArrayList<>();
        final List<Spinner<Double>> doubleSpinners = new ArrayList<>();
        final List<Spinner<String>> valueSpinners = new ArrayList<>();
         
        for (final String style : styles)
        {
           final Spinner<Integer> intSpinner = new Spinner<>(0, 100, 5);
           intSpinner.getStyleClass().add(style);

           final Spinner<Double> doubleSpinner = new Spinner<>(0.0, 1.0, 0.5, 0.01);
           doubleSpinner.getStyleClass().add(style);

           final String[] names = { "Tim", "Tom", "Jerry" };
           final ObservableList<String> items = 
                                        FXCollections.observableArrayList(names);
           final Spinner<String> stringSpinner = new Spinner<>(items);
           stringSpinner.getStyleClass().add(style);
           
           intSpinners.add(intSpinner);
           doubleSpinners.add(doubleSpinner);
           valueSpinners.add(stringSpinner);
        }

        final HBox hbox = new HBox(10);
        hbox.getChildren().addAll(intSpinners);
        final HBox hbox2 = new HBox(10);
        hbox2.getChildren().addAll(doubleSpinners);
        final HBox hbox3 = new HBox(10);
        hbox3.getChildren().addAll(valueSpinners);

        final VBox vbox = new VBox(30);
        vbox.setPadding(new Insets(5));
        vbox.getChildren().addAll(hbox, hbox2, hbox3);

        stage.setScene(new Scene(vbox, 550, 250));
        stage.setTitle("SpinnerExample");
        stage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

}
