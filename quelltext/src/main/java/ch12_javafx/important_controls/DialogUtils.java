package ch12_javafx.important_controls;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

 /**
 * Utility-Klasse für den Einsatz von Dialogen
 * 
 * @author Michael Inden
 * 
 * Copyright 2015 by Michael Inden 
 */
public class DialogUtils
{
    public static void showExceptionDialog(final String hint,
                                           final Exception ex)
    {
        final Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Internal Software Error");
        alert.setHeaderText(hint);
        alert.setContentText(ex.toString());

        final Pane detailsPane = createStacktracePane(ex);
        alert.getDialogPane().setExpandableContent(detailsPane);

        alert.showAndWait();
    }

    private static Pane createStacktracePane(final Exception ex)
    {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);

        final Label details = new Label("Stacktrace:");
        final TextArea textArea = new TextArea(sw.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        final FlowPane contentPane = new FlowPane();
        contentPane.getChildren().addAll(details, textArea);
        return contentPane;
    }
}
