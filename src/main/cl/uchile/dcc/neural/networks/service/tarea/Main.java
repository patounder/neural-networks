package main.cl.uchile.dcc.neural.networks.service.tarea;

import main.cl.uchile.dcc.neural.networks.service.PerceptonBuilder;
import main.cl.uchile.dcc.neural.networks.service.Perceptron;
import main.cl.uchile.dcc.neural.networks.service.PointFactory;
import main.cl.uchile.dcc.neural.networks.service.dto.Line;
import main.cl.uchile.dcc.neural.networks.service.dto.Point;
import main.cl.uchile.dcc.neural.networks.service.services.ChartBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        /*
        Perceptron perceptron = PerceptonBuilder.getNandPerceptron();

        Line line = new Line(2, 1);
        perceptron.lineBasedTraining(line);

        List<Point> points = PointFactory.getRandomPoints(4);

        points.forEach( point -> {
            double pointClassification = perceptron.feed(Arrays.asList(point.getAbscissa(), point.getOrdinate()));
            point.setClassification((int) pointClassification);
        });

        ChartBuilder chartBuilder = new ChartBuilder();
        chartBuilder.showClassificationChart(line, points);
        */

        int totalLayers = 5;
        int neuronsPerLayer = 5;

        Network neuralNetwork = new Network(totalLayers, neuronsPerLayer);
        neuralNetwork.training(null);


        System.out.println("Finish training!");
    }

}
