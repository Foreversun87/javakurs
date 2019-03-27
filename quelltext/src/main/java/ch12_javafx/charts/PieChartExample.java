package ch12_javafx.charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm für Tortendiagramme
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class PieChartExample extends Application {

	@Override
	public void start(final Stage initialStage) throws Exception
	{
		final PieChart pieChart = new PieChart();
		pieChart.setData(createPieChartData());

		pieChart.setLabelLineLength(10);
		pieChart.setLegendSide(Side.LEFT);

		initialStage.setScene(new Scene(new StackPane(pieChart), 500, 400));
		initialStage.setTitle("PieChartExample");
		initialStage.show();
	}

	public static ObservableList<PieChart.Data> createPieChartData()
	{
		final ObservableList<PieChart.Data> pieChartData =
											FXCollections.observableArrayList();

		pieChartData.add(new PieChart.Data("JavaFX", 24.0));
		pieChartData.add(new PieChart.Data("Swing", 54.0));
		pieChartData.add(new PieChart.Data("AWT", 5.0));
		pieChartData.add(new PieChart.Data("GWT", 6.0));
		pieChartData.add(new PieChart.Data("SWT", 11.0));

		return pieChartData;
	}

	public static void main(final String[] args) 
	{
		Application.launch(args);
	}
}
