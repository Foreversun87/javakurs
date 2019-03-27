package ch13_i18n.utils;

import java.util.Locale;

import ch13_i18n.basics.ResourceKeys;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Beispielprogramm zur Demonstration der Nutzung der Klasse ResourceManager, um
 * �ber Buttons ein Men� sprachabh�ngig zu gestalten 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public final class ResourceManagerExampleJavaFX extends Application
{
    private static final ResourceManager resourceManager = 
    		                             ResourceManager.createInstance();
       
    @Override
    public void start(final Stage stage) throws Exception
    {
        final MenuBar menuBar = new MenuBar();
        createAndAddMenus(menuBar);          

        final HBox hbox = createLanguageSelectionPanel(menuBar);
        
        final BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(menuBar);
        mainLayout.setBottom(hbox);
        
        stage.setTitle("ResourceManagerExampleJavaFX");
        stage.setScene(new Scene(mainLayout, 300, 200));
        stage.show();
    }

    private void createAndAddMenus(final  MenuBar menuBar)
    {
        final Menu fileMenu = new Menu(getLangString(ResourceKeys.txt_file));           
        fileMenu.getItems().addAll(new MenuItem(getLangString(ResourceKeys.txt_new)),
                                new MenuItem(getLangString(ResourceKeys.txt_open)),
                                new SeparatorMenuItem(),
                                new MenuItem(getLangString(ResourceKeys.txt_properties)),
                                new SeparatorMenuItem(),
                                new MenuItem(getLangString(ResourceKeys.txt_quit)));

        menuBar.getMenus().addAll(fileMenu);
    }
    
	private HBox createLanguageSelectionPanel(final MenuBar menuBar) 
	{
		final ToggleGroup group = new ToggleGroup();
        final RadioButton deButton = createRadioButton(Locale.GERMANY, group);
        final RadioButton enButton = createRadioButton(Locale.UK, group);
        final RadioButton frButton = createRadioButton(Locale.FRANCE, group);
        deButton.setSelected(true);

        group.selectedToggleProperty().addListener((ov, oldToggle, newToggle) -> 
        {		    
		    final Locale selectedLocale = (Locale)newToggle.getUserData();
		    	
	        resourceManager.activateLocale(selectedLocale);
	        menuBar.getMenus().clear();
	        createAndAddMenus(menuBar); 		                   
		});
        
        final HBox hbox = new HBox(5, deButton, enButton, frButton);
        hbox.setPadding(new Insets(7));
		return hbox;
	}

    private RadioButton createRadioButton(final Locale locale,
    		                             final ToggleGroup toggleGroup)
    {
        final String name = locale.getDisplayLanguage();
        final RadioButton button = new RadioButton(name);
        button.setUserData(locale);
        button.setToggleGroup(toggleGroup);
        return button;
    }
    
    private String getLangString(final ResourceKeys key)
    {
        return resourceManager.getLangString(key);
    }
    
    public static void main(final String[] args)
    {
        launch(args);
    }
}