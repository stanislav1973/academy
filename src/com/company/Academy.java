package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Academy {
    String findMaximumElementMatrix(int[][] arr) {
        int row = 0;
        int column = 0;
        int max = arr[0][0];

        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr[k].length; l++) {
                if (arr[k][l] > max) {
                    row = k;
                    column = l;
                    max = arr[k][l];
                }
            }
        }
        return row + " " + column;
    }

    public static void reverse(int[][] array) {

        int[][] arr = new int[3][4];
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = array[i].length - 1; j >= 0; j--) {
                arr[i][count] = array[i][j];
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                array[i][j] = arr[i][j];
            }
        }
    }
//
    public static int printRow(int[][] array, int number) {
        int row = 0;
        for (int i = 0; i < array.length; i++) {
            int t = 1;
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j - 1] + array[i][j] == 0) {
                    t++;
                } if (t >= number) {
                    row = i + 1;
                }
                else if (array[i][j - 1] < array[i][j]) {
                    t = 1;
                }
            }
            if (row == i + 1) {
                break;
            }
        }
        return row;
    }
    public void testMain(){
        int result = 0;
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int[][]array = new int[row][column];
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int number = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            int t = 1;
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j - 1] + array[i][j] == 0) {
                    t++;
                }
                if(t >= number){
                    result = i + 1;
                }
                else if (array[i][j - 1] < array[i][j]) {
                    t = 1;
                }
            }
            if (result == i + 1) {
                break;
            }
        }
        System.out.print(result);
    }
}