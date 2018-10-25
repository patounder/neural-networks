package cl.uchile.dcc.neural.networks;

import java.util.Arrays;
import java.util.List;

public class PerceptonBuilder {

    List<Double> nandWeights = Arrays.asList(-2.0, -2.0);
    List<Double> orWeights = Arrays.asList(7.0, 7.0);
    List<Double> andWeights = Arrays.asList(2.0, 2.0);

    int nandBias = 1;
    int orBias = -5;
    int andBias = -3;

    public Perceptron getNandPerceptron(){
        return new Perceptron(nandWeights, nandBias);
    }

    public Perceptron getOrPerceptron(){
        return new Perceptron(orWeights, orBias);
    }

    public Perceptron getAndPerceptron(){
        return new Perceptron(andWeights, andBias);
    }
}
