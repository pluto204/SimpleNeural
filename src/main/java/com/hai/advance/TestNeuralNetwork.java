package com.hai.advance;

public class TestNeuralNetwork {
    public static void main(String[] args) {
        NeuralNetwork network = new NeuralNetwork(4,5,3);
        network.init();
        network.train(1000);
        System.out.println("FINISH");
    }
}
