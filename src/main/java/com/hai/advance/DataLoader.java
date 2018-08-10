package com.hai.advance;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DataLoader {
    private List<Double[]> trainingSetInput;
    private List<Double[]> trainingSetOutput;
    private List<Double[]> testSetInput;
    private List<Double[]> testSetOutput;
    private HashMap<String, Double[]> hashMap = new HashMap<>();

    public void loadTrainingData(String dataPath, int inputSize, int outputSize){

        trainingSetInput = new ArrayList<>();
        trainingSetOutput = new ArrayList<>();
        testSetInput = new ArrayList<>();
        testSetOutput = new ArrayList<>();

        hashMap.put("Iris-setosa", new Double[]{1., 0., 0.});
        hashMap.put("Iris-versicolor", new Double[]{0., 1., 0.});
        hashMap.put("Iris-virginica", new Double[]{0., 0., 1.});
        try{
            Scanner sc = new Scanner(new File(dataPath));
            int n = 0;
            while (sc.hasNextLine()){
                String[] data = sc.nextLine().split(",");
                double x0 = Double.parseDouble(data[0]);
                double x1 = Double.parseDouble(data[1]);
                double x2 = Double.parseDouble(data[2]);
                double x3 = Double.parseDouble(data[3]);
                String s = data[4];
                if(n%50 < 45) {
                    trainingSetInput.add(new Double[]{x0, x1, x2, x3});
                    trainingSetOutput.add(hashMap.get(s));
                }else {
                    testSetInput.add(new Double[]{x0, x1, x2, x3});
                    testSetOutput.add(hashMap.get(s));
                }
                n++;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Double[]> getTrainingSetInput() {
        return trainingSetInput;
    }

    public List<Double[]> getTrainingSetOutput() {
        return trainingSetOutput;
    }

    public List<Double[]> getTestSetInput() {
        return testSetInput;
    }

    public List<Double[]> getTestSetOutput() {
        return testSetOutput;
    }
}
