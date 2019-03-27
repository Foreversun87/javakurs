package ch12_javafx.swingmigration;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Beispielprogramm demonstiert wie man JavaFX in Swing einbinden kann.
 *
 * @author Michael Inden
 *
 * Copyright 2015, 2017 by Michael Inden
 */
public class JavaFXInSwingExample
{
	// Sicheres Starten einer Swing-Applikation
	public static void main(final String[] args)
	{
		SwingUtilities.invokeLater(() -> initAndShowGUI());
	}

	// Diese Methode läuft im Swing EDT
	private static void initAndShowGUI()
	{
		final JFrame frame = new JFrame("JavaFXInSwingExample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Swing Content
		final JButton jButton = new JButton("Swing-Button !");
		jButton.addActionListener(event ->
		                          jButton.setText(jButton.getText() + "!"));

		// JavaFX-Content-Container
		final JFXPanel fxPanel = new JFXPanel();

		frame.add(fxPanel, BorderLayout.CENTER);
		frame.add(jButton, BorderLayout.SOUTH);

		frame.setSize(600, 300);
		frame.setVisible(true);

		// JavaFX-Content initialisieren
		Platform.runLater(() -> initFX(fxPanel));
	}

	private static void initFX(final JFXPanel fxPanel)
	{
		final Text textWithEffects = new Text();
		textWithEffects.setText("JavaFX - Rotating Text");

		final LinearGradient linearGradient = new LinearGradient(0, 0, 1, 1,
				true, CycleMethod.NO_CYCLE,
				new Stop(0, Color.GREEN), new Stop(0.3, Color.BLUE),
				new Stop(0.6, Color.GOLD), new Stop(.85, Color.FIREBRICK));
		textWithEffects.setFill(linearGradient);
		textWithEffects.setFont(Font.font(null, FontWeight.BOLD, 52));
		textWithEffects.setEffect(new Reflection());

		// JavaFX-Ereignisverarbeitung
		final Button fxButton = new Button("JavaFX Button -- Start Animation");
		initFXAnimationButton(textWithEffects, fxButton);

		fxPanel.setScene(new Scene(new VBox(textWithEffects, fxButton)));
	}

    static void initFXAnimationButton(final Node node, final Button fxButton)
    {
        fxButton.setFont(Font.font(null, FontWeight.BOLD, 18));
		fxButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		fxButton.setOnAction(pressEvent ->
		{
			fxButton.setDisable(true);

			final Animation animation = createAnimation(node);
			animation.play();

			animation.setOnFinished(event -> fxButton.setDisable(false));
		});
    }

    static Transition createAnimation(final Node node) 
	{
	    final Duration oneSec = Duration.millis(1000);
		final ScaleTransition scale = new ScaleTransition(oneSec, node);
		scale.setByX(2);
		scale.setByY(2);

		final RotateTransition rotate = new RotateTransition(oneSec, node);
		rotate.setByAngle(45f);

		final Transition parallelTrans = new ParallelTransition(scale, rotate);
		parallelTrans.setCycleCount(4);
		parallelTrans.setAutoReverse(true);

		return parallelTrans;
	}
}
