package cl.uchile.dcc.neural.networks;

import java.util.ArrayList;
import java.util.List;

public abstract class NeuralBehavior {

    private List<Double> weights;
    private double bias;

    public NeuralBehavior(List<Double> weights, double bias) {
        this.weights = weights;
        this.bias = bias;
    }

    abstract double feed(List<Integer> inputs);

    abstract void train(List<Point> points);

    public List<Double> multList(List<Integer> inputs, List<Double> weights){
        List<Double> pointResult = new ArrayList<>();
        Double element;

        for(int i = 0; (i < inputs.size() && i< weights.size()) ; i++){
            element = inputs.get(i) * weights.get(i);
            pointResult.add(element);
        }

        return pointResult;
    }

    public List<Double> getWeights(){
        return this.weights;
    }

    public double getBias(){
        return this.bias;
    }

    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }
}
