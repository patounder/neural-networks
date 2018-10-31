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

}
