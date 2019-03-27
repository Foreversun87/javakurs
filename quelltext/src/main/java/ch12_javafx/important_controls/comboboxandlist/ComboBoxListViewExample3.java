package ch12_javafx.important_controls.comboboxandlist;

import java.util.Arrays;
import java.util.List;

import ch12_javafx.important_controls.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die ComboBox- und ListView-Komponente mit eigenem Renderer
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class ComboBoxListViewExample3 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        final List<Person> persons = createDemoPersons();
        final ObservableList<Person> entries =
                                     FXCollections.observableArrayList(persons);
    
        final ComboBox<Person> comboBox = new ComboBox<>(entries);
        final ListView<Person> listView = new ListView<>(entries);
    
        comboBox.setCellFactory(list -> new PersonCell());
        comboBox.setButtonCell(new PersonCell());
        listView.setCellFactory(list -> new PersonCell());
    
        final VBox vBox = new VBox(10, comboBox, listView);
        vBox.setPadding(new Insets(7));
    
        primaryStage.setScene(new Scene(vBox, 300, 200));
        primaryStage.setTitle("ComboxBoxListViewExample3");
        primaryStage.show();
    }
    
    private List<Person> createDemoPersons()
    {
        final Person micha = new Person("Micha", 43, Color.BLUE, 184);
        final Person tom = new Person("Tom", 22, Color.GREEN, 177);
        final Person tim = new Person("Tim", 43, Color.BLUE, 181);
        final Person andy = new Person("Andy", 31,Color.BROWN, 178);
    
        return Arrays.asList(micha, tom, tim, andy);
    }
    
    // "Renderer"
    static class PersonCell extends ListCell<Person>
    {
        @Override
        public void updateItem(Person item, boolean empty)
        {
            super.updateItem(item, empty);
            if (item != null)
            {
                final Rectangle rect = new Rectangle(30, 30);
                rect.setFill(item.getEyecolor());
                setGraphic(rect);
    
                setText(item.getName() + " (" + item.getAge() + " years)");
            }
        }
    }
    
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
