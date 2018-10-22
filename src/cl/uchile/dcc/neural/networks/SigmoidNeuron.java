package cl.uchile.dcc.neural.networks;

import java.util.ArrayList;
import java.util.List;

public class SigmoidNeuron extends NeuralBehavior {

    public SigmoidNeuron(List<Double> weights, double bias) {
        super(weights, bias);
    }

    @Override public double feed(List<Integer> inputs) {
        List<Double> pointResult = multList(inputs, getWeights());
        int sumPointResult = pointResult.stream().mapToInt(Double::intValue).sum();
        double expResult = Math.exp(- sumPointResult - getBias());
        return 1 + expResult;
    }

    @Override public void train(List<Point> points) {

    }

}
