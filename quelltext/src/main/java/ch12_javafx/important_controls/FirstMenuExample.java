package ch12_javafx.important_controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt den Einsatz von Menüs
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class FirstMenuExample extends Application
{
    @Override
    public void start(final Stage stage) throws Exception
    {
        final MenuBar menuBar = new MenuBar();
        final Menu fileMenu = new Menu("File");
        final MenuItem exitMenuItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(new MenuItem("New"), new MenuItem("Save"),
                                   new SeparatorMenuItem(), exitMenuItem);
    
        final Menu otherMenu = new Menu("Custom");
        otherMenu.getItems().addAll(new MenuItem("MenuItem 1"),
                                    new MenuItem("MenuItem 2"));
    
        // Spezielles Menu
        final CustomMenuItem customMenuItem = new CustomMenuItem(new Slider());
        customMenuItem.setHideOnClick(false);
        otherMenu.getItems().add(customMenuItem);
    
        // Action Handling für Exit und Slider
        exitMenuItem.setOnAction(event ->
        {
            final Alert alert = new Alert(AlertType.CONFIRMATION,
                                          "Do you want to quit?");
            alert.showAndWait().ifPresent(response ->
            {
                if (response == ButtonType.OK)
                {
                    stage.close();
                }
            });
        });
        customMenuItem.setOnAction(event ->
        {
            final Slider slider = (Slider)customMenuItem.getContent();
            System.out.println("Slider value: " + slider.getValue());
        });
    
        menuBar.getMenus().addAll(fileMenu, otherMenu);
        final VBox mainLayout = new VBox();
        mainLayout.getChildren().addAll(menuBar);
    
        stage.setTitle("FirstMenuExample");
        stage.setScene(new Scene(mainLayout, 300, 100));
        stage.show();
    }
    
        public static void main(final String[] args)
        {
            launch(args);
        }
}
