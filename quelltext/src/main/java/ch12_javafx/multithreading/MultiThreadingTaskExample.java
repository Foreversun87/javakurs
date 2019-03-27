package ch12_javafx.multithreading;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultiThreadingTaskExample extends Application
{
@Override
public void start(final Stage stage)
{
	final Task<Integer> task = createTask();

	final Label label = new Label("Press Start to perform computation");
	final ProgressBar progressBar = new ProgressBar();
	final Button start = new Button("Start");
	final Button stop = new Button("Stop");

	start.setOnAction(event -> {
		start.disableProperty().set(true);

		// hier kommt die Magie !!!
		label.textProperty().bind(task.messageProperty());
		progressBar.progressProperty().bind(task.progressProperty());

		final Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	});
	stop.setOnAction(event -> {
		task.cancel();
		start.disableProperty().set(false);
	});

	task.setOnSucceeded(event ->
	{
		label.textProperty().unbind();
		label.setText("completed successfully with result " +
                      event.getSource().getValue());
	});

	final HBox hbox = new HBox(7, start, stop);
	hbox.setPadding(new Insets(7));

	final VBox vbox = new VBox(7, label, progressBar, hbox);
	vbox.setPadding(new Insets(7));
	stage.setScene(new Scene(vbox, 275, 100));
	stage.setTitle("MultiThreadingTaskExample");
	stage.show();
}

	public static void main(final String[] args)
	{
		launch(args);
	}

	public static Task<Integer> createTask()
	{
		final Task<Integer> task = new Task<Integer>()
		{
			@Override
			public Integer call() throws InterruptedException
			{
				for (int i = 10; i < 100; i++)
				{
					updateMessage("Computing ... " + i);
					updateProgress(i, 100);

					try
					{
						Thread.sleep(200);
					}
					catch (final InterruptedException ie)
					{
						if (isCancelled()) {
							updateMessage("CANCELLED");
							break;
						}
					}
				}

				if (!isCancelled())
				{
					updateProgress(100, 100);
					return 4711;
				}

				return null;
			}
		};
		return task;
	}
}
