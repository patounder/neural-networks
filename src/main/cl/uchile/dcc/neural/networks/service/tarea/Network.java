package main.cl.uchile.dcc.neural.networks.service.tarea;

import main.cl.uchile.dcc.neural.networks.service.tarea.layers.Layer;
import main.cl.uchile.dcc.neural.networks.service.tarea.layers.LayerType;
import main.cl.uchile.dcc.neural.networks.service.tarea.layers.TrainingInput;
import main.cl.uchile.dcc.neural.networks.service.tarea.neurons.SigmoidNeuron;

import java.util.ArrayList;
import java.util.List;

public class Network {

    public static final int FIRST_ELEMENT = 0;
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

        TrainingInput trainingInput = new TrainingInput(); //TODO change for original values
        Layer inputLayer = buildInputLayer(trainingInput.getInputsValues().size());

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

    private Layer buildInputLayer(int sizeInput){
        Layer inputLayer = new Layer();
        inputLayer.setLayerType(LayerType.INPUT);

        List<SigmoidNeuron> neuronList = new ArrayList<>(sizeInput);
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

    public void training(TrainingInput trainingInput){
        feeding(trainingInput);
        //TODO backward propagation
        //TODO update biases y weights
    }

    private void feeding(TrainingInput trainingInput){
        //Training first layer
        SigmoidNeuron auxNeuron;
        for(int i = 0; i < trainingInput.getInputsValues().size(); i++){
            auxNeuron = new SigmoidNeuron(null, 2); //TODO replace weights y bias
            auxNeuron.setOutput(trainingInput.getInputsValues().get(i));
            this.layerList.get(FIRST_ELEMENT).getNeurons().add(i, auxNeuron);
        }

        for (int i = 1; i < this.layerList.size(); i++){
            setLayerOutputs(i);
        }
    }

    private void setLayerOutputs(int layerIndex){
        Layer selectedLayer = this.layerList.get(layerIndex);
        List<Double> inputsLayer = getPreviousLayerOutputs(layerIndex);
        selectedLayer.getNeurons().forEach(neuron -> {
            neuron = new SigmoidNeuron(null, 2); //TODO replace weights y bias
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

    private void backwardPropagation(TrainingInput trainingInput){
        //Last layer
        Layer lastLayer = this.layerList.get(this.layerList.size() - 1);
        double networkOutput = lastLayer.getNeurons().get(FIRST_ELEMENT).getOutput();
        double error = trainingInput.getExpectedOutput() - networkOutput;
        double delta = error * transferDerivative(networkOutput);

        //Hidden layers
        for(int i = this.layerList.size() - 2; i >= 0; i--){

        }
    }

    private double normalization(double input, double minValue, double maxValue){
        return (double) (input - minValue) / (maxValue - minValue);
    }

    private double transferDerivative(double output){
        return output  * (1.0 - output);
    }

}
