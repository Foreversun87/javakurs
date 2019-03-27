package ch12_javafx.important_controls.table_treetable;

import java.util.Arrays;
import java.util.List;

import ch12_javafx.important_controls.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die TableView-Komponente.
 *
 * @author Michael Inden
 *
 * Copyright 2015, 2017 by Michael Inden
 */
public class TableViewExample extends Application
{
    @Override
    public void start(final Stage stage)
    {
        final List<Person> persons = createDemoPersons();
        final ObservableList<Person> entries = FXCollections.observableArrayList(persons);
    
        final TableView<Person> tableView = createTableView(entries);
        final VBox root = new VBox(7, tableView);
        root.setPadding(new Insets(7));
    
        stage.setScene(new Scene(root, 400, 300));
        stage.setTitle("TableViewExample");
        stage.show();
    }
    
    public TableView<Person> createTableView(final ObservableList<Person> data)
    {
        // TableView und Spalten erzeugen
        final TableView<Person> tableView = new TableView<>();
        final TableColumn<Person, String> nameCol = new TableColumn<>("Name");
        final TableColumn<Person, Integer> ageCol = new TableColumn<>("Age");
        final TableColumn<Person, Color> eyeCol = new TableColumn<>("Eyecolor");
        final TableColumn<Person, Integer> sizeCol = new TableColumn<>("Size");
        tableView.getColumns().addAll(nameCol, ageCol, eyeCol, sizeCol);
    
        // fragile Verbindung basierend auf Strings
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        eyeCol.setCellValueFactory(new PropertyValueFactory<>("eyecolor"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
    
        eyeCol.setCellFactory(value -> new ColorCell());
    
        tableView.setItems(data);
        return tableView;
    }
    
    static class ColorCell extends TableCell<Person, Color>
    {
        @Override
        public void updateItem(Color item, boolean empty)
        {
            super.updateItem(item, empty);
            if (item != null)
            {
                final Ellipse circle = new Ellipse(15, 15);
                circle.setFill(item);
                setGraphic(circle);
            }
        }
    }

    public static void main(String[] args)
    {
        launch(TableViewExample.class, args);
    }

    private  List<Person> createDemoPersons()
    {
        final Person micha = new Person("Micha", 43, Color.BLUE, 184);
        final Person tom = new Person("Tom", 22, Color.GREEN, 177);
        final Person lili = new Person("Lili", 34, Color.BROWN, 170);

        final Person tim = new Person("Tim", 43, Color.BLUE, 181);
        final Person jens = new Person("Jens", 47,Color.GRAY, 175);
        final Person andy = new Person("Andy", 31,Color.BROWN, 178);

        return Arrays.asList(micha, tom, lili, tim, jens, andy);
    }
}
