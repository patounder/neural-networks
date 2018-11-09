package main.cl.uchile.dcc.neural.networks.service.tarea;

import main.cl.uchile.dcc.neural.networks.service.tarea.layers.Layer;
import main.cl.uchile.dcc.neural.networks.service.tarea.layers.LayerType;
import main.cl.uchile.dcc.neural.networks.service.tarea.neurons.SigmoidNeuron;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Layer> layerList;
    private int totalLayers;
    private int neuronsPerLayer;


    public Network(int layersQuantity, int neuronsPerLayer) {
        this.totalLayers = layersQuantity;
        this.neuronsPerLayer = neuronsPerLayer;
        buildNetworkLayers();
    }

    public void buildNetworkLayers(){

        if(this.totalLayers <= 2){
            System.out.println("Total layers must be greater than two");
            return;
        }

        List<Double> inputsNetwork = new ArrayList<>(); //TODO change for original values
        Layer inputLayer = buildInputLayer(inputsNetwork);

        layerList = new ArrayList<>(this.totalLayers);
        layerList.add(inputLayer);

        int noHiddenLayersNumber = 2; //One for inputs and one for outputs layers;
        int hiddenLayersNumber = totalLayers - noHiddenLayersNumber;

        Layer auxHiddenLayer;
        for (int i = 1; i < hiddenLayersNumber; i++){
            auxHiddenLayer = buildHiddenLayer();
            layerList.add(auxHiddenLayer);
        }

        Layer outputLayer = buildOutputLayer();
        layerList.add(outputLayer);
    }

    private Layer buildInputLayer(List<Double> inputs){ Layer inputLayer = new Layer();
        inputLayer.setLayerType(LayerType.INPUT);

        List<SigmoidNeuron> neuronList = new ArrayList<>(inputs.size());
        SigmoidNeuron auxNeuron;

        for(Double input : inputs){
            auxNeuron = new SigmoidNeuron(null, 2); //TODO replace weights y bias
            auxNeuron.setOutput(input);
            neuronList.add(auxNeuron);
        }

        inputLayer.setNeurons(neuronList);
        return inputLayer;
    }

    private Layer buildHiddenLayer(){
        Layer hiddenLayer = new Layer();
        hiddenLayer.setLayerType(LayerType.HIDDEN);
        hiddenLayer.setNeurons(new ArrayList<>(this.neuronsPerLayer));
        return hiddenLayer;
    }

    private Layer buildOutputLayer(){
        Layer outputLayer = new Layer();
        outputLayer.setLayerType(LayerType.OUTPUT);
        int defaultNeuronsNumbers = 1;
        outputLayer.setNeurons(new ArrayList<>(defaultNeuronsNumbers));
        return outputLayer;
    }

    public void training(){
        feeding();
        //TODO backward propagation
        //TODO update biases y weights
    }

    private void feeding(){
        for (int i = 1; i < this.layerList.size(); i++){
            setLayerOutputs(i);
        }
    }

    private void setLayerOutputs(int layerIndex){
        Layer selectedLayer = this.layerList.get(layerIndex);
        List<Double> inputsLayer = getPreviousLayerOutputs(layerIndex);
        selectedLayer.getNeurons().forEach(neuron -> {
            Double output = neuron.feed(inputsLayer);
            neuron.setOutput(output);
        });
    }

    private List<Double> getPreviousLayerOutputs(int layerIndex){

        int previousLayerIndex = layerIndex - 1;
        Layer selectedLayer = this.layerList.get(previousLayerIndex);

        List<Double> outputs = new ArrayList<>(selectedLayer.getNeurons().size());

        for(SigmoidNeuron neuron : selectedLayer.getNeurons()){
            outputs.add(neuron.getOutput());
        }

        return outputs;
    }
}
