package cl.uchile.dcc.neural.networks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Perceptron extends NeuralBehavior{

    public Perceptron(List<Double> weights, double bias) {
        super(weights, bias);
    }

    /**
     * Decide perceptron's output
     * @param inputs
     * @return
     */
    @Override public double feed(List<Integer> inputs) {
        List<Double> pointResult = multList(inputs, getWeights());
        int sumPointResult = pointResult.stream().mapToInt(Double::intValue).sum();
        double output = sumPointResult + getBias();

        if(output <= 0){
            return 0;
        }

        return 1;
    }

}
