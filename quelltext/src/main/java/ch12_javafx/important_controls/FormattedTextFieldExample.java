package ch12_javafx.important_controls;

import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.time.format.FormatStyle;
import java.util.Locale;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;

/**
 * Beispielprogramm zeigt den Einsatz von Formatter in TextFields
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class FormattedTextFieldExample extends Application
{
    @Override
    public void start(final Stage stage)
    {
        final StringConverter<Integer> intToString = new IntegerStringConverter();
        final TextField integerTextField = createFormattedTextField(intToString);
        integerTextField.setPromptText("Bitte eine Ganzzahl eingeben!");

        final StringConverter<LocalDate> dateToString = createLocalDateConverter();
        final TextField dateTextField = createFormattedTextField(dateToString);
        dateTextField.setPromptText("Datum im Format dd.MM.yyyy eingeben!");

        final VBox vbox = new VBox(30);
        vbox.setPadding(new Insets(5));
        vbox.getChildren().addAll(integerTextField, dateTextField);

        stage.setScene(new Scene(vbox, 400, 100));
        stage.setTitle("FormattedTextFieldExample");
        stage.show();
    }

    private TextField createFormattedTextField(final StringConverter<?> converter)
    {
        final TextField textField = new TextField();
        textField.setTextFormatter(new TextFormatter<>(converter));
        textField.setOnAction(event -> checkValidity(textField, converter));

        return textField;
    }

    private void checkValidity(final TextField textField, final StringConverter<?> converter)
    {
        try
        {
            converter.fromString(textField.getText());
        }
        catch (final RuntimeException ex)
        {
            DialogUtils.showExceptionDialog("Ungültige Eingabe", ex);
        }
    }

    private StringConverter<LocalDate> createLocalDateConverter()
    {
        return new LocalDateStringConverter(FormatStyle.MEDIUM, Locale.GERMANY, Chronology.ofLocale(Locale.GERMANY));
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}
