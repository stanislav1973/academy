package com.company;

public class Academy {
    public static double sqrt(double x) {
        if(x < 0){
            throw new IllegalArgumentException("Expected non-negative number, got" + x);
        }
        double b = Math.sqrt(x);

        return b;
    }
}
