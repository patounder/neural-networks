package main.cl.uchile.dcc.neural.networks.service.services;

import javax.swing.*;

public class ChartBuilder {

    public void showLineChart(){
        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart("First Line Chart");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }

    public void showScatterPlotChart(){
        SwingUtilities.invokeLater(() -> {
            ScatterPlotChart scatterPlotChart = new ScatterPlotChart("Example Scatter Plot");
            scatterPlotChart .setSize(800, 400);
            scatterPlotChart .setLocationRelativeTo(null);
            scatterPlotChart .setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            scatterPlotChart .setVisible(true);
        });
    }

}
