package com.hai.simple;

import java.util.Arrays;

public class TestSimpleNeural {
    public static void main(String[] args) {

        double[] weights = {0.25, 0.25, 0.25};
        double[][] trainingSetInput = {{0.,0.,1.}, {1.,1.,1.}, {1.,0.,1.}, {0.,1.,1.}};
        double[] trainingSetOutput = {0.,1.,1.,0.};

        SimpleNeuralNetwork neuralNetwork = new SimpleNeuralNetwork(trainingSetInput, trainingSetOutput, weights);

        neuralNetwork.train(1000);

        System.out.println("WEIGHT AFTER TRAIN");
        System.out.println(Arrays.toString(weights));

//        double[][] testingSetInput = {{1.,0.,1.}, {0.,1.,1.}, {1.,1.,1.}, {1.,1.,1.}};
        double[][] testingSetInput = {{1.,0.,1.}, {0.,1.,1.}};

        System.out.println("________________________________");

        System.out.println("INPUT");
        System.out.println(Arrays.deepToString(testingSetInput));

        System.out.println("________________________________");
        System.out.println("OUTPUT");
        double[] testingOutput = neuralNetwork.getOutput(testingSetInput, neuralNetwork.getWeights());
        System.out.println(Arrays.toString(testingOutput));

    }
}