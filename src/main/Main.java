package main;

import main.cl.uchile.dcc.neural.networks.service.PerceptonBuilder;
import main.cl.uchile.dcc.neural.networks.service.Perceptron;
import main.cl.uchile.dcc.neural.networks.service.PointFactory;
import main.cl.uchile.dcc.neural.networks.service.dto.Line;
import main.cl.uchile.dcc.neural.networks.service.dto.Point;
import main.cl.uchile.dcc.neural.networks.service.services.ChartBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static final int INTERSECTION_VALUE = 2;
    public static final int SLOPE_VALUE = 1;

    public static void main(String[] args) {
        Perceptron perceptron = PerceptonBuilder.getNandPerceptron();

        Line line = new Line(INTERSECTION_VALUE, SLOPE_VALUE);
        perceptron.lineBasedTraining(line);

        List<Point> points = PointFactory.getRandomPoints(4);

        points.forEach( point -> {
            double pointClassification = perceptron.feed(Arrays.asList(point.getAbscissa(), point.getOrdinate()));
            point.setClassification((int) pointClassification);
        });

        ChartBuilder chartBuilder = new ChartBuilder();
        chartBuilder.showClassificationChart(line, points);
    }

}
