package com.hai;

public class NeuralNetwork {

    double[] weights = {0.25, 0.25, 0.25};
    double[][] trainingSetInput = {{0.,0.,1.}, {1.,1.,1.}, {1.,0.,1.}, {0.,1.,1.}};
    double[] trainingSetOutput = {0.,1.,1.,0.};

    public double[] getWeights() {
        return weights;
    }

    public double[][] getTrainingSetInput() {
        return trainingSetInput;
    }

    public double[] getTrainingSetOutput() {
        return trainingSetOutput;
    }

    public NeuralNetwork(){

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
        return temp;
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

    public void train(int count){
        for(int i = 0; i<count; i++){
            double[] output = sigmoid(getOutput(trainingSetInput, weights));
            double[] error = getError(output, trainingSetOutput);

            double[] temp = getSigmoidGradient(output);
            double[] temp1 = new double[error.length];

            for (int j = 0; j < error.length; j++){
                temp1[j] = error[j] * temp[j];
            }

            int size = weights.length;
            int tempSize = trainingSetInput.length;
            double[] adjustment = new double[size];
            for(int k = 0; k< size; k++){
                double t = 0;
                for (int j = 0; j < tempSize; j++){
                    t += trainingSetInput[j][k] * temp1[j];
                }
                adjustment[k] = t;
            }

            for(int j = 0; j<adjustment.length; j++){
                weights[j] += adjustment[j];
            }
        }

    }

}
