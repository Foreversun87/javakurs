package ch12_javafx.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller zum FirstFxmlExample.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FXMLExampleController
{
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField     nameField;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event)
    {
        System.out.println("Sign in button pressed user: " + nameField.getText() + " pwd: " + passwordField.getText());
    }
}