package main.cl.uchile.dcc.neural.networks.service.tarea.neurons;

import main.cl.uchile.dcc.neural.networks.service.tarea.inputs.NeuronInput;
import main.cl.uchile.dcc.neural.networks.service.tarea.output.NeuronOutput;

import java.util.List;

//TODO replqce when finish rigth version
//TODO extends to NeuralBehavior
public class SigmoidNeuron {

    private double output;
    private List<NeuronInput> inputs;
    private List<SigmoidNeuron> targetNeurons;

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
