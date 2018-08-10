package com.hai.advance;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    private List<Double[][]> weights;
    private List<Double[]> biases;
    private List<Double[]> trainingSetInput;
    private List<Double[]> trainingSetOutput;
    private DataLoader loader;
    private int inputSize;
    private int hiddenSize;
    private int outputSize;

    public NeuralNetwork(int inputSize, int hiddenSize, int outputSize) {
        this.inputSize = inputSize;
        this.hiddenSize = hiddenSize;
        this.outputSize = outputSize;
    }

    public static List<Double[]> sigmoid(List<Double[]> matrix) {
        List<Double[]> temp = new ArrayList<>();
        for(Double[] m : matrix){
            Double[] n = new Double[m.length];
            for(int i = 0; i<m.length; i++){
                n[i] = 1/(1 +  Math.exp(m[i] * -1));
            }
            temp.add(n);
        }
        return temp;
    }

    public List<Double[]> getOutput(List<Double[]> trainingSetInput, List<Double[][]> weights, List<Double[]> biases){
        List<Double[]> output = MatrixUtil.add(MatrixUtil.dot(trainingSetInput, weights), biases);
        return sigmoid(output);
    }

    public List<Double[]> getError(List<Double[]> output, List<Double[]> trainingSetOutput){
        return MatrixUtil.subtract(trainingSetOutput, output);
    }

    public List<Double[]> getGradient(List<Double[]> x){
        List<Double[]> temp = new ArrayList<>();
        for(int i = 0; i<x.size(); i++){
            Double[] n = new Double[x.size()];
            Double[] a = x.get(i);
            for(int j = 0; j < n.length; j++){
                n[j] = a[j] * (1 - a[j]);
            }
            temp.add(n);
        }

        return temp;
    }

    public void adjust(List<Double[]> error, List<Double[]> gradient){

    }

    public void train(int count){
        for(int i = 0; i<count; i++){
            List<Double[]> output = getOutput(trainingSetInput, weights, biases);
            List<Double[]> error = getError(output, trainingSetOutput);
            List<Double[]> gradient = getGradient(output);
            adjust(error, gradient);

        }
    }

    public void init(){

        //init weights and biases
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

        //load training data
        loader = new DataLoader();
        loader.loadTrainingData("data/iris.txt", inputSize, outputSize);
        trainingSetInput = loader.getTrainingSetInput();
        trainingSetOutput = loader.getTrainingSetOutput();

        System.out.println("DONE INIT");
    }
}
