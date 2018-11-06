package main.cl.uchile.dcc.neural.networks.service.services;

import main.cl.uchile.dcc.neural.networks.service.dto.Line;
import main.cl.uchile.dcc.neural.networks.service.dto.Point;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ClassificationChart extends JFrame {

    public static final String CLASSIFICATION_CHART = "Classification Chart";
    public static final String X_AXIS_LABEL = "X-Axis";
    public static final String Y_AXIS_LABEL = "Y-Axis";

    private Line line;
    private List<Point> points;

    public ClassificationChart(String title, Line line, List<Point> points){
        super(title);
        this.line = line;
        this.points = points;

        XYSeriesCollection datasetCollection = new XYSeriesCollection();
        datasetCollection.addSeries(createLineSeries(line));

        List<XYSeries> pointsSeries = createScatterPlotSeries(points);
        datasetCollection.addSeries(pointsSeries.get(0));
        datasetCollection.addSeries(pointsSeries.get(1));

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

        renderer.setSeriesLinesVisible(2, false);
        renderer.setSeriesShapesVisible(2, true);

        plot.setRenderer(renderer);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private List<XYSeries> createScatterPlotSeries(List<Point> points) {
        XYSeries belowDataSeries = new XYSeries("Below");
        XYSeries aboveDataSeries = new XYSeries("Above");

        belowDataSeries.add(0,1);
        belowDataSeries.add(1,1);

        aboveDataSeries.add(5, 10);
        aboveDataSeries.add(6, 18);

       /* points.forEach(point ->{
            if(point.getClassification() <= 0){
                belowDataSeries.add(point.getAbscissa(), point.getOrdinate());
            }else {
                aboveDataSeries.add(point.getAbscissa(), point.getOrdinate());
            }
        });*/

        List<XYSeries> seriesList = new ArrayList<>();
        seriesList.add(belowDataSeries);
        seriesList.add(aboveDataSeries);
        return seriesList;
    }

    private XYSeries createLineSeries(Line line){

        String keyChart = "Y = X + " + line.getIntersection();

        XYSeries lineDataSeries = new XYSeries(keyChart);
        lineDataSeries.add(0, line.getSlope() * 0 + line.getIntersection());
        lineDataSeries.add(2, line.getSlope() * 2 + line.getIntersection());
        lineDataSeries.add(11, line.getSlope() * 11 + line.getIntersection());
        return lineDataSeries;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
