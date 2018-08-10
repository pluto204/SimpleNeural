package com.hai.simple;

public class SimpleNeuralNetwork {

    double[] weights;
    double[][] trainingSetInput;
    double[] trainingSetOutput;

    public double[] getWeights() {
        return weights;
    }

    public SimpleNeuralNetwork(double[][] trainingSetInput, double[] trainingSetOutput, double[] weights) {
        this.trainingSetInput = trainingSetInput;
        this.trainingSetOutput = trainingSetOutput;
        this.weights = weights;
    }

    public double[] sigmoid(double[] x){
        double[] temp = new double[x.length];
        for(int i = 0; i<x.length; i++){
            temp[i] = 1/(1 +  Math.exp(x[i] * -1));
        }
        return temp;
    }

    public double[] getOutput(double[][] input, double[] weights){
        int size = weights.length;
        int tempSize = input.length;
        double[] temp = new double[tempSize];
        for(int i = 0; i< tempSize; i++){
            double k = 0;
            for (int j = 0; j < size; j++){
                k += input[i][j] * weights[j];
            }
            temp[i] = k;
        }
        return sigmoid(temp);
    }

    public double[] getError(double[] output, double[] trainingOutput){
        double[] temp = new double[output.length];
        for(int i = 0; i< output.length; i++){
            temp[i] = trainingOutput[i] - output[i];
        }
        return temp;
    }

    public double[] getSigmoidGradient(double[] x){
        double[] temp = new double[x.length];
        for(int i = 0; i<x.length; i++){
            temp[i] = x[i] * (1-x[i]);
        }
        return temp;
    }

    public void adjust(double[] error, double[] gradient){
        int size = weights.length;
        int tempSize = trainingSetInput.length;

        for(int i = 0; i < size; i++){
            double adjustment = 0;
            for (int j = 0; j < tempSize; j++){
                adjustment += trainingSetInput[j][i] * error[j] * gradient[j];;
            }
            weights[i] += adjustment;
        }
    }

    public void train(int count){
        for(int i = 0; i<count; i++){
            double[] output = getOutput(trainingSetInput, weights);
            double[] error = getError(output, trainingSetOutput);
            double[] gradient = getSigmoidGradient(output);
            adjust(error, gradient);
        }

    }

}