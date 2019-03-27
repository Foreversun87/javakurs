package ch12_javafx.important_controls.table_treetable;

import java.util.Arrays;
import java.util.List;

import ch12_javafx.important_controls.Person;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die mit JDK 8 eingeführte DatePicker-Komponente mit eigenem Renderer.
 *
 * @author Michael Inden
 *
 * Copyright 2014 by Michael Inden
 */
public class TreeTableViewExample2 extends Application
{
    public void start(final Stage stage)
    {
        final TreeItem<Person> root = createTreeData();

        final List<TreeTableColumn<Person, ?>> columns = createColumns();

        final TreeTableView<Person> treeTableView = new TreeTableView<Person>(root);
        treeTableView.getColumns().addAll(columns);

        final VBox vbox = new VBox();
        vbox.getChildren().addAll(treeTableView);

        stage.setScene(new Scene(vbox, 300, 250));
        stage.setTitle("TreeTableViewExample2");
        stage.show();
    }

    private TreeItem<Person> createTreeData()
    {
        final TreeItem<Person> root = createGroupTrreItem("All Persons");

        final TreeItem<Person> group1 = createGroupTrreItem("Group 1");
        final TreeItem<Person> childNode1_1 = createPersonTrreItem("Micha", 43, Color.BLUE, 184);
        final TreeItem<Person> childNode1_2 = createPersonTrreItem("Tom", 22, Color.GREEN, 177);
        final TreeItem<Person> childNode1_3 = createPersonTrreItem("Lili", 34, Color.BROWN, 170);

        final TreeItem<Person> group2 = createGroupTrreItem("Group 2");
        final TreeItem<Person> childNode2_1 = createPersonTrreItem("Tim", 43, Color.BLUE, 181);
        final TreeItem<Person> childNode2_2 = createPersonTrreItem("Jens", 47, Color.GRAY, 175);
        final TreeItem<Person> childNode2_3 = createPersonTrreItem("Andy", 31, Color.BROWN, 178);

        group1.getChildren().setAll(childNode1_1, childNode1_2, childNode1_3);
        group2.getChildren().setAll(childNode2_1, childNode2_2, childNode2_3);
        root.getChildren().setAll(group1, group2);

        // eigentlich eher UI-Eigenschaft und vom TreeView und nicht von
        // TreeItem, oder?
        root.setExpanded(true);
        group1.setExpanded(true);

        return root;
    }

    private TreeItem<Person> createGroupTrreItem(final String groupName)
    {
        return new TreeItem<>(new Person(groupName, null, Color.WHITE, -1));
    }

    private TreeItem<Person> createPersonTrreItem(final String name, final int age,
                                                  final Color eyecolor, final int size)
    {
        return new TreeItem<>(new Person(name, age, eyecolor, size));
    }

    private <V> TreeTableColumn<Person, V> createColumn(final String columnTitle, final String attributeName,
                                                        final int prefWidth)
    {
        final TreeTableColumn<Person, V> column = new TreeTableColumn<>(columnTitle);
        column.setPrefWidth(prefWidth);

        column.setCellValueFactory(new TreeItemPropertyValueFactory<Person, V>(attributeName));

        return column;
    }

    private List<TreeTableColumn<Person, ?>> createColumns()
    {
        final TreeTableColumn<Person, Integer> sizeColumn = createColumn("Size", "size", 70);
        registerRenderer(sizeColumn, " cm");

        return Arrays.asList(createColumn("Name", "name", 125), createColumn("Age", "age", 50), sizeColumn);
    }

	private void registerRenderer(final TreeTableColumn<Person, Integer> sizeColumn,
			                      final String unitPostfix)
	{
	    sizeColumn.setCellFactory(value -> new SpecialUnitCell(unitPostfix));
	}

	static class SpecialUnitCell extends TreeTableCell<Person, Integer>
	{
		private final String unitPostfix;

		SpecialUnitCell(final String unitPostfix)
		{
			this.unitPostfix = unitPostfix;
		}

		@Override
	    protected void updateItem(final Integer item, final boolean empty)
	    {
	        super.updateItem(item, empty);
	        if (!empty)
	        {
	            if (item.intValue() == -1)
	            {
	                setText(null);
	            }
	            else
	            {
	                setText(item + unitPostfix);
	            }
	        }
	        else
	        {
	            // Wichtig, sonst werden Texte dargestellt, obwohl
	            // Parent zugeklappt ist!!!
	            setText(null);
	        }
	    }
	}

    public static void main(final String[] args)
    {
        launch(args);
    }
}
