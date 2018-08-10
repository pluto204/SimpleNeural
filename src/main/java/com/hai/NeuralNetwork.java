package com.hai;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    List<Double[][]> weights;
    List<Double[]> biases;
    Double[][] trainingSetInput;
    Double[][] trainingSetOutput;
    DataLoader loader;

    public NeuralNetwork(int inputSize, int hiddenSize, int outputSize){

        init(inputSize, hiddenSize, outputSize);

    }

    public void init(int inputSize, int hiddenSize, int outputSize){
        weights = new ArrayList<>();
        biases = new ArrayList<>();

        Double[][] weightValues1 = new Double[inputSize][hiddenSize];
        Double[] biasValues1 = new Double[hiddenSize];
        for (int k = 0; k<hiddenSize; k++) {
            biasValues1[k] = 0.;
            for (int q = 0; q<inputSize; q++){
                weightValues1[q][k] = 0.;
            }
        }

        Double[][] weightValues2 = new Double[hiddenSize][outputSize];
        Double[] biasValues2 = new Double[outputSize];
        for (int k = 0; k<outputSize; k++) {
            biasValues2[k] = 0.;
            for (int q = 0; q<hiddenSize; q++){
                weightValues2[q][k] = 0.;
            }
        }

        weights.add(weightValues1);
        weights.add(weightValues2);
        biases.add(biasValues1);
        biases.add(biasValues2);

        loader = new DataLoader();
        loader.loadTrainingData("data/iris.txt", inputSize, outputSize);
        trainingSetInput = loader.getTrainingSetInput();
        trainingSetOutput = loader.getTrainingSetOutput();

        System.out.println("DONE INIT");
    }
}
