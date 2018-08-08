package com.hai;

public class TestNeural {
    public static void main(String[] args) {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        neuralNetwork.train(10000);
        double[] weights = neuralNetwork.getWeights();
        for (double w : weights){
            System.out.println(w);
        }

        double[][] testingSetInput = {{1.,0.,1.}, {0.,1.,1.}, {1.,1.,1.}, {1.,1.,1.}};
        System.out.println("__________________________________");
        double[] testingOutput = neuralNetwork.sigmoid(neuralNetwork.getOutput(testingSetInput, neuralNetwork.getWeights()));
        for(double t : testingOutput){
            System.out.println(t);
        }
    }
}
