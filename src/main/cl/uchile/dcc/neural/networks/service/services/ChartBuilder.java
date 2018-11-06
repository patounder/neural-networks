package main.cl.uchile.dcc.neural.networks.service.services;

import main.cl.uchile.dcc.neural.networks.service.dto.Line;
import main.cl.uchile.dcc.neural.networks.service.dto.Point;

import javax.swing.*;
import java.util.List;

public class ChartBuilder {

    public void showClassificationChart(Line line, List<Point> points){
        SwingUtilities.invokeLater(() -> {
            ClassificationChart example = new ClassificationChart("Classification Chart", line, points);
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
