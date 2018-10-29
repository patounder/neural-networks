package main.cl.uchile.dcc.neural.networks.service;

import java.util.Arrays;
import java.util.List;

public class PerceptonBuilder {

    private List<Double> nandWeights = Arrays.asList(-2.0, -2.0);
    private List<Double> orWeights = Arrays.asList(7.0, 7.0);
    private List<Double> andWeights = Arrays.asList(2.0, 2.0);

    private int nandBias = 4;
    private int orBias = -5;
    private int andBias = -3;

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
