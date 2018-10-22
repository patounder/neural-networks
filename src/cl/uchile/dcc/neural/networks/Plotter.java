package cl.uchile.dcc.neural.networks;

import javax.swing.*;

import java.awt.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Plotter extends JFrame {

    private static final long serialVersionUID = 6294689542092367723L;

    public Plotter(String title) {
        super(title);

        // Create dataset
        XYDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Boys VS Girls weight comparison chart",
                "X-Axis", "Y-Axis", dataset);


        //Changes background color
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255,228,196));


        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        //Girls (Age,weight) series
        XYSeries series2 = new XYSeries("Girls");
        series2.add(1, 72.5);
        series2.add(2, 80.1);
        series2.add(3, 87.2);
        series2.add(4, 94.5);
        series2.add(5, 101.4);
        series2.add(6, 107.4);
        series2.add(7, 112.8);
        series2.add(8, 118.2);
        series2.add(9, 122.9);
        series2.add(10, 123.4);

        dataset.addSeries(series2);

        return dataset;
    }
}
