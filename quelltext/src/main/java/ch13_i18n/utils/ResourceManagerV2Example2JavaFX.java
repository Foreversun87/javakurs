package ch13_i18n.utils;

import java.util.List;
import java.util.Locale;

import ch13_i18n.basics.LocaleUtils;
import ch13_i18n.basics.ResourceKeys;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Beispielprogramm zur Demonstration der Nutzung der Klasse ResourceManagerV2
 * <br>
 * Die Sprachauswahl erfolgt hier in einem Menü
 * 
 * @author Michael Inden
 * 
 *         Copyright 2017 by Michael Inden
 */
public class ResourceManagerV2Example2JavaFX extends Application
{
    private static final ResourceManagerV2 resourceManager = ResourceManagerV2.createInstance();

    private final MenuBar                  menuBar         = new MenuBar();
    private final ToggleGroup toggleGroup = new ToggleGroup();

    @Override
    public void start(final Stage stage) throws Exception
    {
        createAndAddMenus();

        final VBox vbox = new VBox(5);
        vbox.setPadding(new Insets(7));

        final BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(menuBar);
        mainLayout.setBottom(vbox);

        stage.setTitle("ResourceManagerV2Example2JavaFX");
        stage.setScene(new Scene(mainLayout, 300, 110));
        stage.sizeToScene();
        stage.show();
    }

    private void createAndAddMenus()
    {
        final Menu fileMenu = new Menu(getLangString(ResourceKeys.txt_file));
        final Menu languageMenu = createLanguageMenu();    
        final MenuItem exitMenuItem = createMenuItem(ResourceKeys.txt_quit);
        
    	fileMenu.getItems().addAll(createMenuItem(ResourceKeys.txt_new),
    			                   createMenuItem(ResourceKeys.txt_open),
    			                   new SeparatorMenuItem(), 
    			                   languageMenu, 
    			                   new SeparatorMenuItem(), 
    			                   exitMenuItem);
        
        menuBar.getMenus().addAll(fileMenu);    
    }
    
    private Menu createLanguageMenu() 
    {
    	    final Menu languageMenu = new Menu(getLangString(ResourceKeys.txt_languages));
    	 
    	    // Vorhandene Locales ermitteln und sortieren
        final List<Locale> availableLocales = resourceManager.getAvailableLocales();
        availableLocales.sort(LocaleUtils.LOCALE_COMPARATOR);
    
        // Entsprechende Menüeinträge bereitstellen
        for (final Locale currentLocale : availableLocales)
        {
        	languageMenu.getItems().add(createMenuItem(currentLocale));
        }
        
        return languageMenu;
    }
    
    private MenuItem createMenuItem(final Object userData)
    {
        if (userData instanceof ResourceKeys)
        {
            final ResourceKeys resourceKey = (ResourceKeys) userData;
            final String text = resourceManager.getLangString(resourceKey);
            
            final MenuItem menuItem = new MenuItem(text);
            return initMenuItem(menuItem, userData);
        }
        if (userData instanceof Locale)
        {
            final Locale menuLocale = (Locale) userData;
            final Locale currentLocale = resourceManager.getCurrentLocale();
            final String origLanguage = menuLocale.getDisplayLanguage();
            final String language = menuLocale.getDisplayLanguage(currentLocale);
            final String country = menuLocale.getDisplayCountry(currentLocale);
            
            // Kein Schrägstrich, wenn keine Landesangabe erfolgt
            final String text = language + " (" + origLanguage + ") " + 
                                (country.isEmpty() ? "" : " / " + country);
            
            final RadioMenuItem menuItem = new RadioMenuItem(text);
            menuItem.setToggleGroup(toggleGroup);
            return initMenuItem(menuItem, userData);
        }
    
        throw new IllegalStateException();
    }

    private MenuItem initMenuItem(final MenuItem menuItem, final Object userData) 
    {
    	final Runnable action = () -> handleMenuAction(menuItem.getUserData());
    
    	menuItem.setOnAction(event -> Platform.runLater(action));
    	menuItem.setUserData(userData);
    	return menuItem;
    }
    
    public void handleMenuAction(final Object object)
    {
        // Menüverarbeitung
        if (object instanceof ResourceKeys)
        {
            final ResourceKeys resourceKey = (ResourceKeys) object;
            switch (resourceKey)
            {
                case txt_new:
                case txt_open:
                case txt_save:
                	final Alert alert = new Alert(AlertType.WARNING, 
                			                     "Not implemented yet!");
                	alert.showAndWait();
                    break;
                case txt_quit:
                	Platform.exit();
            }
        }
    
        // Sprachmenüs bearbeiten
        if (object instanceof Locale)
        {
            final Locale newLocale = (Locale) object;
    
            resourceManager.activateLocale(newLocale);
            menuBar.getMenus().clear();
            createAndAddMenus();
        }
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