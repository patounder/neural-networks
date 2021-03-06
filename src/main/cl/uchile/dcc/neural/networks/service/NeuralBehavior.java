package main.cl.uchile.dcc.neural.networks.service;

import java.util.ArrayList;
import java.util.List;

public abstract class NeuralBehavior {

    private List<Double> weights;
    private double bias;

    public NeuralBehavior(List<Double> weights, double bias) {
        this.weights = weights;
        this.bias = bias;
    }

    abstract double feed(List<Double> inputs);

    public List<Double> multList(List<Double> inputs, List<Double> weights){
        List<Double> pointResult = new ArrayList<>();
        Double element;

        for(int i = 0; (i < inputs.size() && i< weights.size()) ; i++){
            element = inputs.get(i) * weights.get(i);
            pointResult.add(element);
        }

        return pointResult;
    }

    public List<Double> getWeights(){
        return weights;
    }

    public double getBias(){
        return bias;
    }

    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }
}
