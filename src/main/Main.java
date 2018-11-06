package main;

import main.cl.uchile.dcc.neural.networks.service.services.ChartBuilder;

public class Main {


    public static void main(String[] args) {

        ChartBuilder chartBuilder = new ChartBuilder();
        chartBuilder.showClassificationChart();

        //chartBuilder.showScatterPlotChart();
    }

}
