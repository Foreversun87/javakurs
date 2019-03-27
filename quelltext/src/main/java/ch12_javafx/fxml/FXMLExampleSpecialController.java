package ch12_javafx.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Spezieller, erst im Programm initialisierter Controller
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class FXMLExampleSpecialController implements Initializable
{
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField     nameField;

    @FXML
    private Button        loginButton;

    @Override
    public void initialize(final URL location, final ResourceBundle resources)
    {
        loginButton.setOnAction(this::handleSubmitButtonAction);
    }

    protected void handleSubmitButtonAction(final ActionEvent event)
    {
        System.out.println("Sign in button pressed user: " + nameField.getText() + " pwd: " + passwordField.getText());
    }
}