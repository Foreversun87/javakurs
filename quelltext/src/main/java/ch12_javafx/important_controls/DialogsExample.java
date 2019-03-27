package ch12_javafx.important_controls;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt den Einsatz von Dialogen, die mit Java FX 8 Update 40 ins JDK integriert wurden.
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class DialogsExample extends Application
{
    @Override
    public void start(final Stage stage)
    {
        final Optional<ButtonType> result = showConfirmationDialog();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            final Optional<String> enteredText = showTextInputDialog();
            System.out.println(enteredText);

            final Optional<String> selectedNickName = showNickNameSelectDialog();
            System.out.println(selectedNickName);
        }
    }

    private Optional<ButtonType> showConfirmationDialog()
    {
        return new Alert(Alert.AlertType.CONFIRMATION, "Do you want to learn more about dialogs?").showAndWait();
    }

    private Optional<String> showTextInputDialog()
    {
        final TextInputDialog textDialog = new TextInputDialog("What's your name?");
        textDialog.setTitle("Text Input Dialog");
        textDialog.setHeaderText("This is a Text Input Dialog");
        textDialog.setContentText("Please enter your name:");
        textDialog.setGraphic(new ImageView());

        return textDialog.showAndWait();
    }

    private Optional<String> showNickNameSelectDialog()
    {
        final ChoiceDialog<String> dialog = new ChoiceDialog<>("Iron", "Dark", "Lord", "Dragon");
        dialog.setTitle("Nickname Selection");
        dialog.setHeaderText("");
        dialog.setContentText("Please select your desired nickname:");
        dialog.setGraphic(null);

        return dialog.showAndWait();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
