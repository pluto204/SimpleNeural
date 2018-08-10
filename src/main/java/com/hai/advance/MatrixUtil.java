package com.hai.advance;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtil {

    public static List<Double[]> dot(List<Double[]> matA, List<Double[][]> matB){
        return null;
    }

    public static List<Double[]> add(List<Double[]> matA, List<Double[]> matB){
        List<Double[]> temp = new ArrayList<>();
        for(int i = 0; i<matA.size(); i++){
            Double[] a = matA.get(i);
            Double[] b = matB.get(i);
            Double[] n = new Double[a.length];
            for(int j = 0; j < a.length; j++){
                n[j] = a[j] + b[j];
            }
            temp.add(n);
        }

        return temp;
    }

    public static List<Double[]> subtract(List<Double[]> matA, List<Double[]> matB){
        List<Double[]> temp = new ArrayList<>();
        for(int i = 0; i<matA.size(); i++){
            Double[] a = matA.get(i);
            Double[] b = matB.get(i);
            Double[] n = new Double[a.length];
            for(int j = 0; j < a.length; j++){
                n[j] = b[j] - a[j];
            }
            temp.add(n);
        }

        return temp;
    }
}
