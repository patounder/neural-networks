package main.cl.uchile.dcc.neural.networks.service;

import java.util.Arrays;
import java.util.List;

public class PerceptonBuilder {

    private static List<Double> nandWeights = Arrays.asList(-2.0, -2.0);
    private static List<Double> orWeights = Arrays.asList(7.0, 7.0);
    private static List<Double> andWeights = Arrays.asList(2.0, 2.0);

    private static int nandBias = 4;
    private static int orBias = -5;
    private static int andBias = -3;

    public static Perceptron getNandPerceptron(){
        return new Perceptron(nandWeights, nandBias);
    }

    public static Perceptron getOrPerceptron(){
        return new Perceptron(orWeights, orBias);
    }

    public static Perceptron getAndPerceptron(){
        return new Perceptron(andWeights, andBias);
    }
}
