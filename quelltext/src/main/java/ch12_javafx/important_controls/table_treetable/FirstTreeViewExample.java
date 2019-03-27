package ch12_javafx.important_controls.table_treetable;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Beispielprogramm zeigt die TreeView-Komponente.
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class FirstTreeViewExample extends Application
{
    private final Node rootIcon = new ImageView(new Image(getClass().getResourceAsStream("circle.png")));
    private ImageView createCrossImage()
    {
        return new ImageView(new Image(getClass().getResourceAsStream("cross.png")));
    }

    @Override
    public void start(Stage primaryStage)
    {
        final TreeItem<String> root = buildTree();
        root.setExpanded(true);

        final TreeView<String> treeView = new TreeView<>(root);

        final Scene scene = new Scene(treeView, 300, 200);

        primaryStage.setTitle("Hello Tree World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TreeItem<String> buildTree()
    {
        final TreeItem<String> root = new TreeItem<>("Root Node", rootIcon);

        final TreeItem<String> sub1 = new TreeItem<>("Item 1");

        final TreeItem<String> sub2 = new TreeItem<>("Sub Node 2", createCrossImage());
        sub2.getChildren().add(new TreeItem<>("Item 2-1"));
        sub2.getChildren().add(new TreeItem<>("Item 2-2"));
        sub2.getChildren().add(new TreeItem<>("Item 2-3"));

        final TreeItem<String> sub3 = new TreeItem<>("Item 3");

        final TreeItem<String> sub4 = new TreeItem<>("Sub Node 4", createCrossImage());
        sub4.getChildren().add(new TreeItem<String>("Item 4-1"));

        root.getChildren().addAll(sub1, sub2, sub3, sub4);

        return root;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
