package main.cl.uchile.dcc.neural.networks.service;

import main.cl.uchile.dcc.neural.networks.service.NeuralBehavior;
import main.cl.uchile.dcc.neural.networks.service.dto.Point;

import java.util.List;

public class Perceptron extends NeuralBehavior {

    public Perceptron(List<Double> weights, double bias) {
        super(weights, bias);
    }

    /**
     * Decide perceptron's output
     * @param inputs
     * @return
     */
    @Override public double feed(List<Double> inputs) {
        List<Double> pointResult = multList(inputs, this.getWeights());
        double sumPointResult = pointResult.stream().mapToInt(Double::intValue).sum();
        double output = sumPointResult + getBias();

        if(output <= 0){
            return 0;
        }

        return 1;
    }

    @Override
    void train() {
        List<Point> trainingPointList = PointFactory.getRandomPoints();
        //TODO set classification for training points
        //TODO apply training
    }

}
