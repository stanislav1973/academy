package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static long sumInRange(int from, int to){
        long result = 0;
        int range = to - from;
        for (int i = 0; i < range; i++) {
            result = (from + i) + result;
        }
        return result;
    }
    public static void main(String[] args) {
   Academy_1.subtractTwoNumbers(2,0);
    }
}
