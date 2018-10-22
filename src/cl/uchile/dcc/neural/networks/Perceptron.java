package cl.uchile.dcc.neural.networks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Perceptron extends NeuralBehavior{

    public Perceptron(List<Double> weights, double bias) {
        super(weights, bias);
    }

    @Override public double feed(List<Integer> inputs) {
        List<Double> pointResult = multList(inputs, getWeights());
        int sumPointResult = pointResult.stream().mapToInt(Double::intValue).sum();
        double output = sumPointResult + getBias();

        if(output <= 0){
            return 0;
        }

        return 1;
    }

    @Override public void train(List<Point> points) {

        points.forEach(point -> {
            List<Integer> inputs = Arrays.asList(point.getX(), point.getY());
            double realOutput = feed(inputs);
            double diff = point.getClassification() - realOutput;
            double lr = 0.1;

            for(int i = 0; i < getWeights().size(); i++){
                double oldWeight = getWeights().get(i);
                double newWeight = oldWeight + (lr * diff * inputs.get(i));
                getWeights().set(i, newWeight);
                setBias(getBias() + (lr * diff));
            }
        });

    }
}
