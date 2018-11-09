package main.cl.uchile.dcc.neural.networks.service.tarea.neurons;

import main.cl.uchile.dcc.neural.networks.service.dto.Line;
import main.cl.uchile.dcc.neural.networks.service.tarea.inputs.NeuronInput;
import main.cl.uchile.dcc.neural.networks.service.tarea.output.NeuronOutput;

import java.util.List;

//TODO replqce when finish rigth version

public class SigmoidNeuron extends NeuralBehavior{

    private double output;
    private List<NeuronInput> inputs;
    private List<SigmoidNeuron> targetNeurons;

    public SigmoidNeuron(List<Double> weights, double bias) {
        super(weights, bias);
    }

    @Override
    public double feed(List<Double> inputs) {
        List<Double> multResult = multList(inputs, this.getWeights());
        Double result = multResult.stream().mapToDouble(Double::doubleValue).sum();
        Double resultExp = Math.exp(- result - this.getBias());
        return  (double) 1 / (1 + resultExp);
    }

    @Override
    public void lineBasedTraining(Line line) {

    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public List<NeuronInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<NeuronInput> inputs) {
        this.inputs = inputs;
    }

    public List<SigmoidNeuron> getTargetNeurons() {
        return targetNeurons;
    }

    public void setTargetNeurons(List<SigmoidNeuron> targetNeurons) {
        this.targetNeurons = targetNeurons;
    }

}
