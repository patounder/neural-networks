package main.cl.uchile.dcc.neural.networks.service.tarea;

import main.cl.uchile.dcc.neural.networks.service.PerceptonBuilder;
import main.cl.uchile.dcc.neural.networks.service.Perceptron;
import main.cl.uchile.dcc.neural.networks.service.PointFactory;
import main.cl.uchile.dcc.neural.networks.service.dto.Line;
import main.cl.uchile.dcc.neural.networks.service.dto.Point;
import main.cl.uchile.dcc.neural.networks.service.services.ChartBuilder;
import main.cl.uchile.dcc.neural.networks.service.tarea.layers.TrainingInput;

import java.util.ArrayList;
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

        int totalLayers = 3;
        int neuronsPerLayer = 2;

        TrainingInput trainingInput1 = new TrainingInput(0, Arrays.asList(0.0,0.0));
        TrainingInput trainingInput2 = new TrainingInput(1, Arrays.asList(0.0,1.0));
        TrainingInput trainingInput3 = new TrainingInput(1, Arrays.asList(1.0,0.0));
        TrainingInput trainingInput4 = new TrainingInput(0, Arrays.asList(1.0,1.0));

        List<TrainingInput> trainingInputList = new ArrayList<>(4);
        trainingInputList.add(trainingInput1);
        trainingInputList.add(trainingInput2);
        trainingInputList.add(trainingInput3);
        trainingInputList.add(trainingInput4);

        Network neuralNetwork = new Network(totalLayers, neuronsPerLayer);
        neuralNetwork.training(trainingInputList);

        System.out.println("Finish training!");
    }

}
