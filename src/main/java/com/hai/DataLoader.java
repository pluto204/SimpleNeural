package com.hai;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class DataLoader {
    private Double[][] trainingSetInput;
    private Double[][] trainingSetOutput;
    private Double[][] testSetInput;
    private Double[][] testSetOutput;
    private HashMap<String, Double[]> hashMap = new HashMap<>();

    public void loadTrainingData(String dataPath, int inputSize, int outputSize){
        int dataTrainSize = 120;
        int dataTestSize = 30;

        trainingSetInput = new Double[dataTrainSize][];
        trainingSetOutput = new Double[dataTrainSize][];
        testSetInput = new Double[dataTestSize][];
        testSetOutput = new Double[dataTestSize][];

        hashMap.put("Iris-setosa", new Double[]{1., 0., 0.});
        hashMap.put("Iris-versicolor", new Double[]{0., 1., 0.});
        hashMap.put("Iris-virginica", new Double[]{0., 0., 1.});
        try{
            Scanner sc = new Scanner(new File(dataPath));
            int n = 0;
            int n1 = 0;
            int n2 = 0;
            while (sc.hasNextLine()){
                String[] data = sc.nextLine().split(",");
                double x0 = Double.parseDouble(data[0]);
                double x1 = Double.parseDouble(data[1]);
                double x2 = Double.parseDouble(data[2]);
                double x3 = Double.parseDouble(data[3]);
                String s = data[4];
                if(n%50 < 40) {
                    trainingSetInput[n1] = new Double[]{x0, x1, x2, x3};
                    trainingSetOutput[n1] = hashMap.get(s);
                    n1++;
                }else {
                    testSetInput[n2] = new Double[]{x0, x1, x2, x3};
                    testSetOutput[n2] = hashMap.get(s);
                    n2++;
                }
                n++;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Double[][] getTrainingSetInput() {
        return trainingSetInput;
    }

    public Double[][] getTrainingSetOutput() {
        return trainingSetOutput;
    }

    public Double[][] getTestSetInput() {
        return testSetInput;
    }

    public Double[][] getTestSetOutput() {
        return testSetOutput;
    }
}
