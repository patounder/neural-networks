package main.cl.uchile.dcc.neural.networks.service.tarea.layers;

import java.util.List;

public class TrainingInput {

    private double expectedOutput;
    private List<Double> inputsValues;

    public TrainingInput() {
    }

    public TrainingInput(double expectedOutput, List<Double> inputsValues) {
        this.expectedOutput = expectedOutput;
        this.inputsValues = inputsValues;
    }

    public double getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(double expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public List<Double> getInputsValues() {
        return inputsValues;
    }

    public void setInputsValues(List<Double> inputsValues) {
        this.inputsValues = inputsValues;
    }
}
