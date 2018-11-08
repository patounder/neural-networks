package main.cl.uchile.dcc.neural.networks.service.tarea.layers;

import main.cl.uchile.dcc.neural.networks.service.tarea.neurons.SigmoidNeuron;
import main.cl.uchile.dcc.neural.networks.service.tarea.output.NeuronOutput;

import java.util.List;

public class Layer {

    private LayerType layerType;
    private List<SigmoidNeuron> neurons;

    public Layer() {
        super();
    }

    public Layer(LayerType layerType, List<SigmoidNeuron> neurons) {
        this.layerType = layerType;
        this.neurons = neurons;
    }

    public LayerType getLayerType() {
        return layerType;
    }

    public void setLayerType(LayerType layerType) {
        this.layerType = layerType;
    }

    public List<SigmoidNeuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(List<SigmoidNeuron> neurons) {
        this.neurons = neurons;
    }

    @Override
    public String toString() {
        return "Layer{" +
                "layerType=" + layerType +
                ", neurons=" + neurons +
                '}';
    }
}
