package ch12_javafx.charts;

import java.time.Month;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Beispielprogramm für Diagramme
 *
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */

public class LineAndScatterChartExample extends Application
{
	@Override
	public void start(final Stage stage)
	{
		final CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Month");
		final NumberAxis yAxis = new NumberAxis();

		final ObservableList< XYChart.Series<String, Number>>  chartData =
															   createChartData();

		final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("Books sold per month");
		lineChart.setData(chartData);

		final ScatterChart scatterChart = new ScatterChart(xAxis, yAxis);
		scatterChart.setData(chartData);

		final FlowPane flowPane = new FlowPane(5, 5, lineChart, scatterChart);
		stage.setScene(new Scene(flowPane, 1100, 400));
		stage.setTitle("LineAndScatterChartExample");
		stage.show();
	}

	private ObservableList< XYChart.Series<String, Number>> createChartData()
	{
		final XYChart.Series<String, Number> series13 = createSeriesForYear("2013");
		final XYChart.Series<String, Number> series14 = createSeriesForYear("2014");
		final XYChart.Series<String, Number> series15 = createSeriesForYear("2015");

		return FXCollections.observableArrayList(series13, series14, series15);
	}

	private XYChart.Series<String, Number> createSeriesForYear(final String year)
	{
		final XYChart.Series<String, Number> series = new XYChart.Series<>();
		series.setName(year);

		for (final Month month : Month.values())
		{
			final String monthName = month.name().substring(0,3);
			final Number value = 50 + Math.random() * 150;
			series.getData().add(new XYChart.Data<String, Number>(monthName, value));
		}

		return series;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
