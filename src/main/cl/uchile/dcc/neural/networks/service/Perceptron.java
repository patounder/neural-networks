package main.cl.uchile.dcc.neural.networks.service;

import main.cl.uchile.dcc.neural.networks.service.dto.Line;
import main.cl.uchile.dcc.neural.networks.service.dto.Point;

import java.util.List;

public class Perceptron extends NeuralBehavior {

    private double learningRate = 0.1;

    public Perceptron(List<Double> weights, double bias) {
        super(weights, bias);
    }

    /**
     * Decide perceptron's output
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
    public void lineBasedTraining(Line line) {
        List<Point> trainingPointList = PointFactory.getRandomTrainingPoints(line);

        trainingPointList.forEach(pointList -> {
            List<Double> inputs = List.of(pointList.getAbscissa(), pointList.getOrdinate());
            double desiredOutput = feed(inputs);
            double diff = desiredOutput - pointList.getClassification();

            //Adjust weights
            for(int i = 0; i < this.getWeights().size(); i++){
                double newWeight = this.getWeights().get(i) + (learningRate * inputs.get(i) * diff);
                this.getWeights().set(i, newWeight);
            }

            //Adjust bias
            double newBias = this.getBias() + (learningRate * diff);
            this.setBias(newBias);
        });
    }

}
