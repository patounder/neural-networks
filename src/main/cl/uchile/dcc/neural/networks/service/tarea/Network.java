package main.cl.uchile.dcc.neural.networks.service.tarea;

import main.cl.uchile.dcc.neural.networks.service.tarea.layers.Layer;
import main.cl.uchile.dcc.neural.networks.service.tarea.layers.LayerType;
import main.cl.uchile.dcc.neural.networks.service.tarea.neurons.SigmoidNeuron;

import java.util.ArrayList;
import java.util.Collections;
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

        //TODO create hidden layers
        //TODO create output layer

    }

    private Layer buildInputLayer(List<Double> inputs){
        Layer inputLayer = new Layer();
        inputLayer.setLayerType(LayerType.INPUT);

        List<SigmoidNeuron> neuronList = new ArrayList<>(inputs.size());
        SigmoidNeuron auxNeuron;

        for(Double input : inputs){
            auxNeuron = new SigmoidNeuron();
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

    public void training(){
        //TODO forward feeeding
        //TODO backward propagation
        //TODO update biases y weights
    }
}
