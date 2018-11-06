package main.cl.uchile.dcc.neural.networks.service.services;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class ClassificationChart extends JFrame {

    public static final String CLASSIFICATION_CHART = "Classification Chart";
    public static final String X_AXIS_LABEL = "X-Axis";
    public static final String Y_AXIS_LABEL = "Y-Axis";

    public ClassificationChart(String title){
        super(title);

        XYSeriesCollection datasetCollection = new XYSeriesCollection();
        datasetCollection.addSeries(createLineSeries());
        datasetCollection.addSeries(createScatterPlotSeries());

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                CLASSIFICATION_CHART,
                X_AXIS_LABEL,
                Y_AXIS_LABEL,
                datasetCollection,
                PlotOrientation.VERTICAL,
                true, true, false);

        XYPlot plot = (XYPlot)chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // "0" is the line plot
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, false);

        // "1" is the scatter plot
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);

        plot.setRenderer(renderer);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYSeries createScatterPlotSeries() {
        XYSeries scatterplotDataSeries = new XYSeries("Girls");
        scatterplotDataSeries.add(1, 15);
        scatterplotDataSeries.add(2, 8);
        scatterplotDataSeries.add(3, 22);
        scatterplotDataSeries.add(4, 5);
        scatterplotDataSeries.add(5, 10);
        scatterplotDataSeries.add(6, 18);
        scatterplotDataSeries.add(7, 4);
        scatterplotDataSeries.add(8, 13);
        scatterplotDataSeries.add(9, 3);
        scatterplotDataSeries.add(10, 12);
        return scatterplotDataSeries;
    }

    private XYSeries createLineSeries(){
        XYSeries lineDataSeries = new XYSeries("Y = X + 2");
        lineDataSeries.add(0, 2);
        lineDataSeries.add(2, 4);
        lineDataSeries.add(21, 23);
        return lineDataSeries;
    }
}
