package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 9, 9},
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
//        int result = 0;
//        int result1 = 0;
//        int max = 0;
//        Scanner sc = new Scanner(System.in);
//        int row = sc.nextInt();
//        int column = sc.nextInt();
//        int[][]array = new int[row][column];
//        for (int i = 0; i < array.length ; i++) {
//            for (int j = 0; j < array[i].length ; j++) {
//                array[i][j] = sc.nextInt();
//            }
//        }
//        max = array[0][0];
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                if(array[i][j] > max){
//                    result = i;
//                    result1 = j;
//                    max = array[i][j];
//            }
//
//            }
//        }
//        System.out.print(result + " " + result1);

        Academy.reverse(array);
    }
}
